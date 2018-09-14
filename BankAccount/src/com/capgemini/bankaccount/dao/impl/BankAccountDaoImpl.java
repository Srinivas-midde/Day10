package com.capgemini.bankaccount.dao.impl;

import com.capgemini.bankaccount.dao.BankAccountDao;
import com.capgemini.bankaccount.database.RecordStorage;
import com.capgemini.bankaccount.model.BankAccount;


public class BankAccountDaoImpl implements BankAccountDao {

	@Override
	public double getBalance(long accountId) {
		for (BankAccount accounts : RecordStorage.accounts) {
			if(accounts.getAccountId() == accountId) {
				return accounts.getBalance();
			}
		}
		return 0;
	}

	@Override
	public boolean updateBalance(long accountId, double newBalance) {
		for (BankAccount accounts : RecordStorage.accounts) {
			if(accounts.getAccountId() == accountId) {
				accounts.setBalance(newBalance);
				return true;
			}
		}
		return false;
	}

}
