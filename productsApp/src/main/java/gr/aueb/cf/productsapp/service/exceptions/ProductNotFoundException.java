package gr.aueb.cf.productsapp.service.exceptions;

import gr.aueb.cf.productsapp.model.Product;

public class ProductNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public ProductNotFoundException(Product product) {
		super("Product with id = " + product.getId() + " was not found");
	}
}
