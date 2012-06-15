package org.cs.demoria.service;

import org.cs.demoria.model.Person;

public interface PersonService {
	
	public boolean loginCheck(String userName, String password);
	public void add(Person person);
	public Person findByName(String userName);

}
