package com.bankassShop.ebankass.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
	@Column(name = "addressId", unique = true, nullable = false, insertable = true, updatable = true)
	private Long addressId;

	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "address1", unique = false, nullable = true, insertable = true, updatable = true)
	@Pattern(regexp = "^[a-zA-Z0-9]{4}", message = "First name should contain only alphabets")
	private String addressLine1;

	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "address2", unique = false, nullable = true, insertable = true, updatable = true)
	@Pattern(regexp = "^[a-zA-Z0-9]{4}", message = "First name should contain only alphabets")
	private String addressLine2;

	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "city", unique = false, nullable = true, insertable = true, updatable = true)
	private String city;

	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "zipcode", unique = false, nullable = true, insertable = true, updatable = true)
	@Pattern(regexp = "^(?:[0-8]\\d|9[0-8])\\d{3}$", message = "Zip Code should contain only Numeric")
	private String zipCode;

	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "country", unique = false, nullable = true, insertable = true, updatable = true)
	private String country;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_Id", referencedColumnName = "customerId")
	private Customer customer;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "address_shipping_Id", referencedColumnName = "shippingId")
	private Shipping shipping;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "invoice_id", referencedColumnName = "invoiceId")
	private Invoice invoice;

}
