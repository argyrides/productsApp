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
import gr.aueb.cf.productsapp.service.IProductService;
import gr.aueb.cf.productsapp.service.ProductServiceImpl;
import gr.aueb.cf.productsapp.dto.ProductDTO;


@WebServlet("/insert")
public class InsertProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IProductDAO productDAO = new ProductDAOImpl();
	IProductService productServ = new ProductServiceImpl(productDAO);
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		
		// Get the data
		String productName = request.getParameter("productName").trim();
		double productPrice = Double.parseDouble(request.getParameter("productPrice"));
		
		// Construct DTO
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductName(productName);
		productDTO.setPrice(productPrice);

		// call the service and return feedback/view/data
		try {
			productServ.insertProduct(productDTO);
			request.setAttribute("insertedproduct", productDTO);
			request.getRequestDispatcher("/jsps/productinserted.jsp").forward(request,  response);
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("sqlError", true);
			request.getRequestDispatcher("/jsps/productsmenu.jsp").forward(request, response);
		}	
	}
}
