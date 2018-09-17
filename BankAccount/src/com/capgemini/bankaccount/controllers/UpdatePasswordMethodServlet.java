package com.capgemini.bankaccount.controllers;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.bankaccount.model.Customer;
import com.capgemini.bankaccount.service.impl.CustomerServiceImpl;

@WebServlet("/updatePasswordMethod")
public class UpdatePasswordMethodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Customer customer;
	CustomerServiceImpl customerserviceimpl;
       
    public UpdatePasswordMethodServlet() {
    	customerserviceimpl = new CustomerServiceImpl();
    	customer = new Customer();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		
		Customer customer = (Customer) (session.getAttribute("customer"));
		customer.setCustomerPassword(oldPassword);
		
		if (customerserviceimpl.updatePassword(customer, oldPassword, newPassword)) {
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("home.jsp");
			requestdispatcher.forward(request, response);
		} else {
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("error.jsp");
			requestdispatcher.forward(request, response);
		}
	}

}
