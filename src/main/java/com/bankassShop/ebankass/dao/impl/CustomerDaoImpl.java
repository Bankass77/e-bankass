package com.bankassShop.ebankass.dao.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankassShop.ebankass.dao.CustomerDao;
import com.bankassShop.ebankass.model.Customer;

@Service
@Transactional
public class CustomerDaoImpl implements CustomerDao {

	private SessionFactory sessionFactory;

	@Autowired
	public CustomerDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Customer get(int id) {

		CriteriaBuilder criteriaBuilder = sessionFactory.getCurrentSession().getCriteriaBuilder();

		CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);

		Root<Customer> root = criteriaQuery.from(Customer.class);

		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("customerId"), id));

		org.hibernate.query.Query<Customer> query = sessionFactory.getCurrentSession().createQuery(criteriaQuery);

		return query.getSingleResult();
	}

	@Override
	public List<Customer> getAll() {

		CriteriaBuilder criteriaBuilder = sessionFactory.getCurrentSession().getCriteriaBuilder();

		CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);

		Root<Customer> root = criteriaQuery.from(Customer.class);
		criteriaQuery.select(root);
		org.hibernate.query.Query<Customer> query = sessionFactory.getCurrentSession().createQuery(criteriaQuery);

		List<Customer> customers = query.getResultList();

		return customers;
	}

	@Override
	public Long save(Customer t) {

		Customer customer = t;

		sessionFactory.getCurrentSession().saveOrUpdate(customer);
		sessionFactory.getCurrentSession().flush();
		return customer.getCustomerId();
	}

	@Override
	public void update(Customer t) {

		Customer customer = t;

		sessionFactory.getCurrentSession().saveOrUpdate(customer);

	}

	@Override
	public void delete(Customer t) {

		Optional<Customer> customer = Optional.ofNullable(t);

		if (customer.isPresent()) {

			sessionFactory.getCurrentSession().delete(customer);

		}

	}

	@Override
	public Customer findCustomerByEmail(String email) {

		CriteriaBuilder criteriaBuilder = sessionFactory.getCurrentSession().getCriteriaBuilder();

		CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);

		Root<Customer> root = criteriaQuery.from(Customer.class);
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("email"), email));
		org.hibernate.query.Query<Customer> q = sessionFactory.getCurrentSession().createQuery(criteriaQuery);
		return q.getSingleResult();
	}

}
