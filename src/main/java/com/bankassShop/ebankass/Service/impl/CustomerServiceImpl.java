package com.bankassShop.ebankass.Service.impl;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankassShop.ebankass.Dto.AddressDto;
import com.bankassShop.ebankass.Dto.CustomerDto;
import com.bankassShop.ebankass.model.Address;
import com.bankassShop.ebankass.model.Customer;
import com.bankassShop.ebankass.repository.CustomerRepository;
import com.bankassShop.ebankass.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Service("customerService")
@Transactional
@Slf4j
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepository customerRepository;

	private final ModelMapper modelMapper;

	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper) {
		super();
		this.customerRepository = customerRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public CustomerDto getCustomerById(long id) {

		Optional<Customer> cOptional = customerRepository.findById(id);
		log.debug("Customer id is: {}", cOptional.get());
		return modelMapper.map(cOptional.get(), CustomerDto.class);

	}

	@Override
	public Set<CustomerDto> getAll() {

		List<Customer> customers = customerRepository.findAll();

		Set<Customer> setCustomers = new HashSet<Customer>(customers);

		Set<CustomerDto> customerDtos = setCustomers.stream()
				.map(customer -> modelMapper.map(customer, CustomerDto.class)).collect(Collectors.toSet());
		log.debug("All customer are:{}", customerDtos);
		return customerDtos;

	}

	@Override
	public CustomerDto createCustomer(CustomerDto customerDto) {

		if (!emailExist(customerDto.getEmail())) {
			Customer customer = new Customer();

			Set<AddressDto> addressDtos = customerDto.getAddressDtos();

			Set<Address> addresses = addressDtos.stream().map(address -> modelMapper.map(address, Address.class))
					.collect(Collectors.toSet());

			customer.setDateOfBirth(customerDto.getDateOfBirth());
			customer.setEmail(customerDto.getEmail());
			customer.setFirstName(customerDto.getFirstName());
			customer.setLastName(customerDto.getLastName());
			customer.setPassword(customerDto.getPassword());
			customer.setGender(customerDto.getGender());
			customer.setAddresses(addresses);
			customer.setCreatedAt(LocalDateTime.now());
			customer.setUpdateAt(LocalDateTime.now());

			log.debug("New Customer created:{}", customer);
			return modelMapper.map(customerRepository.save(customer), CustomerDto.class);
		}

		return null;
	}

	@Override
	public void updateCustomer(CustomerDto customerDto) {

		Customer customer = new Customer();
		customer.setDateOfBirth(customerDto.getDateOfBirth());
		customer.setEmail(customerDto.getEmail());
		customer.setFirstName(customerDto.getFirstName());
		customer.setLastName(customerDto.getLastName());
		customer.setPassword(customerDto.getPassword());
		customer.setAddresses(customerDto.getAddressDtos().stream()
				.map(address -> modelMapper.map(address, Address.class)).collect(Collectors.toSet()));
		customer.setCreatedAt(LocalDateTime.now());
		customer.setUpdateAt(LocalDateTime.now());

		modelMapper.map(customerRepository.save(customer), CustomerDto.class);

	}

	@Override
	public void deleteCustomer(CustomerDto t) {

		customerRepository.delete(modelMapper.map(t, Customer.class));

	}

	@Override
	public CustomerDto findCustomerByEmail(String email) {

		Customer customer = customerRepository.findCustomerByEmail(email);
		return modelMapper.map(customer, CustomerDto.class);

	}

	@Override
	public boolean emailExist(String email) {

		return customerRepository.findCustomerByEmail(email) != null;
	}


}
