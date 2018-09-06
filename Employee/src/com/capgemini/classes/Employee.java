package com.capgemini.classes;

public class Employee {
	
	private int userNo;
	private String name;
	private double salary;
	private String departmentName;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int userNo, String name, double salary, String departmentName) {
		super();
		this.userNo = userNo;
		this.name = name;
		this.salary = salary;
		this.departmentName = departmentName;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	@Override
	public String toString() {
		return "Employee [userNo=" + userNo + ", name=" + name + ", salary=" + salary + ", departmentName="
				+ departmentName + "]";
	}
	
	

}
