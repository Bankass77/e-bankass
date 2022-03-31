package com.bankassShop.ebankass.dao.impl;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import com.bankassShop.ebankass.Dto.AddressDto;
import com.bankassShop.ebankass.Dto.CustomerDto;
import com.bankassShop.ebankass.model.Customer.Gender;
import com.bankassShop.ebankass.service.CustomerService;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Disabled
class CustomerDaoImplTest {

	@Autowired
	private CustomerService customerService;

	@Test
	void createCustomertest() {

		CustomerDto customer = new CustomerDto();
		Set<AddressDto> allAddresses = new HashSet<AddressDto>();

		customer.setFirstName("Albert");
		customer.setLastName("Einstein");
		customer.setEmail("albert5@einstein.com");
		customer.setGender(Gender.FEMALE);
		customer.setPassword("ExaMple20022$");
		customer.setGender(Gender.MALE);
		LocalDate dateOfBirth = LocalDate.of(2008, 6, 24);
		customer.setDateOfBirth(dateOfBirth);

		AddressDto shippingAddresses = new AddressDto();
		shippingAddresses.setAddressLine1("102");
		shippingAddresses.setAddressLine2("Jean-François");
		shippingAddresses.setCountry("France");
		shippingAddresses.setZipCode("75012");
		shippingAddresses.setCity("Paris");

		allAddresses.add(shippingAddresses);

		AddressDto billingAddress = new AddressDto();
		billingAddress.setAddressLine1("112");
		billingAddress.setAddressLine2("Mercier St");
		billingAddress.setCountry("France");
		billingAddress.setZipCode("75016");
		billingAddress.setCity("Paris");

		allAddresses.add(billingAddress);

		customer.setAddressDtos(allAddresses);

		customerService.createCustomer(customer);

	}

}
