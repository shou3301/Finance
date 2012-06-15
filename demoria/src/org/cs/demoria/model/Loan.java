package org.cs.demoria.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="LOAN")
@Inheritance(strategy = InheritanceType.JOINED)
public class Loan extends Product {

	@NotNull
	@Column(name="INTEREST")
	private Float interest;
	
	@OneToMany(cascade=CascadeType.ALL)
	private Set<Person> lenders;

	public Float getInterest() {
		return interest;
	}

	public void setInterest(Float interest) {
		this.interest = interest;
	}

	public Set<Person> getLenders() {
		return lenders;
	}

	public void setLenders(Set<Person> lenders) {
		this.lenders = lenders;
	}

}
