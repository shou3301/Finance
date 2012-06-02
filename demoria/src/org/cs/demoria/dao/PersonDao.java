package org.cs.demoria.dao;

import org.cs.demoria.model.Person;

public interface PersonDao {
	
	public Person findByEmail(String email);
	public void save(Person person);

}
