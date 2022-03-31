package com.bankassShop.ebankass.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "addressId", unique = true, nullable = false, insertable=true, updatable=true)
	private Long addressId;

	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "address1", unique = false, nullable = true, insertable=true, updatable=true)
	private String addressLine1;

	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "address2", unique = false, nullable = true, insertable=true, updatable=true)
	private String addressLine2;

	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "city", unique = false, nullable = true, insertable=true, updatable=true)
	private String city;

	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "zipcode", unique = false, nullable = true, insertable=true, updatable=true)
	private String zipCode;

	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "country", unique = false, nullable = true, insertable=true, updatable=true)
	private String country;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_Id", referencedColumnName = "customerId")
	private Customer customer;

}
