package com.capgemini.bankaccount.service.impl;

import com.capgemini.bankaccount.dao.impl.CustomerDaoImpl;
import com.capgemini.bankaccount.model.Customer;
import com.capgemini.bankaccount.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	CustomerDaoImpl object = new CustomerDaoImpl();

	@Override
	public Customer authenticate(Customer customer) {
		return object.authenticate(customer);
	}

	@Override
	public Customer updateProfile(Customer customer) {
		return object.updateProfile(customer);
	}

	@Override
	public boolean updatePassword(Customer customer, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		return object.updatePassword(customer, oldPassword, newPassword);
	}

}
