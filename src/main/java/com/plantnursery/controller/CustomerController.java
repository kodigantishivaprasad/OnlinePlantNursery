package com.plantnursery.controller;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plantnursery.entity.Customer;
import com.plantnursery.exceptions.UserNotFoundException;
import com.plantnursery.service.ICustomerService;


@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/customers") // Request Mapping tells which URL will initiate what method
public class CustomerController {

	@Autowired
	private ICustomerService customerService;

	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> addNewCustomer(@RequestBody Customer customer) {
		customerService.addNewCustomer(customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
	}

// =========================================================================================================================================	

	@PutMapping({ "/updateCustomer/id/{customerId}" })
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable int customerId)
			throws UserNotFoundException {
		customerService.updateCustomer(customer, customerId);
		return new ResponseEntity<Customer>(customer, HttpStatus.ACCEPTED);
	}

// ========================================================================================================================================		

	@GetMapping("/viewAllCustomers")
	public ResponseEntity<List<Customer>> viewAllCustomers() throws UserNotFoundException {
		return new ResponseEntity<List<Customer>>(customerService.getAllCustomers(), HttpStatus.OK);
	}
	
// ========================================================================================================================================
	
	
	@GetMapping("/viewCustomer/id/{customerId}")
	public ResponseEntity<Customer> viewCustomer(@PathVariable Integer customerId) throws UserNotFoundException {
		// logger.trace("fetching the plant with id "+ id);
		return new ResponseEntity<Customer>(customerService.getCustomer(customerId), HttpStatus.OK);
	}


	@DeleteMapping("/deleteCustomer/id/{customerId}")
	public ResponseEntity<Customer> deleteById(@PathVariable Integer customerId) throws UserNotFoundException {

		return new ResponseEntity<Customer>(customerService.deleteCustomer(customerId), HttpStatus.OK);
	}
	
// ========================================================================================================================================
	
	@GetMapping(path = "/validateCustomer/{username}/{password}")
	public ResponseEntity<Customer> validateCustomer(@PathVariable Customer customer, @PathVariable String username,
			@PathVariable String password) {
		Customer customer1 = customerService.validateCustomer(customer, username, password);

		return new ResponseEntity<Customer>(customer1, HttpStatus.OK);
	}
}