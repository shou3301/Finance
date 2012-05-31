package org.cs.demoria.service.impl;

import javax.annotation.Resource;

import org.cs.demoria.dao.PersonDao;
import org.cs.demoria.model.Person;
import org.cs.demoria.service.PersonService;
import org.springframework.stereotype.Service;

@Service("personService")
public class PersonServiceImpl implements PersonService {

	private PersonDao personDao;
	
	@Override
	public Person findById(Integer id) {
		
		return personDao.sqlFindById(id);
	}

	public PersonDao getPersonDao() {
		return personDao;
	}

	@Resource(name="personDao")
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

}
