package com.bankassShop.ebankass.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "customer")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customerId", unique = true, nullable = false, insertable = true, updatable = true)
	private Long customerId;

	@NotNull
	@NotBlank
	@NotEmpty
	@Size(min = 8)
	@Column(name = "password", unique = false, nullable = true, insertable = true, updatable = true)
	private String password;

	@NotNull
	@NotBlank
	@NotEmpty
	@Size(min = 3)
	@Column(name = "lastName", unique = false, nullable = true, insertable = true, updatable = true)
	 @Pattern(regexp = "^[A-Za-z]+$", message = "First name should contain only alphabets")
	private String lastName;

	@NotNull
	@NotBlank
	@NotEmpty
	@Size(min = 3)
	@Column(name = "firstName", unique = false, nullable = true, insertable = true, updatable = true)
	 @Pattern(regexp = "^[A-Za-z]+$", message = "First name should contain only alphabets")
	private String firstName;

	@NotNull
	@Email
	@NotBlank
	@NotEmpty
	@Column(name = "email", unique = true, nullable = true, insertable = true, updatable = true)
	private String email;

	@NotBlank
	@NotEmpty
	@NotNull
	@Column(name = "dateOfBirth", nullable = true, insertable = true, updatable = true)
	@Past(message = "Date of birth cannot be in the future")
	private LocalDate dateOfBirth;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	//@JoinColumn(name = "customerId")
	private Set<Address> addresses = new HashSet<Address>();

	public enum Gender {
		MALE, FEMALE
	}

	@Enumerated(EnumType.STRING)
	@NotNull
	@Column(name = "gender", nullable = true, insertable = true, updatable = true)
	private Gender gender;

	@Column(name = "createdAt")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime createdAt;

	@Column(name = "updateAt")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime updateAt;

	@PrePersist
	void onCreate() {
		this.setCreatedAt(LocalDateTime.now());

	}

	@PreUpdate
	void onUpdate() {
		this.setUpdateAt(LocalDateTime.now());
	}
}
