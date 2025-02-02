package com.spring.boot.transaction.DynamicProxy;

public class AccountImpl implements Account {

	private int accId;
	private String name;
	private double balance;

	public AccountImpl(int accId, String name, double balance) {
		this.accId = accId;
		this.name = name;
		this.balance = balance;
	}

	public int getAccId() {
		return accId;
	}

	public void setAccId(int accId) {
		this.accId = accId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accId=" + accId + ", name=" + name + ", balance=" + balance + "]";
	}

	@Override
	public void deposit(double amount) {
		System.out.println("success deposit " + amount);
		System.out.println("Current Balance is : " + balance);
	}
}
