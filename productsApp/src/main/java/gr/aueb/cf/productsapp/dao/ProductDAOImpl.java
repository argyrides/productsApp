package gr.aueb.cf.productsapp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gr.aueb.cf.productsapp.model.Product;

import static gr.aueb.cf.productsapp.dao.dbutil.DBUtil.openConnection;
import static gr.aueb.cf.productsapp.dao.dbutil.DBUtil.closeConnection;

public class ProductDAOImpl implements IProductDAO {

	@Override
	public void insert(Product product) throws SQLException {
		PreparedStatement pst = null;
		
		try {
			
			String sql = "INSERT INTO PRODUCTS (PRODUCT_NAME, PRODUCT_PRICE) VALUES (?, ?)";

			pst = openConnection().prepareStatement(sql);
			pst.setString(1,  product.getProductName());
			pst.setDouble(2,  product.getPrice());
			
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
	public void delete(Product  product) throws SQLException {
		PreparedStatement pst = null;
		
		try {
			
			//String sql = "DELETE FROM PRODUCTS WHERE ID = " + product.getId();
			
			String sql = "DELETE FROM PRODUCTS WHERE PRODUCT_ID =  ?";
			pst = openConnection().prepareStatement(sql);
			pst.setInt(1,  product.getId());
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
	public void update(Product oldProduct, Product newProduct) throws SQLException {
		PreparedStatement pst = null;
		
		try {
			
			String sql = "UPDATE PRODUCTS SET PRODUCT_NAME = '" + newProduct.getProductName() + "', " + "PRODUCT_PRICE = '" 
					+ newProduct.getPrice() + "' WHERE PRODUCT_ID = " + oldProduct.getId();
			pst = openConnection().prepareStatement(sql);
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
	public List<Product> getProductsByName(String productName) throws SQLException {
		PreparedStatement pst = null;
		List<Product> products = new ArrayList<>();
		ResultSet rs = null;
		
		try {
			
			String sql = "SELECT PRODUCT_ID, PRODUCT_NAME, PRODUCT_PRICE FROM PRODUCTS WHERE PRODUCT_NAME LIKE '" + productName + "%'";
			pst = openConnection().prepareStatement(sql);
			rs =  pst.executeQuery();
				
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("PRODUCT_ID"));
				product.setProductName(rs.getString("PRODUCT_NAME"));
				product.setPrice(rs.getDouble("PRODUCT_PRICE"));
				
				products.add(product);
			}
			
			//if (teachers.size() > 0)  return teachers; else return null;
			return (products.size() > 0) ? products : null;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (openConnection() != null) closeConnection();
		}		
		
	}

	@Override
	public Product getProductById(int id) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		Product product = null;
		
		try {
			
			String sql = "SELECT * FROM PRODUCTS WHERE PRODUCT_ID = " + id;
			
			pst = openConnection().prepareStatement(sql);
			rs =  pst.executeQuery();
				
			if (rs.next()) {
				product = new Product();
				product.setId(rs.getInt("PRODUCT_ID"));
				product.setProductName(rs.getString("PRODUCT_NAME"));
				product.setPrice(rs.getDouble("PRODUCT_PRICE"));
			}
		
			return product;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (openConnection() != null) closeConnection();
		}		
	}

}
