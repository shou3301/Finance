package org.cs.demoria.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="INVESTMENT")
public class Investment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Integer id;
	
	@NotNull
	@Min(value = 1, message = "You must buy 1 or more units")
	@Column(name="UNIT")
	private Double unit;
	
	@NotNull
	@Min(value = 0, message = "Unit price should be positive")
	@Column(name="INIT_UNIT_PRICE")
	private Double initUnitPrice;
	
	@NotNull
	@Column(name="TRANSACTION_DATE")
	private Date transactionDate;
	
	@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	private Product product;

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String toString() {
		return this.id + " " + this.initUnitPrice + " " + this.transactionDate;
	}

}
