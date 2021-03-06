package com.bankassShop.ebankass.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bankassShop.ebankass.Dto.CustomerDto;
import com.bankassShop.ebankass.service.CustomerService;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/getCustomerByEmail/{email}", method = RequestMethod.GET)
	public CustomerDto findCustomerByEmail(String email) {

		CustomerDto customer = customerService.findCustomerByEmail(email);
		return customer;

	}

	@RequestMapping(method = RequestMethod.GET)
	public Set<CustomerDto> getAllCustomer() {

		Set<CustomerDto> customers = customerService.getAll();
         ModelAndView modelAndView= new ModelAndView("allCustomer");
         
         modelAndView.addObject("customers", customers);
		return customers;
	}

	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public CustomerDto createNewCustomer(@Valid CustomerDto customer) {

		ModelAndView modelAndView= new ModelAndView("createCustomer");
		
		customer = customerService.createCustomer(customer);
		
		modelAndView.addObject("createCustomer", customer);
		return customer;
	}

	@RequestMapping(value = "/update/{id}")
	public void update(CustomerDto customer) {

		customerService.updateCustomer(customer);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(CustomerDto customer) {

		customerService.deleteCustomer(customer);
	}
}
