package com.bankassShop.ebankass.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table
@Entity(name = "offer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
public class Offer implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long offerId;

	private LocalDate offerDate;

	private String vendor;

	private String channel;

	private LocalDate validForm;

	private LocalDate validTo;

	private String description;

	private int quantity;

	private double price;

	private String paymentMethod;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "offer")
	private Coupon coupon;
	// private OrderedMap properties;

}
