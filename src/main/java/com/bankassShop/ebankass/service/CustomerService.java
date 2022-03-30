package com.bankassShop.ebankass.service;

import java.util.Set;

import com.bankassShop.ebankass.model.Customer;

public interface CustomerService {

	Customer get(long id);

	Set<Customer> getAll();

	Long save(Customer t);

	void update(Customer t);

	void delete(Customer t);

	Customer findCustomerByEmail(String email);

}
