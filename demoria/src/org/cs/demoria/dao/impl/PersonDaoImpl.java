package org.cs.demoria.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.cs.demoria.dao.PersonDao;
import org.cs.demoria.model.Person;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository("personDao")
public class PersonDaoImpl implements PersonDao {

	private SessionFactory sessionFactory;


	public Person sqllFindById(Integer id) {
		
		Session session = getSessionFactory().getCurrentSession();
		
		Query query = session.createQuery("Select p from Person p where p.id = :id").setParameter("id", id);
		List<Person> results = query.list();
		
		if (!results.isEmpty()) {
			for (Person p : results) {
				return p;
			}
		}
		
		return null;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(Person person) {
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(person);
		session.getTransaction().commit();
		
	}

	@Override
	public Person findByEmail(String email) {

		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Query query = session.createQuery("Select p from Person p where p.email = :email").setParameter("email", email);
		Person person = (Person) query.uniqueResult();
		
		session.getTransaction().commit();
		
		return person;
	}

}
