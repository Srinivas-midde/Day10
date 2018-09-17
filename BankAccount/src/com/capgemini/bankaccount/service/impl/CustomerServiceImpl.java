package com.capgemini.bankaccount.service.impl;

import com.capgemini.bankaccount.exceptions.AccountNotFoundException;

import com.capgemini.bankaccount.dao.impl.CustomerDaoImpl;
import com.capgemini.bankaccount.model.Customer;
import com.capgemini.bankaccount.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	CustomerDaoImpl customerdaoimpl = new CustomerDaoImpl();
	@Override
	public Customer authenticate(Customer customer) throws AccountNotFoundException {
		return customerdaoimpl.authenticate(customer);
	}

	@Override
	public Customer updateProfile(Customer customer) {
		return customerdaoimpl.updateProfile(customer);
	}

	@Override
	public boolean updatePassword(Customer customer, String oldPassword, String newPassword) {
		return customerdaoimpl.updatePassword(customer, oldPassword, newPassword);
	}

}
