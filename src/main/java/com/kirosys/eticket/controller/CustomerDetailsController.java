package com.kirosys.eticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kirosys.eticket.model.CustomerDetails;
import com.kirosys.eticket.service.CustomerService;

@CrossOrigin("*")
@RestController
public class CustomerDetailsController {

	@Autowired
	private CustomerService customerService;

	// Get all Customer details
	@GetMapping("/api/customer")
	public ResponseEntity<List<CustomerDetails>> getAllCustomerDetails() {

		List<CustomerDetails> customerDetaillist = customerService.getAllCustomerDetails();

		return ResponseEntity.ok().body(customerDetaillist);

	}

	// Save Customer Details
	@PostMapping("api/customer")
	public ResponseEntity<?> saveCustomerDetails(@RequestBody CustomerDetails customerDetails) {

		long id = customerService.saveCustomerDetails(customerDetails);

		return ResponseEntity.ok().body("Customer created with id: " + id);

	}

	// get Customer Details by id
	@GetMapping("/api/customer/{id}")
	public ResponseEntity<CustomerDetails> getCustomerDetailsByID(@PathVariable("id") long id) {
		CustomerDetails customerDetails = customerService.getCustomerDetailsByID(id);
		return ResponseEntity.ok().body(customerDetails);

	}

	// update Customer Details by id
	@PutMapping("/api/customer/{id}")
	public ResponseEntity<?> updateDetails(@PathVariable("id") long id, @RequestBody CustomerDetails customerDetails) {
		customerService.updateDetails(id, customerDetails);
		return ResponseEntity.ok().body("Customer Details is updated sucessfully");
	}

	// Deleted Customer Record by id
	@DeleteMapping("/api/customer/{id}")
	public ResponseEntity<?> deleteCustomerDetails(@PathVariable("id") long id) {
		customerService.deleteCustomerDetails(id);
		return ResponseEntity.ok().body("Customer Details is deleted");

	}

}
