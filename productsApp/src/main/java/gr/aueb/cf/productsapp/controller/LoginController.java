package gr.aueb.cf.productsapp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.cf.productsapp.dao.IUserDAO;
import gr.aueb.cf.productsapp.dao.UserDAOImpl;
import gr.aueb.cf.productsapp.model.User;
import gr.aueb.cf.productsapp.service.IUserService;
import gr.aueb.cf.productsapp.service.UserServiceImpl;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	IUserDAO userDAO = new UserDAOImpl();
	IUserService userServ = new UserServiceImpl(userDAO);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		// get data
		String email = request.getParameter("eMail");
		String password = request.getParameter("password");
		
		// construct DTO
		
		
		// call service
		
		try {
			
			User currentUser = userServ.getUserByEmailService(email);
			
			if (currentUser.getPassword().equals(password)) {
				request.getRequestDispatcher("/jsps/productsmenu.jsp").forward(request, response);
			} else {
			// return response
				request.setAttribute("error", true);
				request.getRequestDispatcher("/jsps/login.jsp").forward(request, response);
			}
		
		} catch(SQLException e) {
			e.printStackTrace();
			request.setAttribute("sqlError", true);
			request.getRequestDispatcher("/jsps/login.jsp").forward(request, response);
		}
		
		
		
	}
}
