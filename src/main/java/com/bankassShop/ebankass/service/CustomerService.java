package com.bankassShop.ebankass.service;

import java.util.Set;

import com.bankassShop.ebankass.model.Customer;

public interface CustomerService {

	Customer getCustomerById(long id);

	Set<Customer> getAll();

	Customer createCustomer(Customer t);

	void updateCustomer(Customer t);

	void deleteCustomer(Customer t);

	Customer findCustomerByEmail(String email);

}
