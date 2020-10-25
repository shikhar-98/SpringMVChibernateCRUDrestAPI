package com.crud.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.crud.rest.beans.MyCustomer;
import com.crud.rest.service.CustomerService;

@RestController 
public class CRUDRestController {

	@Autowired
	private CustomerService customerService;

	//setter for customerService
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	// Add Customer
	@RequestMapping(value = "/customer/new", method = RequestMethod.POST)
	public ResponseEntity<Void> addCustomer(@RequestBody MyCustomer customer, UriComponentsBuilder ucb) {
		if (customerService.isCustomerExist(customer)) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		} else {

			customerService.saveCustomer(customer);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucb.path("/customer/{id}").buildAndExpand(customer.getId()).toUri());
			return new ResponseEntity<Void>(HttpStatus.CREATED); 
		}
	}

	// Get Single Customer
	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MyCustomer> getCustomer(@PathVariable("id") int id) {

		MyCustomer customer = customerService.findById(id);
		if (customer == null) {
			return new ResponseEntity<MyCustomer>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<MyCustomer>(customer, HttpStatus.OK);
	}

	// Get All Customers
	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public ResponseEntity<List<MyCustomer>> listAllCustomers() {
		List<MyCustomer> customers = customerService.findAllCustomers();
		if (customers.isEmpty()) {
			return new ResponseEntity<List<MyCustomer>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<MyCustomer>>(customers, HttpStatus.OK);
	}

	// Update Customer
	@RequestMapping(value = "/customer/{id}", method = RequestMethod.PUT)
	public ResponseEntity<MyCustomer> updateCustomer(@PathVariable("id") int id, @RequestBody MyCustomer cus) {

		MyCustomer customer = customerService.findById(id);

		if (customer == null) {
			return new ResponseEntity<MyCustomer>(HttpStatus.NOT_FOUND);
		}

		customer.setName(cus.getName());
		customer.setAge(cus.getAge());
		customer.setEmail(cus.getEmail());
		customer.setCity(cus.getCity());

		customerService.updateCustomer(customer);
		return new ResponseEntity<MyCustomer>(customer, HttpStatus.OK);
	}

	// Delete Customer
	@RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<MyCustomer> deleteCustomer(@PathVariable("id") long id) {

		MyCustomer customer = customerService.findById(id);
		if (customer == null) {
			return new ResponseEntity<MyCustomer>(HttpStatus.NOT_FOUND);
		}

		customerService.deleteCustomerById(id);
		return new ResponseEntity<MyCustomer>(HttpStatus.OK);
	}

	// Delete All Customers
	@RequestMapping(value = "/customer/deleteall", method = RequestMethod.DELETE)
	public ResponseEntity<MyCustomer> deleteAllCustomers() {

		customerService.deleteAllCustomers();
		return new ResponseEntity<MyCustomer>(HttpStatus.OK);
	}
}
