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

import com.capgemini.bankaccount.model.Customer;
import com.capgemini.bankaccount.service.impl.CustomerServiceImpl;

@WebServlet("/updateProfile")
public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Customer customer;
	CustomerServiceImpl customerserviceimpl;
	

	public UpdateProfileServlet() {
		customer = new Customer();
		customerserviceimpl = new CustomerServiceImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("empId"));
		String name = request.getParameter("empName");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		LocalDate date = LocalDate.parse(request.getParameter("dob"));

		customer.setCustomerAddress(address);
		customer.setCustomerId(id);
		customer.setCustomerName(name);
		customer.setCustomerEmail(email);
		customer.setCustomerDateOfBirth(date);

		customer = customerserviceimpl.updateProfile(customer);
		if (customer != null) {
			request.getSession().setAttribute("customer", customer);
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("home");
			requestdispatcher.forward(request, response);
		} else {
			request.setAttribute("profileupdate", "false");
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("edit.jsp");
			requestdispatcher.forward(request, response);
		}
	}
}
