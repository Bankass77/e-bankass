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
	public Customer get(long id) {

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
	public Long save(Customer t) {

		Customer customer = customerRepository.save(t);
		Address address = addressRepository.save(customer.getAddresses().iterator().next());
		log.debug("Customer address is:{}", address);
		return customer.getCustomerId();

	}

	@Override
	public void update(Customer t) {
		addressRepository.save(t.getAddresses().iterator().next());
		customerRepository.save(t);

	}

	@Override
	public void delete(Customer t) {

		customerRepository.delete(t);

	}

	@Override
	public Customer findCustomerByEmail(String email) {

		Customer customer = customerRepository.findCustomerByEmail(email);
		return customer;

	}

}
