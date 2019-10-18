package com.kirosys.eticket.service;

import java.util.List;

import com.kirosys.eticket.model.CustomerDetails;

public interface CustomerService {

	// Save CutomerDetails
	public long saveCustomerDetails(CustomerDetails customerDetails);

	// getCustomerDetails by id
	public CustomerDetails getCustomerDetailsByID(long id);

	// get All Customer
	public List<CustomerDetails> getAllCustomerDetails();

	// update details
	public void updateDetails(long id, CustomerDetails customerDetails);

	// Delete Details
	public void deleteCustomerDetails(long id);

}
