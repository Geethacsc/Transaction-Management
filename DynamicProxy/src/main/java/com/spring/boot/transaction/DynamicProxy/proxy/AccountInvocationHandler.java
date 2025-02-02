package com.spring.boot.transaction.DynamicProxy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.spring.boot.transaction.DynamicProxy.AccountImpl;

public class AccountInvocationHandler implements InvocationHandler {

	private AccountImpl accountTarget;

	public AccountInvocationHandler(AccountImpl accountTarget) {
		System.out.println("inside controller" + accountTarget);
		this.accountTarget = accountTarget;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		// pre process
		System.out.println("Inside invoke() method");
		if (method.getName().equals("deposit")) {
			double depositAmount = (double) args[0];
			if (depositAmount < 1)
				throw new RuntimeException("Invalid amount to deposit");
			accountTarget.setBalance(accountTarget.getBalance() + depositAmount);
			System.out.println(depositAmount + " is deposited successfully");
		}
		// making actual call to service layer
		Object obj = method.invoke(accountTarget, args);// calls the main service object (AccountImpl deposit() method)

		// post processing
		System.out.println("success deposit using Dynamic Proxy");
		return obj;
	}

}
