package com.capgemini.employeeapp.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.employeeapp.dao.EmployeeDao;
import com.capgemini.employeeapp.dao.impl.EmployeeDaoImpl;


@WebServlet("/deleteEmployee")
public class DeleteEmployeeDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EmployeeDao employeeDao;   
    private ServletContext context;
    public DeleteEmployeeDetailsController() {
        super();
       
        
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	context = config.getServletContext();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		employeeDao = (EmployeeDao) context.getAttribute("employeeDao");
		int employeeId = Integer.parseInt(request.getParameter("param1"));
		
		if(employeeDao.deleteEmployee(employeeId)) {
			
			response.sendRedirect("getAllEmployees");
		}
		else
		{
			response.sendRedirect("error.jsp");
		}
	}

}
