package org.cs.demoria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="MANAGED_FUND")
@Inheritance(strategy = InheritanceType.JOINED)
public class ManagedFund extends Product {

	@NotNull
	@Column(name="FUND_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String fundId;
	
	@NotNull
	@Column(name="DISTRIBUTION")
	private Double distribution;
	
	@NotNull
	@Column(name="CURRENT_UNIT_PRICE")
	private Float currentUnitPrice;

	public String getFundId() {
		return fundId;
	}

	public void setFundId(String fundId) {
		this.fundId = fundId;
	}

	public Double getDistribution() {
		return distribution;
	}

	public void setDistribution(Double distribution) {
		this.distribution = distribution;
	}

	public Float getCurrentUnitPrice() {
		return currentUnitPrice;
	}

	public void setCurrentUnitPrice(Float currentUnitPrice) {
		this.currentUnitPrice = currentUnitPrice;
	}

}
