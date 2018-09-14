package com.capgemini.bankaccount.dao;

public interface BankAccountDao {
	
	public double getBalance(long accountId);
	public boolean updateBalance(long accountId,double newBalance);

}
