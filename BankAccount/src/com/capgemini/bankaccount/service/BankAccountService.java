package com.capgemini.bankaccount.service;

import com.capgemini.bankaccount.exceptions.AccountNotFoundException;
import com.capgemini.bankaccount.exceptions.InsufficientAccountBalanceException;
import com.capgemini.bankaccount.exceptions.NegativeAmountException;

public interface BankAccountService {

	public double getBalance(long accountId) throws AccountNotFoundException;
	public double withdraw(long accountId, double amount) throws AccountNotFoundException;
	public double deposit(long accountId, double amount) throws AccountNotFoundException;
	public boolean fundTransfer(long fromAcc, long toAcc, double amount) throws InsufficientAccountBalanceException, NegativeAmountException, AccountNotFoundException;
}
