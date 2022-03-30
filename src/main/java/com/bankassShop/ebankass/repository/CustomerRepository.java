package com.bankassShop.ebankass.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankassShop.ebankass.model.Customer;

@Repository
public interface CustomerRepository extends  JpaRepository<Customer, Long>{
	
	
	Customer findCustomerByEmail(String email);
	

}
