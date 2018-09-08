package com.capgemini.employeeapp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.employeeapp.dao.EmployeeDao;
import com.capgemini.employeeapp.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	private List<Employee> employees=new ArrayList<Employee>() ; 

	@Override
	public List<Employee> findAllEmployees() {
		return employees ;
	}

	public Employee findAllEmployeeById(int employeeId) {
		return null;
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		for(Employee employee : employees)
		{
			if(employee.getEmployeeId()== employeeId)
			{
				employees.remove(employee) ;
				return true ;
			}
		}
		return false ;
	}

	@Override
	public boolean addEmployee(Employee employee) {
		return employees.add(employee) ;
	}

	@Override
	public boolean updateEmployee(Employee employee1) {
		
		for(Employee employee : employees)
		{
			if(employee.getEmployeeId()== employee1.getEmployeeId())
			{
				employee.setEmployeeDepartment(employee1.getEmployeeDepartment()); 
				employee.setEmployeeName(employee1.getEmployeeName());
				employee.setEmployeeSalary(employee1.getEmployeeSalary());
				return true ;
			}
		}
		return false ;
	}

	@Override
	public Employee findElementById(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
