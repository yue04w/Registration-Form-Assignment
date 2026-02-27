package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;
import model.Registration;
import dao.RegisterDAO;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get Parameters
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String phoneNumber = request.getParameter("phoneNumber");
		String email = request.getParameter("email");
//		String captcha = request.getParameter("captcha");
		
		//store validation errors 
		List<String> errors = new ArrayList<>();
		
		//validate username
		if (userName == null || userName.trim().isEmpty()) {
			errors.add("Username can not be blank");
		}
		else if (userName.length() > 10) {
			errors.add("The limit for username is 10 characters");
		}
		
		//validate password
		if(password == null || password.trim().isEmpty()) {
			errors.add("Password can not be blank");
		}
		else if(password.length() > 10) {
			errors.add("Password limit is 10 characters");
		}
		//if password does not match with any of these regular expression syntax
		else if(!password.matches("[a-zA-Z0-9$_]+$")) {
			errors.add("The password can only contain letters, digits, and the special characters $ and _");
		}
		
		//confirmation for the password
		if(confirmPassword == null || confirmPassword.trim().isEmpty()) {
			errors.add("Please don't leave it blank");
		}
		else if(!password.equals(confirmPassword)) {
			errors.add("Your password does not match");
		}
		
	    // validate phone number
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            errors.add("Phone Number can not be blank");
        } else if (!phoneNumber.matches("^\\d{10}$")) {
            errors.add("Enter Valid Number - Phone number has to be exactly 10 digits");
        }
        
        // validate email
        if (email == null || email.trim().isEmpty()) {
            errors.add("Email field can not be blank");
        } else if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            errors.add("Enter valid Email Id");  
        }
        
        //check for errors
        if(!errors.isEmpty()) {
        	//set errors and request attributes 
        	request.setAttribute("errors", errors);
        	request.setAttribute("userName", userName);
        	request.setAttribute("password", password);
        	request.setAttribute("confirmPassword", confirmPassword);
        	request.setAttribute("phoneNumber", phoneNumber);
        	request.setAttribute("email", email);
        	
        //forward back to registration form
        	request.getRequestDispatcher("registration.jsp").forward(request, response);
        } else {
            Registration registration = new Registration(userName, password, confirmPassword, phoneNumber, email, "");
            
            RegisterDAO dao = new RegisterDAO();
            try {
                int result = dao.registration(registration);
                if (result > 0) {
                    System.out.println("Data inserted successfully!");
                } else {
                    System.out.println("Insert failed!");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            
            request.setAttribute("registration", registration);
            request.getRequestDispatcher("success.jsp").forward(request, response);
        }
	}
			
}

