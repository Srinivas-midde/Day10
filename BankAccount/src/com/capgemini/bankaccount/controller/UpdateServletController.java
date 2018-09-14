package com.capgemini.bankaccount.controller;

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


@WebServlet("/update")
public class UpdateServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Customer customer;
	CustomerServiceImpl object;
	ServletRequest session;
       
    
    public UpdateServletController() {
        customer = new Customer();
        object = new CustomerServiceImpl();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long id= Long.parseLong(request.getParameter("empId"));
		String name= request.getParameter("empName");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		LocalDate date = LocalDate.parse(request.getParameter("dob"));
		
		customer.setCustomerAddress(address);
		customer.setCustomerId(id);
		customer.setCustomerName(name);
		customer.setCustomerEmailId(email);
		customer.setDateOfBirth(date);
		
		customer = object.updateProfile(customer);
		RequestDispatcher requestdispatcher = request.getRequestDispatcher("edit1.jsp");
		requestdispatcher.forward(request,response);
	}

}
