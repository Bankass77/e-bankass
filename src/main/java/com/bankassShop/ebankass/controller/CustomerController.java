package com.bankassShop.ebankass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bankassShop.ebankass.dao.CustomerDao;
import com.bankassShop.ebankass.model.Customer;

@Controller
public class CustomerController {

	@Autowired
	private CustomerDao customerDao;

	
	@RequestMapping(value = "/customer/getCustomerByEmail/{email}", method = RequestMethod.GET )
	public Customer findCustomerByEmail(String email) {

		Customer customer = customerDao.findCustomerByEmail(email);
		return customer;

	}

}
