 package com.capgemini.bankaccount.dao.impl;

import com.capgemini.bankaccount.dao.BankAccountDao;
import com.capgemini.bankaccount.database.Database;
import com.capgemini.bankaccount.exceptions.AccountNotFoundException;
import com.capgemini.bankaccount.model.BankAccount;

public class BankAccountDaoImpl implements BankAccountDao {

	@Override
	public double getBalance(long accountId) throws AccountNotFoundException {
		for (BankAccount accounts : Database.account) {
			if(accounts.getAccountId() == accountId) {
				return accounts.getBalance();
			}
		}
		throw new AccountNotFoundException("Account doesn't exist!");
	}

	@Override
	public boolean updateBalance(long accountId, double newBalance) {
		for (BankAccount accounts : Database.account) {
			if(accounts.getAccountId() == accountId) {
				accounts.setBalance(newBalance);
				return true;
			}
		}
		return false;
	}
}
