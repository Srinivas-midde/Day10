package com.capgemini.bankaccount.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capgemini.bankaccount.dao.CustomerDao;
import com.capgemini.bankaccount.exceptions.AccountNotFoundException;
import com.capgemini.bankaccount.model.BankAccount;
import com.capgemini.bankaccount.model.Customer;
import com.capgemini.bankaccount.util.DatabaseUtil;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public Customer authenticate(Customer customer) throws AccountNotFoundException {
		String customerQuery = "SELECT * FROM customers WHERE customer_id = ? AND customer_password = ?";
		String accountQuery = "SELECT * FROM accounts WHERE account_id = (SELECT account_id FROM customers WHERE customer_id = ?)";
		try (Connection connection = DatabaseUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(customerQuery);
				PreparedStatement statement2 = connection.prepareStatement(accountQuery)) {

			statement.setLong(1, customer.getCustomerId());
			statement.setString(2, customer.getCustomerPassword());
			try (ResultSet result = statement.executeQuery()) {
				if (result.next()) {
					customer.setCustomerName(result.getString(2));
					customer.setCustomerEmail(result.getString(4));
					customer.setCustomerAddress(result.getString(5));
					customer.setCustomerDateOfBirth(result.getDate(6).toLocalDate());
					
					statement2.setLong(1, customer.getCustomerId());
					try (ResultSet result2 = statement2.executeQuery()) {
						if (result2.next()) {
							BankAccount bank = new BankAccount();
							bank.setAccountId(result2.getLong(1));
							bank.setAccountType(result2.getString(2));
							bank.setBalance(result2.getDouble(3));
							customer.setAccount(bank);
							System.out.println(customer.toString());
							return customer; 
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new AccountNotFoundException("Account does not exist!");
	}

//	@Override
//	public Customer authenticate(Customer customer) throws AccountNotFoundException {
//		for (Customer cust : Database.customer) {
//			if (cust.getCustomerId() == customer.getCustomerId()
//					&& cust.getCustomerPassword().equals(customer.getCustomerPassword())) {
//				return cust;
//			}
//		}
//		throw new AccountNotFoundException("Account does not exist!");
//	}
	@Override
	public Customer updateProfile(Customer customer) {
		String query = "UPDATE customers SET customer_address = ?,customer_dob = ?,customer_email=?,customer_name=?   WHERE customer_id = ? ";
		String customerQuery = "SELECT * FROM customers WHERE customer_id = ?";

		try (Connection connection = DatabaseUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query);
				PreparedStatement statement2 = connection.prepareStatement(customerQuery)) {

			statement.setString(1, customer.getCustomerAddress());
			statement.setDate(2, Date.valueOf(customer.getCustomerDateOfBirth()));
			statement.setString(3, customer.getCustomerEmail());
			statement.setString(4, customer.getCustomerName());
			statement.setLong(5, customer.getCustomerId());

			if (statement.executeUpdate() != 0) {
				statement2.setLong(1, customer.getCustomerId());
				try (ResultSet result = statement2.executeQuery()) {
					if (result.next()) {
						customer.setCustomerName(result.getString(2));
						customer.setCustomerEmail(result.getString(4));
						customer.setCustomerAddress(result.getString(5));
						customer.setCustomerDateOfBirth(result.getDate(6).toLocalDate());
						return customer;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

//	@Override
//	public Customer updateProfile(Customer customer) {
//		for (Customer cust : Database.customer) {
//			if (cust.getCustomerId() == customer.getCustomerId()) {
//				cust.setCustomerAddress(customer.getCustomerAddress());
//				cust.setCustomerDateOfBirth(customer.getCustomerDateOfBirth());
//				cust.setCustomerEmail(customer.getCustomerEmail());
//				return cust;
//			}
//		}
//		return null;
//	}
	@Override
	public boolean updatePassword(Customer customer, String oldPassword, String newPassword) {
		String query = "UPDATE customers SET customer_password = ?  WHERE customer_id = ? AND customer_password = ? ";

		try (Connection connection = DatabaseUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, newPassword);
			statement.setLong(2, customer.getCustomerId());
			statement.setString(3, oldPassword);
			if(statement.executeUpdate() != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

//	@Override
//	public boolean updatePassword(Customer customer, String oldPassword, String newPassword) {
//		for (Customer cust : Database.customer) {
//			System.out.println(cust.getCustomerId());
//			if (cust.getCustomerId() == customer.getCustomerId() && cust.getCustomerPassword().equals(oldPassword)) {
//				cust.setCustomerPassword(newPassword);
//				return true;
//			}
//		}
//		return false;
//	}

	public static Customer updateSession(long customerId)
	{
		Customer customer = new Customer();
		String customerQuery = "SELECT * FROM customers WHERE customer_id = ?";
		String accountQuery = "SELECT * FROM accounts WHERE account_id = (SELECT account_id FROM customers WHERE customer_id = ?)";
		try (Connection connection = DatabaseUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(customerQuery);
				PreparedStatement statement2 = connection.prepareStatement(accountQuery)) {

			statement.setLong(1, customerId);
			try (ResultSet result = statement.executeQuery()) {
				if (result.next()) {
					customer.setCustomerId(result.getLong(1));
					customer.setCustomerName(result.getString(2));
					customer.setCustomerPassword(result.getString(3));
					customer.setCustomerEmail(result.getString(4));
					customer.setCustomerAddress(result.getString(5));
					customer.setCustomerDateOfBirth(result.getDate(6).toLocalDate());
					
					statement2.setLong(1, customer.getCustomerId());
					try (ResultSet result2 = statement2.executeQuery()) {
						if (result2.next()) {
							BankAccount bank = new BankAccount();
							bank.setAccountId(result2.getLong(1));
							bank.setAccountType(result2.getString(2));
							bank.setBalance(result2.getDouble(3));
							customer.setAccount(bank);
							System.out.println(customer.toString());
							return customer; 
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	}
