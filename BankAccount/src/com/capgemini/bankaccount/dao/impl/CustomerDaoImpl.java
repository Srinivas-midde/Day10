package com.capgemini.bankaccount.dao.impl;



import com.capgemini.bankaccount.dao.CustomerDao;
import com.capgemini.bankaccount.database.Database;
import com.capgemini.bankaccount.exceptions.AccountNotFoundException;
import com.capgemini.bankaccount.model.Customer;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public Customer authenticate(Customer customer) throws AccountNotFoundException {
		for (Customer cust : Database.customer) {
			if (cust.getCustomerId() == customer.getCustomerId()
					&& cust.getCustomerPassword().equals(customer.getCustomerPassword())) {
				return cust;
			}
		}
		throw new AccountNotFoundException("Account does not exist!");
	}

	@Override
	public Customer updateProfile(Customer customer) {
		for (Customer cust : Database.customer) {
			if (cust.getCustomerId() == customer.getCustomerId()) {
				cust.setCustomerAddress(customer.getCustomerAddress());
				cust.setCustomerDateOfBirth(customer.getCustomerDateOfBirth());
				cust.setCustomerEmail(customer.getCustomerEmail());
				cust.setCustomerName(customer.getCustomerName());
				return cust;
			}
		}
		return null;
	}

	@Override
	public boolean updatePassword(Customer customer, String oldPassword, String newPassword) {
		for (Customer cust : Database.customer) {
			System.out.println(cust.getCustomerId());
			if (cust.getCustomerId() == customer.getCustomerId() && cust.getCustomerPassword().equals(oldPassword)) {
				cust.setCustomerPassword(newPassword);
				return true;
			}
		}
		return false;
	}

}
