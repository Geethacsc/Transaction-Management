package com.spring.TransactionManagement;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.TransactionManagement.config.AppConfig;
import com.spring.TransactionManagement.entity.Mobile;
import com.spring.TransactionManagement.service.MobileService;

public class App {
	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		context.registerShutdownHook();
		MobileService service = context.getBean("mobileService", MobileService.class);
		service.addStocksInfo();
		context.close();
	}
}
