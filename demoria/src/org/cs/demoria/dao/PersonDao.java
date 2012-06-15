package org.cs.demoria.dao;

import org.cs.demoria.model.Person;

public interface PersonDao {
	
	public Person findByName(String userName);
	public void save(Person person);

}
