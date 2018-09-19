package com.capgemini.bankaccount.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.bankaccount.dao.impl.CustomerDaoImpl;
import com.capgemini.bankaccount.exceptions.AccountNotFoundException;
import com.capgemini.bankaccount.exceptions.InsufficientAccountBalanceException;
import com.capgemini.bankaccount.exceptions.NegativeAmountException;
import com.capgemini.bankaccount.model.Customer;
import com.capgemini.bankaccount.service.impl.BankAccountServiceImpl;

@WebServlet("/fundTransferMethod")
public class FundTransferMethodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BankAccountServiceImpl bankaccountserviceimpl;


	public FundTransferMethodServlet() {
		bankaccountserviceimpl = new BankAccountServiceImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		long from = Long.parseLong(request.getParameter("fromAcc"));
		long to = Long.parseLong(request.getParameter("toAcc"));
		double amount = Double.parseDouble(request.getParameter("amount"));

		try {
			if (bankaccountserviceimpl.fundTransfer(from, to, amount)) {
				request.setAttribute("success", "true");
				HttpSession session = request.getSession();
				Customer cust  = (Customer) session.getAttribute("customer");
				Customer customer = CustomerDaoImpl.updateSession(cust.getCustomerId());
				request.getSession().setAttribute("customer", customer);	
				RequestDispatcher requestdispatcher = request.getRequestDispatcher("fundTransfer.jsp");
				requestdispatcher.forward(request,response);
			}

		} catch (AccountNotFoundException | InsufficientAccountBalanceException | NegativeAmountException e) {
			if(e instanceof NegativeAmountException) {
			request.setAttribute("negativeamount", "true");
			request.getRequestDispatcher("fundTransfer.jsp").include(request, response);}
			else if(e instanceof InsufficientAccountBalanceException) {
				request.setAttribute("insufficientbalance", "true");
				request.getRequestDispatcher("fundTransfer.jsp").include(request, response);}
			else {
				request.setAttribute("accountnotfound", "true");
				request.getRequestDispatcher("fundTransfer.jsp").include(request, response);}
			}
			
		}

	}

