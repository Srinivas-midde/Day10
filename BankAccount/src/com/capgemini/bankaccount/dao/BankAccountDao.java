package com.capgemini.bankaccount.dao;

import com.capgemini.bankaccount.exceptions.AccountNotFoundException;

public interface BankAccountDao {

	public double getBalance(long accountId) throws AccountNotFoundException;
	public boolean updateBalance(long accountId, double newBalance);
}
