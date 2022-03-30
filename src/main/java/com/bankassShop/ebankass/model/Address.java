package com.bankassShop.ebankass.model;

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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "addressId", insertable = false, updatable = false)
	private Long addressId;

	@NonNull
	@NotBlank
	@NotEmpty
	@Column
	private String addressLine1;

	@NonNull
	@NotBlank
	@NotEmpty
	@Column
	private String addressLine2;

	@NonNull
	@NotBlank
	@NotEmpty
	@Column
	private String city;

	@NonNull
	@NotBlank
	@NotEmpty
	@Column
	private String zipCode;

	@NonNull
	@NotBlank
	@NotEmpty
	@Column
	private String country;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "customerId")
	private Customer customer;

}
