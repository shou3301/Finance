package org.cs.demoria.dao;

import org.cs.demoria.model.Person;

public interface PersonDao {
	
	public Person sqlFindById(Integer id);

}
