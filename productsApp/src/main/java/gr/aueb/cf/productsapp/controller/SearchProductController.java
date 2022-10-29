package gr.aueb.cf.productsapp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.cf.productsapp.dao.IProductDAO;
import gr.aueb.cf.productsapp.dao.ProductDAOImpl;
import gr.aueb.cf.productsapp.dto.ProductDTO;
import gr.aueb.cf.productsapp.model.Product;
import gr.aueb.cf.productsapp.service.IProductService;
import gr.aueb.cf.productsapp.service.ProductServiceImpl;


@WebServlet("/search")
public class SearchProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IProductDAO productDAO = new ProductDAOImpl();
	IProductService productServ = new ProductServiceImpl(productDAO);
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		String productName = request.getParameter("productName");
		
		// Construct DTO
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductName(productName);
		
		try {
			List<Product> products = productServ.getProductByName(productName);
			if (products != null) {
				request.setAttribute("products", products);
				request.getRequestDispatcher("/jsps/products.jsp").forward(request, response);
			} else {
				request.setAttribute("productsNotFound", true);
				request.getRequestDispatcher("/jsps/productsmenu.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
