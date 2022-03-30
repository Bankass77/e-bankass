package com.bankassShop.ebankass.model;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Table(name = "customer")
@Entity
@Getter
@Setter
public class Customer {

	@Id
	@GeneratedValue
	private Long customerId;

	private String password;

	private String lastName;

	private String firstName;

	private String email;

	private Timestamp dateOfBirth;
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private Set<Address> addresses;
}
