package com.spring.transaction.entity;

//@Entity
public class Mobile {

//	@Id
//	@Column(name = "mobile_id")
	private long mobileId;
	//@Transient
	private String txnRefNo;
	private String brand;
	//@Column(name = "available_stock")
	private long stock;

	public long getMobileId() {
		return mobileId;
	}

	public void setMobileId(long mobileId) {
		this.mobileId = mobileId;
	}

	public String getTxnRefNo() {
		return txnRefNo;
	}

	public void setTxnRefNo(String txnRefNo) {
		this.txnRefNo = txnRefNo;
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

}
