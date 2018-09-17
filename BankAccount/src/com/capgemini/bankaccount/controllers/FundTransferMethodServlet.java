package com.capgemini.bankaccount.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.bankaccount.exceptions.AccountNotFoundException;
import com.capgemini.bankaccount.exceptions.InsufficientAccountBalanceException;
import com.capgemini.bankaccount.exceptions.NegativeAmountException;
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
				RequestDispatcher requestdispatcher = request.getRequestDispatcher("fundTransfer.jsp");
				requestdispatcher.forward(request,response);
			}

		} catch (AccountNotFoundException | InsufficientAccountBalanceException | NegativeAmountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
