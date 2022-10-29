package gr.aueb.cf.productsapp.dao;

import java.sql.SQLException;

import gr.aueb.cf.productsapp.model.User;

public interface IUserDAO {

	void insertUser(User user) throws SQLException;
	User getUserByEmail(String email) throws SQLException;
	boolean emailAlreadyExist(String email) throws SQLException;
}
