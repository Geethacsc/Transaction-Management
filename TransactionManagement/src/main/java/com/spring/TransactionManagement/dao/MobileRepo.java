package com.spring.TransactionManagement.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.TransactionManagement.entity.Mobile;

import jakarta.persistence.EntityManager;

@Repository
public class MobileRepo {

	@Autowired
	private JdbcTemplate entity;
	// private JdbcTemplate jdbcTemplate;

	@Transactional(propagation = Propagation.SUPPORTS)
	public Mobile addStock(Mobile mobile) {
		String query = "insert into mobile_stock values(?,?,?)";
		Object args[] = { mobile.getMobileId(), mobile.getBrand(), mobile.getStock() };
		entity.update(query, args);
		System.out.println(mobile.getMobileId() + "Updated Successfully");
		return mobile;
	}

}
