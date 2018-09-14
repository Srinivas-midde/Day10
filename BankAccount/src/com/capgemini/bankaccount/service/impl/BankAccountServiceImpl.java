package com.capgemini.bankaccount.service.impl;

import com.capgemini.bankaccount.dao.impl.BankAccountDaoImpl;
import com.capgemini.bankaccount.service.BankAccountService;

public class BankAccountServiceImpl implements BankAccountService {
	BankAccountDaoImpl object ;
	BankAccountServiceImpl serviceobject;
	public BankAccountServiceImpl() {
		object = new BankAccountDaoImpl();
	}

	@Override
	public double getBalance(long accountId) {
		return object.getBalance(accountId);
	}

	@Override
	public double withdraw(long accountId, double amount) {
		double balance = object.getBalance(accountId);
		if(balance >= amount) {
			object.updateBalance(accountId, balance-amount);
			return balance-amount;
		}
		else {
			return -1;
		}
	}

	@Override
	public double deposit(long accountId, double amount) {
		double balance = object.getBalance(accountId);
		object.updateBalance(accountId, balance+amount);
		return balance + amount;
	}

	@Override
	public boolean fundTransfer(long fromAcc, long toAcc, double amount) {
		double balance = object.getBalance(fromAcc);
		if((balance<amount) || (amount<0)) {
			return false;
		}
		serviceobject = new BankAccountServiceImpl();
		serviceobject.withdraw(fromAcc, amount);
		serviceobject.deposit(toAcc,amount );
		return true;
	}

}
