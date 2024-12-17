package com.spring.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.transaction.dao.MobileRepo;
import com.spring.transaction.entity.Mobile;

@Service
public class MobileService {

	@Autowired
	private MobileRepo repo;

	@Transactional
	public void saveMobileInfo() {
		Mobile mobile = new Mobile();
		for (int i = 0; i < 100; i++) {
			System.out.println("Inside mobileservice");
			mobile.setMobileId(i);
			mobile.setBrand("RealMe");
			mobile.setStock(i);
			repo.addStockInfo(mobile);

			if (i == 7)
				throw new RuntimeException("Internal Error Occured");
		}
	}
}
