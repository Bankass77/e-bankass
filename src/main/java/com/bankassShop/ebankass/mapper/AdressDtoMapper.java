package com.bankassShop.ebankass.mapper;

import org.modelmapper.ModelMapper;

import com.bankassShop.ebankass.Dto.AddressDto;
import com.bankassShop.ebankass.Dto.CustomerDto;
import com.bankassShop.ebankass.model.Address;

public class AdressDtoMapper {

	public static AddressDto addressToDto(Address address) {
		return new AddressDto().setAddressLine1(address.getAddressLine1()).setAddressLine2(address.getAddressLine2())
				.setCity(address.getCity()).setCountry(address.getCountry()).setZipCode(address.getZipCode())
				.setCustomerDto(new ModelMapper().map(address.getCustomer(), CustomerDto.class));

	}

}
