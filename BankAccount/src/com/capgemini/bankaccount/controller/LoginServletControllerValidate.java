package com.capgemini.bankaccount.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.bankaccount.database.RecordStorage;
import com.capgemini.bankaccount.model.Customer;
import com.capgemini.bankaccount.service.impl.CustomerServiceImpl;


@WebServlet("/login")
public class LoginServletControllerValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CustomerServiceImpl customer; 
	Customer object;
	Customer cust;
	RecordStorage rec;
 
    public LoginServletControllerValidate() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init() throws ServletException {
		customer = new CustomerServiceImpl();
		rec = new RecordStorage();
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		
		long id = Long.parseLong(request.getParameter("id"));
		String password = request.getParameter("password");
		
		object = new Customer();
		object.setCustomerId(id);
		object.setCustomerPassword(password);
		cust = customer.authenticate(object);
		
		if(cust!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("customer", cust);
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("home.html");
			requestdispatcher.forward(request,response);
		}
		
	}

}
