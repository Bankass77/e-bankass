package com.bankassShop.ebankass.service;

import java.util.Set;

import com.bankassShop.ebankass.Dto.CustomerDto;
import com.bankassShop.ebankass.model.Customer;

public interface CustomerService {

	CustomerDto getCustomerById(long id);

	Set<CustomerDto> getAll();

	CustomerDto createCustomer(CustomerDto t);

	void updateCustomer(CustomerDto t);

	void deleteCustomer(CustomerDto t);

	CustomerDto findCustomerByEmail(String email);
	boolean emailExist(String email);
}
