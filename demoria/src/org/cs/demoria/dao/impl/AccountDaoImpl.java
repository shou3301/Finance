package org.cs.demoria.dao.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.cs.demoria.dao.AccountDao;
import org.cs.demoria.model.Account;
import org.cs.demoria.model.Investment;
import org.cs.demoria.model.Person;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
	
	private SessionFactory sessionFactory;

	@Override
	public Account findByName(String accountName) {

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		Query query = session.createQuery("Select a from Account a where a.name = :name").setParameter("name", accountName);
		Account account = (Account)query.uniqueResult();
		
		session.getTransaction().commit();
		
		return account;
	}

	@Override
	public void insertOwnerByName(Person person, String accountName) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Query query = session.createQuery("Select a from Account a where a.name = :name").setParameter("name", accountName);
		Account account = (Account)query.uniqueResult();
		account.addOwner(person);
		session.update(account);
		
		session.getTransaction().commit();
	}

	@Override
	public void removeOwnerByName(Person person, String accountName) {
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Query query = session.createQuery("Select a from Account a where a.name = :name").setParameter("name", accountName);
		Account account = (Account)query.uniqueResult();
		account.removeOwner(person);
		session.update(account);
		
		session.getTransaction().commit();
	}

	@Override
	public void deleteAccount(String accountName) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Investment> getAllInvestmentByName(String accountName) {

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Query query = session.createQuery("Select a from Account a where a.name = :name").setParameter("name", accountName);
		Account account = (Account)query.uniqueResult();
		
		session.getTransaction().commit();
		
		return account.getInvestments();
	}
	
	@Override
	public Account findById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		Query query = session.createQuery("Select a from Account a where a.id = :id").setParameter("id", id);
		Account account = (Account)query.uniqueResult();
		
		session.getTransaction().commit();
		
		return account;
	}

	@Override
	public List<Investment> getAllInvestmentById(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Query query = session.createQuery("Select a from Account a where a.id = :id").setParameter("id", id);
		Account account = (Account)query.uniqueResult();
		
		session.getTransaction().commit();
		
		return account.getInvestments();
		
	}
	
	@Override
	public List<Account> getAllAccount() {
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from Account");
		List<Account> accounts = (List<Account>)query.list();
		
		session.getTransaction().commit();
		
		return accounts;
	}
	
	@Override
	public Set<Person> getOwnersById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Query query = session.createQuery("Select a from Account a where a.id = :id").setParameter("id", id);
		Account account = (Account)query.uniqueResult();
		
		session.getTransaction().commit();
		
		return account.getOwners();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void insertOwnerById(Person person, Integer aid) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Query query = session.createQuery("Select a from Account a where a.id = :id").setParameter("id", aid);
		Account account = (Account)query.uniqueResult();
		account.addOwner(person);
		session.update(account);
		
		session.getTransaction().commit();
	}

	@Override
	public void removeOwnerById(Person person, Integer aid) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Query query = session.createQuery("Select a from Account a where a.id = :id").setParameter("id", aid);
		Account account = (Account)query.uniqueResult();
		account.removeOwner(person);
		session.update(account);
		
		session.getTransaction().commit();
	}

	@Override
	public void saveAccount(Account account) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		session.save(account);
		
		session.getTransaction().commit();
	}

	@Override
	public List<Account> getAccountsByManager(Person manager) {

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		Query query = session.createQuery("select a from Account a where a.manager.userName = :manager").setParameter("manager", manager.getUserName());
		//Query query = session.createQuery("from Account");
		List<Account> accounts = (List<Account>)query.list();
		
		if (accounts.isEmpty()) {
			System.out.println("Empty!!!");
		}
		
		session.getTransaction().commit();
		
		return accounts;
	}

}
