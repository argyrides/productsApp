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
import gr.aueb.cf.productsapp.dto.UserDTO;
import gr.aueb.cf.productsapp.service.IUserService;
import gr.aueb.cf.productsapp.service.UserServiceImpl;


@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	IUserDAO userDAO = new UserDAOImpl();
	IUserService userServ = new UserServiceImpl(userDAO);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		String email = request.getParameter("eMail");
		String password = request.getParameter("password");
		String repeatPassword = request.getParameter("repeatPassword");
		
		if (!password.equals(repeatPassword)) {
			request.setAttribute("passwordError", true);
			request.setAttribute("passwordLengthError", false);
			request.getRequestDispatcher("/jsps/register.jsp").forward(request, response);
		}
		else if (password.length() < 8) {
			request.setAttribute("passwordError", false);
			request.setAttribute("passwordLengthError", true);
			request.getRequestDispatcher("/jsps/register.jsp").forward(request, response);
		}
		else {
			
		   try {
			   if (userServ.emailAlreadyExistService(email) == true) {
					request.setAttribute("emailExistError", true);
					request.getRequestDispatcher("/jsps/register.jsp").forward(request, response);
			   }
			   else {
					UserDTO userDTO = new UserDTO();
					userDTO.setEmail(email);
					userDTO.setPassword(password);
					
					try {
						userServ.insertUserService(userDTO);
						request.setAttribute("createdUser", true);
						request.getRequestDispatcher("/jsps/register.jsp").forward(request,  response);
					} catch(SQLException e) {
						e.printStackTrace();
						request.setAttribute("sqlError", true);
						request.getRequestDispatcher("/jsps/register.jsp").forward(request, response);
					}
			   }
		   } catch (SQLException e) {
				e.printStackTrace();
				request.setAttribute("sqlError", true);
				request.getRequestDispatcher("/jsps/register.jsp").forward(request, response);
		   }	
		}
	}
}
