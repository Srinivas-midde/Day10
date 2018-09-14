package com.capgemini.bankaccount.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.bankaccount.service.impl.BankAccountServiceImpl;


@WebServlet("/transact")
public class TransactionServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    BankAccountServiceImpl bank;   
    
    public TransactionServletController() {
        bank = new BankAccountServiceImpl();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long from = Long.parseLong(request.getParameter("fromacc"));
		long to = Long.parseLong(request.getParameter("toacc"));
		double amount = Double.parseDouble(request.getParameter("amount"));
		
		bank.fundTransfer(from, to, amount);
		RequestDispatcher requestdispatcher = request.getRequestDispatcher("balancedisplay.jsp");
		requestdispatcher.forward(request,response);
	}

}
