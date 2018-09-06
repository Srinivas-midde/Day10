package com.capgemini.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/processing")
public class CardDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CardDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String cardNo = request.getParameter("card");
		String cvv = request.getParameter("cvv");
		String validMo = request.getParameter("mo");
		String validYe = request.getParameter("ye");
		
//		if((Integer.parseInt(validMo) == 2 || Integer.parseInt(validMo) == 3 || Integer.parseInt(validMo) == 4) &&
//				(Integer.parseInt(validYe) == 2 || Integer.parseInt(validYe) == 3 || Integer.parseInt(validYe) == 4))
//		{
			out.println("<body> Name on card = "+name+"<br>Card number = "+cardNo+"<br>CVV = "+cvv+"<br>Validity = "+validMo+"/"+validYe);
			
//		}
//		else
//		{
//			out.println("Invalid credentials");
//		}
	}

}
