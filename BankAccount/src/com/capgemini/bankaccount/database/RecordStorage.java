package com.capgemini.bankaccount.database;

import java.time.LocalDate;
import java.util.HashSet;

import com.capgemini.bankaccount.model.BankAccount;
import com.capgemini.bankaccount.model.Customer;

public class RecordStorage {
	
	public static HashSet<Customer> customers = new HashSet<>();
	public static HashSet<BankAccount> accounts = new HashSet<>();


	public RecordStorage() {
		BankAccount b1 = new BankAccount(12,"Savings",12345);
		BankAccount b2 = new BankAccount(13,"Savings",12346);
		BankAccount b3 = new BankAccount(14,"Savings",12347);
		BankAccount b4 = new BankAccount(15,"Savings",12348);
		BankAccount b5 = new BankAccount(16,"Savings",12349);
		customers.add(new Customer(123,"Sri","pass","abc@yz.com","colony,area",LocalDate.of(1997, 06, 06),b1));
		customers.add(new Customer(124,"Teju","password1","jqwh@yz.com","colony,area",LocalDate.of(1996, 07, 27),b2));
		customers.add(new Customer(125,"Spa","password2","ow@yz.com","colony,area",LocalDate.of(1996, 12, 22),b3));
		customers.add(new Customer(126,"Shubham","password3","asf@yz.com","colony,area",LocalDate.of(1996, 04, 12),b4));
		customers.add(new Customer(127,"Neeraj","password4","wffw@yz.com","colony,area",LocalDate.of(1996, 03, 6),b5));

		accounts.add(b1);
		accounts.add(b2);
		accounts.add(b3);
		accounts.add(b4);
		accounts.add(b5);
	}

}
