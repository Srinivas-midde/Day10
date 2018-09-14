package com.capgemini.bankaccount.dao.impl;

import com.capgemini.bankaccount.dao.CustomerDao;
import com.capgemini.bankaccount.database.RecordStorage;
import com.capgemini.bankaccount.model.Customer;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public Customer authenticate(Customer customer) {
		for (Customer customers : RecordStorage.customers) {
			
			if((customers.getCustomerId() == customer.getCustomerId()) && (customers.getCustomerPassword().equals(customer.getCustomerPassword()))) {
				return customers;
			}
		}
		return null;
	}

	@Override
	public Customer updateProfile(Customer customer) {
		for (Customer customers : RecordStorage.customers) {
			if((customers.getCustomerId() == customer.getCustomerId()))  {
				customers.setCustomerAddress(customer.getCustomerAddress());
				customers.setCustomerEmailId(customer.getCustomerEmailId());
				customers.setCustomerName(customer.getCustomerName());
				customers.setDateOfBirth(customer.getDateOfBirth());
				return customers;
			}
		}
		return null;
	}

	@Override
	public boolean updatePassword(Customer customer, String oldPassword, String newPassword) {
		for (Customer customers : RecordStorage.customers) {
			if((customers.getCustomerId() == customer.getCustomerId()) && (customers.getCustomerPassword() == oldPassword)) {
				customers.setCustomerPassword(oldPassword);
				return true;
			}
		}		return false;
	}

}
