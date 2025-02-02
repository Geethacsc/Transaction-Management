package com.spring.boot.transaction.DynamicProxy;

import java.lang.reflect.Proxy;

import com.spring.boot.transaction.DynamicProxy.proxy.AccountInvocationHandler;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		AccountImpl accountImpl = new AccountImpl(1, "Geetha", 10000.00);
		AccountInvocationHandler ivh = new AccountInvocationHandler(accountImpl);
		Account account1 = (Account) Proxy.newProxyInstance(AccountImpl.class.getClassLoader(),
				new Class<?>[] { Account.class }, ivh);//Account should be Interface
		System.out.println("After invocation");

		account1.deposit(10);
	}
}
