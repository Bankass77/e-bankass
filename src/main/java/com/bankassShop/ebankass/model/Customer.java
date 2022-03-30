package com.bankassShop.ebankass.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Table(name = "customer")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customerId")
	private Long customerId;

	@NonNull
	@NotBlank
	@NotEmpty
	@Size(min =8)
	@Column
	private String password;

	@NonNull
	@NotBlank
	@NotEmpty
	@Size(min =3)
	@Column
	private String lastName;

	@NonNull
	@NotBlank
	@NotEmpty
	@Size(min =3)
	@Column
	private String firstName;

	@NonNull
	@Email
	@NotBlank
	@NotEmpty
    @Column(name = "email",unique = true)
	private String email;

	@NotBlank
	@NotEmpty
	@NotNull
	@Column
	private Timestamp dateOfBirth;

	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private Set<Address> addresses;

	public enum Gender {
		MALE, FEMALE
	}

	@Enumerated(EnumType.STRING)
	@NotNull
	@Column
	private Gender gender;

}
