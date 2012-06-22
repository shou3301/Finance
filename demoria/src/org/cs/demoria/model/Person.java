package org.cs.demoria.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="PERSON")
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Integer id;
	
	@NotNull
	@Pattern(regexp = ".+", message = "First name must not be empty!")
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@NotNull
	@Pattern(regexp = ".+", message = "Last name must not be empty!")
	@Column(name="LAST_NAME")
	private String lastName;
	
	@NotNull
	@Column(name="USER_NAME")
	private String userName;
	
	@NotNull
	@Pattern(message = "Email invalid", regexp = "[a-z0-9!#$%&amp;'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&amp;'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?")
	@Column(name="EMAIL")
	private String email;

	@NotNull
	@Pattern(regexp = ".+", message = "Password must not be empty!")
	@Column(name="PASSWORD")
	private String password;
	
	@Valid
	@NotNull
	@Embedded
	private Address address;
	
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE},
			fetch=FetchType.EAGER,
			mappedBy="owners")
	private Set<Account> accountList = new HashSet<Account>();
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append(getFirstName()).append(" ");
		string.append(getLastName()).append(", ");
		string.append(getAddress().getCity()).append(", ");
		string.append(getEmail());
		return string.toString();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Set<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(Set<Account> accountList) {
		this.accountList = accountList;
	}
	
	@Override
	public boolean equals(Object o) {
		Person p = (Person)o;
		if (this.userName.equals(p.getUserName()))
			return true;
		else
			return false;
	}

}
