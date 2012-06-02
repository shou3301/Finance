package org.cs.demoria.service;

import org.cs.demoria.model.Person;

public interface PersonService {
	
	public boolean loginCheck(String email, String password);
	public void add(Person person);

}
