package org.cs.demoria.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.cs.demoria.dao.ProductDao;
import org.cs.demoria.model.Account;
import org.cs.demoria.model.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository("productDao")
public class ProductDaoImpl implements ProductDao {

	private SessionFactory sessionFactory;
	
	@Override
	public List<Product> findAllProducts() {

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from Product");
		List<Product> products = (List<Product>)query.list();
		
		session.getTransaction().commit();
				
		return products;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
