package org.cs.demoria.dao.impl;

import javax.annotation.Resource;

import org.cs.demoria.dao.InvestDao;
import org.cs.demoria.model.Account;
import org.cs.demoria.model.Investment;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository("investDao")
public class InvestDaoImpl implements InvestDao {

	private SessionFactory sessionFactory;
	
	@Override
	public void saveInvest(Investment investment) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		//session.evict(investment.getProduct());
		session.merge(investment);
		//session.flush();
		
		session.getTransaction().commit();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
