package com.capgemini.bankaccount.service;

import com.capgemini.bankaccount.exceptions.AccountNotFoundException;

import com.capgemini.bankaccount.model.Customer;

public interface CustomerService {

	public Customer authenticate(Customer customer) throws AccountNotFoundException;
	public Customer updateProfile(Customer customer);
	public boolean updatePassword(Customer customer, String oldPassword, String newPassword);

}
