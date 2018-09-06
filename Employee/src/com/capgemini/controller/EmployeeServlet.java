package com.capgemini.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.classes.Employee;


@WebServlet("/details")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ArrayList<Employee> store= new ArrayList<>();
       ServletContext context;
    
    public EmployeeServlet() {
        super();
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        context = config.getServletContext();
       
        Employee emp1 = new Employee(9,"Teju",50_000,"Cloud");
        Employee emp2 = new Employee(7,"Sri",60_000,"Cloud");
        Employee emp3 = new Employee(4,"Spandhana",50_000,"java");
        Employee emp4 = new Employee(3,"Shubham",20_000,"Sap");
        Employee emp5 = new Employee(2,"naina",40_000,"IF");
        store.add(emp1);
        store.add(emp2);
        store.add(emp3);
        store.add(emp4);
        store.add(emp5);
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		int count=0;
		
		
		for (Employee itr : store) {
			if(itr.getUserNo() == Integer.parseInt(id))
			{
				count=1;
				out.println("<body bgcolor='green'><table border='1'>"
						+ "<tr><th>Employee Number</th><th>Employee Name</th><th>Salary</th><th>Department</th></tr>"
						+ "<tr><td>"+itr.getUserNo()+"</td><td>"+itr.getName()+"</td><td>"+itr.getSalary()+"</td><td>"+itr.getDepartmentName()+"</td></tr>"
								+ "</table></body>");
				break;
			}
		}
		if(count==0)
		{
			out.println("<body bgcolor='yellow'><h1>User number not found.</h1></body>");
		}
		
		out.close();
	}

}
