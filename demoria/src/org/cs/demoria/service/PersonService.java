package org.cs.demoria.service;

import org.cs.demoria.model.Person;

public interface PersonService {
	
	public Person findById(Integer id);
	public void add(Person person);

}
