package gr.aueb.cf.productsapp.service;

import java.sql.SQLException;

import gr.aueb.cf.productsapp.dto.UserDTO;
import gr.aueb.cf.productsapp.model.User;

public interface IUserService {

	void insertUserService(UserDTO userDTO) throws SQLException;
	User getUserByEmailService(String email) throws SQLException;
	boolean emailAlreadyExistService(String email) throws SQLException;
}
