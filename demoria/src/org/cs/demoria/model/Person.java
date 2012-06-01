package org.cs.demoria.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@NotNull
	//@Pattern(regexp=".+", message="Last name must not be empty!")
	private String firstName;
	
	@NotNull
	//@Pattern(regexp=".+", message="First name must not be empty!")
	private String lastName;
	
	@NotNull
	//@Pattern(message = "Email invalid", regexp = "[a-z0-9!#$%&amp;'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&amp;'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?")
	private String email;

	@NotNull
	//@Pattern(regexp = ".+", message = "Password must not be empty!")
	private String password;
	
	//@Valid
	//@NotNull
	@Embedded
	private Address address;
	
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

}
