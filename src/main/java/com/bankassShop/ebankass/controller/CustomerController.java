package com.bankassShop.ebankass.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bankassShop.ebankass.model.Customer;
import com.bankassShop.ebankass.service.CustomerService;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/getCustomerByEmail/{email}", method = RequestMethod.GET)
	public Customer findCustomerByEmail(String email) {

		Customer customer = customerService.findCustomerByEmail(email);
		return customer;

	}

	@RequestMapping(method = RequestMethod.GET)
	public Set<Customer> getAllCustomer() {

		Set<Customer> customers = customerService.getAll();

		return customers;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Customer createNewCustomer(Customer customer) {

		customer = customerService.createCustomer(customer);
		return customer;
	}

	
	@RequestMapping(value = "/update/{id}")
	public  void update( Customer customer) {
		
		customerService.updateCustomer(customer);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete (Customer customer) {
		
		customerService.deleteCustomer(customer);
	}
}
