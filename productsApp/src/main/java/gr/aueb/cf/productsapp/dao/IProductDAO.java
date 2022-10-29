package gr.aueb.cf.productsapp.dao;

import java.sql.SQLException;
import java.util.List;
import gr.aueb.cf.productsapp.model.Product;


public interface IProductDAO {
	void insert(Product product) throws SQLException;
	void delete(Product product) throws SQLException;
	void update(Product oldProduct, Product newProduct) throws SQLException;
	List<Product> getProductsByName(String pName) throws SQLException;
	Product getProductById(int id) throws SQLException;
}
