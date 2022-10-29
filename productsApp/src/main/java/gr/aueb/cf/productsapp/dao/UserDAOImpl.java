package gr.aueb.cf.productsapp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static gr.aueb.cf.productsapp.dao.dbutil.DBUtil.openConnection;
import static gr.aueb.cf.productsapp.dao.dbutil.DBUtil.closeConnection;

import gr.aueb.cf.productsapp.model.User;

public class UserDAOImpl implements IUserDAO {

	@Override
	public void insertUser(User user) throws SQLException {
		PreparedStatement pst = null;
		
		try {
			String sql = "INSERT INTO USERS (USER_EMAIL, USER_PASSWORD) VALUES (?, ?)";
			
			pst = openConnection().prepareStatement(sql);
			pst.setString(1, user.getEmail());
			pst.setString(2, user.getPassword());
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (openConnection() != null) closeConnection();
		}
		
	}

	@Override
	public User getUserByEmail(String email) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		User user = null;
		
		try {
			
			String sql = "SELECT USER_ID, USER_EMAIL, USER_PASSWORD FROM USERS WHERE USER_EMAIL LIKE '%" + email + "%'";
			
			pst = openConnection().prepareStatement(sql);
			rs =  pst.executeQuery();
				
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("USER_ID"));
				user.setEmail(rs.getString("USER_EMAIL"));
				user.setPassword(rs.getString("USER_PASSWORD"));
			}
		
			return user;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (openConnection() != null) closeConnection();
		}		
		
	}

	@Override
	public boolean emailAlreadyExist(String email) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		int rowCount = -1;
		try {
			
			String sql = "SELECT COUNT(*) AS recordCount FROM USERS WHERE USER_EMAIL LIKE '%" + email + "%'";
			
			pst = openConnection().prepareStatement(sql);
			rs =  pst.executeQuery();
			rs.next();
		    rowCount = rs.getInt("recordCount");
			
		    if (rowCount > 0) {
				return true;
			}
		
			return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (openConnection() != null) closeConnection();
		}		
	}

	
}
