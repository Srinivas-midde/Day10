package com.capgemini.bankaccount.service.impl;

import com.capgemini.bankaccount.dao.impl.BankAccountDaoImpl;
import com.capgemini.bankaccount.exceptions.AccountNotFoundException;
import com.capgemini.bankaccount.exceptions.InsufficientAccountBalanceException;
import com.capgemini.bankaccount.exceptions.NegativeAmountException;
import com.capgemini.bankaccount.service.BankAccountService;

public class BankAccountServiceImpl implements BankAccountService {

	BankAccountDaoImpl bankaccountdaoimpl = new BankAccountDaoImpl();
	BankAccountServiceImpl serviceobject;

	@Override
	public double getBalance(long accountId) throws AccountNotFoundException {
		return bankaccountdaoimpl.getBalance(accountId);
	}

	@Override
	public double withdraw(long accountId, double amount) throws AccountNotFoundException {
		double accountBalance = bankaccountdaoimpl.getBalance(accountId);
		bankaccountdaoimpl.updateBalance(accountId, accountBalance - amount);
		return accountBalance - amount;
	}

	@Override
	public double deposit(long accountId, double amount) throws AccountNotFoundException {
		double accountBalance = bankaccountdaoimpl.getBalance(accountId);
		bankaccountdaoimpl.updateBalance(accountId, accountBalance + amount);
		return accountBalance + amount;
	}

	@Override
	public boolean fundTransfer(long fromAcc, long toAcc, double amount)
			throws InsufficientAccountBalanceException, NegativeAmountException, AccountNotFoundException {
		double accountBalanceFrom = bankaccountdaoimpl.getBalance(fromAcc);
		if (accountBalanceFrom < amount)
			throw new InsufficientAccountBalanceException("There isn't sufficient balance in your account!");
		else if (amount < 0)
			throw new NegativeAmountException("The amount cannot be negative!");
		else {
			serviceobject = new BankAccountServiceImpl();
			serviceobject.withdraw(fromAcc, amount);
			serviceobject.deposit(toAcc, amount);
			return true;
		}
	}

}
