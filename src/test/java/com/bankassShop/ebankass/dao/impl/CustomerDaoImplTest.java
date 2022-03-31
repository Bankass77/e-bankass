package com.bankassShop.ebankass.dao.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import com.bankassShop.ebankass.model.Address;
import com.bankassShop.ebankass.model.Customer;
import com.bankassShop.ebankass.model.Customer.Gender;
import com.bankassShop.ebankass.repository.AddresseRepository;
import com.bankassShop.ebankass.service.CustomerService;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Disabled
class CustomerDaoImplTest {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AddresseRepository addresseRepository;

	@Test
	void createCustomertest() {

		Customer customer = new Customer();
		Set<Address> allAddresses = new HashSet<Address>();
		
		customer.setFirstName("Albert");
		customer.setLastName("Einstein");
		customer.setEmail("albert@einstein.com");
		customer.setGender(Gender.FEMALE);
		customer.setPassword("ExaMple20022$");
		customer.setCreatedAt(LocalDateTime.now());
		customer.setUpdateAt(LocalDateTime.now());
		LocalDate dateOfBirth = LocalDate.of(2008, 6, 24);
		customer.setDateOfBirth(dateOfBirth);
		
		Address shippingAddresses = new Address();
		shippingAddresses.setAddressLine1("102");
		shippingAddresses.setAddressLine2("Jean-François");
		shippingAddresses.setCountry("France");
		shippingAddresses.setZipCode("75012");
		shippingAddresses.setCity("Paris");
		
		allAddresses.add(shippingAddresses);
		
		Address billingAddress = new Address();
		billingAddress.setAddressLine1("112");
		billingAddress.setAddressLine2("Mercier St");
		billingAddress.setCountry("France");
		billingAddress.setZipCode("75016");
		billingAddress.setCity("Paris");
		
		allAddresses.add(billingAddress);
		
		customer.setAddresses(allAddresses);
		
		customerService.createCustomer(customer);
		
	}

}
