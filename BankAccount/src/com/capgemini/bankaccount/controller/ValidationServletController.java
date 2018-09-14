package com.capgemini.bankaccount.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/validate")
public class ValidationServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ValidationServletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(false);
		
		if(null == session.getAttribute("customer"))
		{
			//out.println("Please login first");
			request.getRequestDispatcher("login.jsp").include(request, response);
		}
		else
		{
			out.println("<h1>welcome</h1>");
		}
		
		out.close();
	}

	

}
