package com.spring.TransactionManagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity(name = "MobileEntity")
@Table(name = "mobile_stock")
public class Mobile {

	@Id
	@Column(name = "mobile_id")
	private long mobileId;
	@Column(name = "mobile_brand")
	private String brand;
	@Transient
	private String txnRefNo;
	@Column(name = "available_stock")
	private long stock;

	public Mobile() {
		
	}
	public Mobile(long mobileId, String brand, String txnRefNo, long stock) {
		this.mobileId = mobileId;
		this.brand = brand;
		this.txnRefNo = txnRefNo;
		this.stock = stock;
	}

	public long getMobileId() {
		return mobileId;
	}

	public void setMobileId(long mobileId) {
		this.mobileId = mobileId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public long getStock() {
		return stock;
	}

	public void setStock(long stock) {
		this.stock = stock;
	}

	public String getTxnRefNo() {
		return txnRefNo;
	}

	public void setTxnRefNo(String txnRefNo) {
		this.txnRefNo = txnRefNo;
	}

}
