package com.capgemini.bankaccount.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/balanceEnquiry")
public class BalanceEnquiryServletControllerValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BalanceEnquiryServletControllerValidate() {
        super();
       }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
HttpSession session = request.getSession(false);
		
		if(null == session.getAttribute("customer"))
		{
			
			request.getRequestDispatcher("error.jsp").include(request, response);
		}
		else
		{
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("balance.jsp");
			requestdispatcher.forward(request,response);
		}
	}

}
