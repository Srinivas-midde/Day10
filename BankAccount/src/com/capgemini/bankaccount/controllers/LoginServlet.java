package com.capgemini.bankaccount.controllers;

import java.io.IOException;

import com.capgemini.bankaccount.exceptions.AccountNotFoundException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.bankaccount.model.Customer;
import com.capgemini.bankaccount.service.impl.CustomerServiceImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CustomerServiceImpl customerserviceimpl; 
	Customer customer;
	
    public LoginServlet() {
    	 customerserviceimpl = new CustomerServiceImpl();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try
		{
		long id = Long.parseLong(request.getParameter("id"));
		String password = request.getParameter("password");
		customer = new Customer();
		customer.setCustomerId(id);
		customer.setCustomerPassword(password);
			customer = customerserviceimpl.authenticate(customer);
		} catch (AccountNotFoundException | NumberFormatException e) {
			request.setAttribute("name", "true");
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("index.jsp");
			requestdispatcher.forward(request,response);
			customer = null;
		}
		finally {
		if(customer!=null) {
			HttpSession session = request.getSession(false);
			session.setAttribute("customer", customer);
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("home");
			requestdispatcher.forward(request,response);
		}
		}
	}
}
