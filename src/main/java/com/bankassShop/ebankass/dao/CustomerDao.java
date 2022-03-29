package com.bankassShop.ebankass.dao;

import com.bankassShop.ebankass.model.Customer;

public interface CustomerDao extends GenericDao<Customer> {
	
	
	Customer findCustomerByEmail(String email);

}
