package com.kirosys.eticket.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kirosys.eticket.model.CustomerDetails;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long saveCustomerDetails(CustomerDetails customerDetails) {
		sessionFactory.getCurrentSession().save(customerDetails);
		return customerDetails.getId();
	}

	@Override
	public CustomerDetails getCustomerDetailsByID(long id) {
		return sessionFactory.getCurrentSession().get(CustomerDetails.class, id);

	}

	@Override
	public List<CustomerDetails> getAllCustomerDetails() {
		@SuppressWarnings("unchecked")
		List<CustomerDetails> customerList = sessionFactory.getCurrentSession().createQuery("from CustomerDetails")
				.list();
		return customerList;
	}

	@Override
	public void updateDetails(long id, CustomerDetails customerDetails) {
		Session session = sessionFactory.getCurrentSession();
		CustomerDetails customerDetails2 = session.byId(CustomerDetails.class).load(id);
		customerDetails2.setCusIdentity(customerDetails.getCusIdentity());
		customerDetails2.setCustFirstName(customerDetails.getCustFirstName());
		customerDetails2.setCustLastName(customerDetails.getCustLastName());
		customerDetails2.setCustMidName(customerDetails.getCustMidName());
		customerDetails2.setCustMobile(customerDetails.getCustMobile());
		customerDetails2.setLocalAddress(customerDetails.getLocalAddress());
		customerDetails2.setPermanentAddress(customerDetails.getPermanentAddress());
		session.flush();
	}

	@Override
	public void deleteCustomerDetails(long id) {
		Session session = sessionFactory.getCurrentSession();
		CustomerDetails customerDetails = session.byId(CustomerDetails.class).load(id);
		session.delete(customerDetails);
	}

}
