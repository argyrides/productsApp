package gr.aueb.cf.productsapp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.cf.productsapp.dao.IProductDAO;
import gr.aueb.cf.productsapp.dao.ProductDAOImpl;
import gr.aueb.cf.productsapp.dto.ProductDTO;
import gr.aueb.cf.productsapp.service.IProductService;
import gr.aueb.cf.productsapp.service.ProductServiceImpl;

@WebServlet("/delete")
public class DeleteProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IProductDAO productDAO = new ProductDAOImpl();
	IProductService productServ = new ProductServiceImpl(productDAO);
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		
		// Get the data
		int id = Integer.parseInt(request.getParameter("id").trim());
		String productName = request.getParameter("pName");
		double productPrice = Double.parseDouble(request.getParameter("price"));
		
		// Construct DTO
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(id);
		productDTO.setProductName(productName);
		productDTO.setPrice(productPrice);
		
		// Call the service
		try {
			productServ.deleteProduct(productDTO);
			request.setAttribute("product", productDTO);
			request.getRequestDispatcher("/jsps/productdeleted.jsp").forward(request, response);
		} catch (SQLException e) {
			request.setAttribute("deleteAPIError", true);
			request.getRequestDispatcher("/jsps/products.jsp").forward(request, response);	
		}	
	}
}
