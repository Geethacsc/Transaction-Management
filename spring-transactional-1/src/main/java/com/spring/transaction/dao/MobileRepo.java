package com.spring.transaction.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.transaction.entity.Mobile;

@Repository
public class MobileRepo {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional
	public void addStockInfo(Mobile mobile) {
		String query = "insert into mobile_stock values(?,?,?)";
		Object[] args = { mobile.getMobileId(), mobile.getBrand(), mobile.getStock() };
		jdbcTemplate.update(query, args);
		System.out.println("Product inserted");
	}
}
