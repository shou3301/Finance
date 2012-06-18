package org.cs.demoria.vo;

import org.cs.demoria.model.Person;

public class AccountCreateForm {
	
	private String name;
	
	private Person manager;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person getManager() {
		return manager;
	}

	public void setManager(Person manager) {
		this.manager = manager;
	}

}
