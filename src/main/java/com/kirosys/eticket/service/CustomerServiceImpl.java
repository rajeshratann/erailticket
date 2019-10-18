package com.kirosys.eticket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kirosys.eticket.dao.CustomerDAO;
import com.kirosys.eticket.model.CustomerDetails;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public long saveCustomerDetails(CustomerDetails customerDetails) {

		return customerDAO.saveCustomerDetails(customerDetails);
	}

	@Override
	@Transactional
	public CustomerDetails getCustomerDetailsByID(long id) {
		return customerDAO.getCustomerDetailsByID(id);
	}

	@Override
	@Transactional
	public List<CustomerDetails> getAllCustomerDetails() {

		return customerDAO.getAllCustomerDetails();
	}

	@Override
	@Transactional
	public void updateDetails(long id, CustomerDetails customerDetails) {
		customerDAO.updateDetails(id, customerDetails);
	}

	@Override
	@Transactional
	public void deleteCustomerDetails(long id) {
		customerDAO.deleteCustomerDetails(id);
	}

}
