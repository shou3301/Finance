package org.cs.demoria.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ACCOUNT")
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Integer id;
	
	@NotNull
	@Column(name="ACCOUNT_NAME")
	private String name;
	
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE},
			fetch=FetchType.EAGER)
	@JoinTable(
            name="PERSON_ACCOUNT",
            joinColumns={@JoinColumn(name="ACCOUNT_ID")},
            inverseJoinColumns={@JoinColumn(name="PERSON_ID")}
    )
	private Set<Person> owners = new HashSet<Person>();
	
	@NotNull
	@OneToOne
	private Person manager;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="ACCOUNT_ID")
	private List<Investment> investments = new ArrayList<Investment>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Person> getOwners() {
		return owners;
	}

	public void setOwners(Set<Person> owners) {
		this.owners = owners;
	}

	public Person getManager() {
		return manager;
	}

	public void setManager(Person manager) {
		this.manager = manager;
	}

	public List<Investment> getInvestments() {
		return investments;
	}

	public void setInvestments(List<Investment> investments) {
		this.investments = investments;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public void addOwner(Person person) {
		owners.add(person);
	}
	
	public void removeOwner(Person person) {
		for (Person p : owners) {
			if (p.getUserName().equals(person.getUserName()))
				owners.remove(p);
		}
	}
	
	@Override
	public String toString() {
		return "Account name: " + this.name + " Manager: " + this.manager;
	}

}
