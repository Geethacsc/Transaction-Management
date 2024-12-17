package com.spring.transaction;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.transaction.config.MobileConfig;
import com.spring.transaction.service.MobileService;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(MobileConfig.class);
		context.registerShutdownHook();
		MobileService service = context.getBean("mobileService", MobileService.class);
		service.saveMobileInfo();
		context.close();
	}
}
