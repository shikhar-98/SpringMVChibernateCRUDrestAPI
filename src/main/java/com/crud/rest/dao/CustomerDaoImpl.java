package com.crud.rest.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.crud.rest.beans.MyCustomer;

public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	//setter for sessionFactory
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public MyCustomer findById(long id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		MyCustomer customer = new MyCustomer();
		try {
			customer = (MyCustomer) session.get(MyCustomer.class, id);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			transaction.rollback();
			session.close();
		}
		return customer;
	}

	public MyCustomer findByName(String name) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		MyCustomer customer = new MyCustomer();
		String hql = "from com.crud.rest.beans.MyCustomer where name = ?";
		try {
			Query query = session.createQuery(hql);
			query.setParameter(0, name);
			customer = (MyCustomer) query.uniqueResult();
			transaction.commit();
			session.close();
		} catch (Exception e) {
			transaction.rollback();
			session.close();
		}
		return customer;
	}

	public void saveCustomer(MyCustomer Customer) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		if (Customer != null) {
			try {
				session.save(Customer);
				transaction.commit();
			} catch (Exception e) {
				transaction.rollback();
				session.close();
			}

		}

	}

	public void updateCustomer(MyCustomer Customer) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		if (Customer != null) {
			try {
				session.update(Customer);
				transaction.commit();
			} catch (Exception e) {
				transaction.rollback();
				session.close();
			}

		}

	}

	public void deleteCustomerById(long id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		MyCustomer customer = new MyCustomer();
		try {
			customer = (MyCustomer) session.get(MyCustomer.class, id);
			session.delete(customer);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			transaction.rollback();
			session.close();
		}

	}

	@SuppressWarnings("unchecked")
	public List<MyCustomer> findAllCustomers() {
		List<MyCustomer> customer = new ArrayList<MyCustomer>();
		Session session = sessionFactory.openSession();
		customer = session.createQuery("From com.crud.rest.beans.MyCustomer").list();
		return customer;
	}

	
	public void deleteAllCustomers() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.createQuery("delete from MyCustomer").executeUpdate();
			transaction.commit();
			session.close();
		} catch (Exception e) {
			transaction.rollback();
			session.close();
		}

	}

	public boolean isCustomerExist(MyCustomer Customer) {
		
			return findByName(Customer.getName())!=null;
	}

}
