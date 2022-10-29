package gr.aueb.cf.productsapp.service.exceptions;

import gr.aueb.cf.productsapp.model.Product;

public class ProductIdAlreadyExistsException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ProductIdAlreadyExistsException(Product product) {
		super("Product with id = " + product.getId() + " already exists");
	}
}

