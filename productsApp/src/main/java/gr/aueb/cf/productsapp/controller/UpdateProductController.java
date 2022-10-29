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

@WebServlet("/update")
public class UpdateProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IProductDAO productDAO = new ProductDAOImpl();
	IProductService productServ = new ProductServiceImpl(productDAO);
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id").trim());
		String productName = request.getParameter("productName");
		double productPrice = Double.parseDouble(request.getParameter("productPrice"));
		
		ProductDTO oldProductDTO = new ProductDTO();
		oldProductDTO.setId(id);
		
		ProductDTO newProductDTO = new ProductDTO();
		newProductDTO.setProductName(productName);
		newProductDTO.setPrice(productPrice);
		
		
		try {
			productServ.updateProduct(oldProductDTO, newProductDTO);
			request.setAttribute("product", newProductDTO);
			request.getRequestDispatcher("/jsps/productupdated.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
