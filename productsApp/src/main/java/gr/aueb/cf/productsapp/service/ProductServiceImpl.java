package gr.aueb.cf.productsapp.service;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.cf.productsapp.dao.IProductDAO;
import gr.aueb.cf.productsapp.dto.ProductDTO;
import gr.aueb.cf.productsapp.model.Product;

public class ProductServiceImpl implements IProductService {
	
	private final IProductDAO productDAO;
	
	public ProductServiceImpl(IProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	@Override
	public void insertProduct(ProductDTO productDTO) throws SQLException {
		
		// Extract dto 
		Product product = new Product();
		product.setProductName(productDTO.getProductName());
		product.setPrice(productDTO.getPrice());
		
		try {
			productDAO.insert(product); 
		} catch (SQLException e) {
			throw e;
		}
		
	}

	@Override
	public void deleteProduct(ProductDTO productDTO) throws SQLException {  
		Product productToDelete = new Product();
		productToDelete.setId(productDTO.getId());
		
		try {
			productDAO.delete(productToDelete);	
		} catch (SQLException e) { 
			throw e;
		}
	}

	@Override
	public void updateProduct(ProductDTO oldProductDTO, ProductDTO newProductDTO)
			throws SQLException { 
		
		// extract DTO
		Product productToUpdate = new Product();
		productToUpdate.setId(oldProductDTO.getId());
		
		Product newProduct = new Product();
		newProduct.setProductName(newProductDTO.getProductName());
		newProduct.setPrice(newProductDTO.getPrice());
		
		
		// Forward to DAO
		try {
			productDAO.update(productToUpdate, newProduct);
		} catch (SQLException e) { 
			throw e;
		}
	}

	@Override
	public List<Product> getProductByName(String pName) throws SQLException {
		try {
			return productDAO.getProductsByName(pName);
		} catch (SQLException e) {
			throw e;
		}
	}

}