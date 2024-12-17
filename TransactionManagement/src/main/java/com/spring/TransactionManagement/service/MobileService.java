package com.spring.TransactionManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.TransactionManagement.dao.MobileRepo;
import com.spring.TransactionManagement.entity.Mobile;

//In try catch block rollback of transactions will not work. since the exception should be thrown out of the method
@Service
public class MobileService {

	@Autowired
	private MobileRepo mobileRepo;

	@Transactional
	public Mobile addStocksInfo() throws Exception{
		// TODO Auto-generated method stub
		Mobile mobile=new Mobile();
		
		for (int i=1;i<10;i++) {
			mobile.setMobileId(i);
			mobile.setBrand("Samsumg");
			mobile.setStock(i);
			
			if(mobile.getMobileId()==7)
				throw new RuntimeException("unchecked Exception-rollback of Transactions works fine by default in @Transactional");//rollback of data works for unchecked exceptions
			
			if(mobile.getStock()==5)
				throw new Exception("checked Exception- rollback od transactions doesn't work by default");
			System.out.println("Inside Mobile" + mobile.getClass().getName());
			try {
				if(mobile.getStock()==3)
					throw new RuntimeException("Inside try catch block-RunTime Exception ");
			mobileRepo.addStock(mobile);
			
		}
			catch(Exception e){
				System.out.println("Inside catch block, Some Error Occured"+e);
			}
		}
		
		return mobile;
	
	}
}