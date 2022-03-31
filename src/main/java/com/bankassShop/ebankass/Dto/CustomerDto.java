package com.bankassShop.ebankass.Dto;

import java.time.LocalDate;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import com.bankassShop.ebankass.model.Customer.Gender;

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
public class CustomerDto {

	
	private Gender gender;
	
	@Pattern(regexp = "^[A-Za-z]+$", message = "First name should contain only alphabets")
	private String firstName;

	@Pattern(regexp = "^[A-Za-z]+$", message = "Last name should contain only alphabets")
	private String lastName;

	@Email(message = "Enter a valid email address")
	private String email;
	
	private String password;

	@Past(message = "Date of birth cannot be in the future")
	private LocalDate dateOfBirth;

	private Set<AddressDto> addressDtos;

}
