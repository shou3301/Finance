package org.cs.demoria.model;

import java.util.Date;

public class Investment {
	
	Double unit;
	Double initUnitPrice;
	Date transactionDate;
	Product product;

	public Double getUnit() {
		return unit;
	}

	public void setUnit(Double unit) {
		this.unit = unit;
	}

	public Double getInitUnitPrice() {
		return initUnitPrice;
	}

	public void setInitUnitPrice(Double initUnitPrice) {
		this.initUnitPrice = initUnitPrice;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
