package org.cs.demoria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="CASH")
@Inheritance(strategy=InheritanceType.JOINED)
public class Cash extends Product {
	
	@NotNull
	@Min(0)
	@Column(name="INTEREST")
	private Float interest;

	public Float getInterest() {
		return interest;
	}

	public void setInterest(Float interest) {
		this.interest = interest;
	}

}
