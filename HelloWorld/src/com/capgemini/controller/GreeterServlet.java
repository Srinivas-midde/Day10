package com.capgemini.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/greet")
public class GreeterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public GreeterServlet() {
        super();
     
    }

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		String name = request.getParameter("Username");
		
		out.println("<h1>Hello:"+name+"</h1>");
		out.close();
	}

}
