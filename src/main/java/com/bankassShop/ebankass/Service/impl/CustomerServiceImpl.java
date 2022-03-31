package com.bankassShop.ebankass.Service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankassShop.ebankass.model.Address;
import com.bankassShop.ebankass.model.Customer;
import com.bankassShop.ebankass.repository.AddresseRepository;
import com.bankassShop.ebankass.repository.CustomerRepository;
import com.bankassShop.ebankass.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;

	private AddresseRepository addressRepository;

	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository, AddresseRepository addressRepository) {
		super();
		this.customerRepository = customerRepository;
		this.addressRepository = addressRepository;
	}

	@Override
	public Customer getCustomerById(long id) {

		Optional<Customer> cOptional = customerRepository.findById(id);

		return cOptional.get();

	}

	@Override
	public Set<Customer> getAll() {

		List<Customer> customers = customerRepository.findAll();

		Set<Customer> setCustomers = new HashSet<Customer>(customers);
		return setCustomers;

	}

	@Override
	public Customer createCustomer(Customer t) {

		Customer customer = new Customer();

		customer.setAddresses(t.getAddresses());
		customer.setCreatedAt(t.getCreatedAt());
		customer.setCustomerId(t.getCustomerId());
		customer.setDateOfBirth(t.getDateOfBirth());
		customer.setEmail(t.getEmail());
		customer.setFirstName(t.getFirstName());
		customer.setGender(t.getGender());
		customer.setLastName(t.getLastName());
		customer.setPassword(t.getPassword());
		customer.setUpdateAt(t.getUpdateAt());

		log.debug("Customer address is:{}", customer);

		customerRepository.save(customer);
		return customer;

	}

	@Override
	public void updateCustomer(Customer t) {
		
		Customer customer = new Customer();

		customer.setAddresses(t.getAddresses());
		customer.setCreatedAt(t.getCreatedAt());
		customer.setCustomerId(t.getCustomerId());
		customer.setDateOfBirth(t.getDateOfBirth());
		customer.setEmail(t.getEmail());
		customer.setFirstName(t.getFirstName());
		customer.setGender(t.getGender());
		customer.setLastName(t.getLastName());
		customer.setPassword(t.getPassword());
		customer.setUpdateAt(t.getUpdateAt());
		customerRepository.save(customer);

	}

	@Override
	public void deleteCustomer(Customer t) {

		customerRepository.delete(t);

	}

	@Override
	public Customer findCustomerByEmail(String email) {

		Customer customer = customerRepository.findCustomerByEmail(email);
		return customer;

	}

}
