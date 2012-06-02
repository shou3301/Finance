package org.cs.demoria.service.impl;

import javax.annotation.Resource;

import org.cs.demoria.dao.PersonDao;
import org.cs.demoria.model.Person;
import org.cs.demoria.service.PersonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("personService")
public class PersonServiceImpl implements PersonService {

	private PersonDao personDao;

	public PersonDao getPersonDao() {
		return personDao;
	}

	@Resource(name="personDao")
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	@Override
	@Transactional
	public void add(Person person) {
	
		personDao.save(person);
		
	}

	@Override
	@Transactional
	public boolean loginCheck(String email, String password) {

		if (password.equals(personDao.findByEmail(email).getPassword()))
			return true;
		
		return false;
	}

}
