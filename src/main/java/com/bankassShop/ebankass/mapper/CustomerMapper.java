package com.bankassShop.ebankass.mapper;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.bankassShop.ebankass.Dto.AddressDto;
import com.bankassShop.ebankass.Dto.CustomerDto;
import com.bankassShop.ebankass.model.Customer;

@Component
public class CustomerMapper {

	public static CustomerDto customerToDto(Customer customer) {

		return new CustomerDto().setDateOfBirth(customer.getDateOfBirth()).setEmail(customer.getEmail())
				.setFirstName(customer.getFirstName()).setLastName(customer.getLastName())
				.setAddressDtos(customer.getAddresses().stream()
						.map(address -> new ModelMapper().map(address, AddressDto.class)).collect(Collectors.toSet()))
				.setGender(customer.getGender()).setPassword(customer.getPassword());

	}

}
