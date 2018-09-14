package com.capgemini.bankaccount.model;

import java.time.LocalDate;

public class Customer {
	
	private long customerId;
	private String customerName;
	private String customerPassword;
	private String customerEmailId;
	private String customerAddress;
	private LocalDate dateOfBirth;
	private BankAccount account;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(long customerId, String customerName, String customerPassword, String customerEmailId,
			String customerAddress, LocalDate dateOfBirth, BankAccount accountId) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPassword = customerPassword;
		this.customerEmailId = customerEmailId;
		this.customerAddress = customerAddress;
		this.dateOfBirth = dateOfBirth;
		this.account = accountId;
	}
	
	
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	public String getCustomerEmailId() {
		return customerEmailId;
	}
	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public BankAccount getAccount() {
		return account;
	}
	public void setAccountId(BankAccount account) {
		this.account = account;
	}
	
	
	

}

