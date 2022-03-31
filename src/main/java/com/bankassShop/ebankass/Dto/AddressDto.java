package com.bankassShop.ebankass.Dto;

import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Setter
@Getter
@ToString
public class AddressDto {
	

	@Pattern(regexp = "^[A-Za-z]+$", message = "First name should contain only alphabets")
	private String addressLine1;


	@Pattern(regexp = "^[A-Za-z]+$", message = "First name should contain only alphabets")
	private String addressLine2;


	private String city;

	@Pattern(regexp = "^(?:[0-8]\\d|9[0-8])\\d{3}$", message = "Zip Code should contain only Numeric")
	private String zipCode;

	
	private String country;

	private CustomerDto customerDto;

}
