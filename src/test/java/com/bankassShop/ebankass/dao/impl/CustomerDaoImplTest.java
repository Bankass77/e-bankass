package com.bankassShop.ebankass.dao.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import com.bankassShop.ebankass.model.Address;
import com.bankassShop.ebankass.model.Customer;
import com.bankassShop.ebankass.service.CustomerService;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CustomerDaoImplTest {

	@Autowired
	private CustomerService customerDao;

	@Test
	void createCustomertest() {

		Customer customer = new Customer();

		customer.setFirstName("Albert");
		customer.setLastName("Einstein");
		customer.setEmail("albert@einstein.com");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		try {
			Date parsed = sdf.parse("1879014");
			Timestamp dateOfBirth = new Timestamp(parsed.getTime());
			customer.setDateOfBirth(dateOfBirth);
		} catch (Exception e) {
			System.out.println("Error in parsing the date of birth");
		}

		Set<Address> allAddresses = new HashSet<Address>();
		Address shippingAddresses = new Address();
		shippingAddresses.setAddressLine1("112");
		shippingAddresses.setAddressLine2("Mercier St");
		shippingAddresses.setCountry("France");
		shippingAddresses.setZipCode("75016");
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

		customerDao.save(customer);

	}

}
