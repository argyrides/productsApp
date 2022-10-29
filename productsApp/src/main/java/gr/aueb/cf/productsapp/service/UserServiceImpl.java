package gr.aueb.cf.productsapp.service;

import java.sql.SQLException;

import gr.aueb.cf.productsapp.dao.IUserDAO;
import gr.aueb.cf.productsapp.dto.UserDTO;
import gr.aueb.cf.productsapp.model.User;

public class UserServiceImpl implements IUserService {

	private final IUserDAO userDAO;
	
	public UserServiceImpl(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	public void insertUserService(UserDTO userDTO) throws SQLException {
		
		User user = new User();
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		
		try {
			userDAO.insertUser(user);
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public User getUserByEmailService(String email) throws SQLException {
		try {
			return userDAO.getUserByEmail(email);
		} catch (SQLException e) {
			throw e;
		}
		
	}

	@Override
	public boolean emailAlreadyExistService(String email) throws SQLException {
		try {
			return userDAO.emailAlreadyExist(email);
		} catch (SQLException e) {
			throw e;
		}
	}

}
