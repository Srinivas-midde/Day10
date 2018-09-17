package com.capgemini.bankaccount.database;

import java.time.LocalDate;
import java.util.HashSet;

import com.capgemini.bankaccount.model.BankAccount;
import com.capgemini.bankaccount.model.Customer;

public class Database {
	public static HashSet<BankAccount> account = new HashSet<>();
	public static HashSet<Customer> customer = new HashSet<>();
	
	static {
		BankAccount b1 = new BankAccount(12,"Savings",12345);
		BankAccount b2 = new BankAccount(13,"Savings",12346);
		BankAccount b3 = new BankAccount(14,"Savings",12347);
		BankAccount b4 = new BankAccount(15,"Savings",12348);
		BankAccount b5 = new BankAccount(16,"Savings",12349);
		customer.add(new Customer(123,"Sri","pass","abc@yz.com","colony,area",LocalDate.of(1997, 06, 06),b1));
		customer.add(new Customer(124,"Teju","password1","jqwh@yz.com","colony,area",LocalDate.of(1996, 07, 27),b2));
		customer.add(new Customer(125,"Spa","password2","ow@yz.com","colony,area",LocalDate.of(1996, 12, 22),b3));
		customer.add(new Customer(126,"Shubham","password3","asf@yz.com","colony,area",LocalDate.of(1996, 04, 12),b4));
		customer.add(new Customer(127,"Neeraj","password4","wffw@yz.com","colony,area",LocalDate.of(1996, 03, 6),b5));

		account.add(b1);
		account.add(b2);
		account.add(b3);
		account.add(b4);
		account.add(b5);
	}
}