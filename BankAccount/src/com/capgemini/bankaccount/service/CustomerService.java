package com.capgemini.bankaccount.service;

import com.capgemini.bankaccount.model.Customer;

public interface CustomerService {
	
	public Customer authenticate(Customer customer);
	public Customer updateProfile(Customer customer);
	public boolean updatePassword(Customer customer,String oldPassword,String newPassword);

}
