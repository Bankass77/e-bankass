package com.bankassShop.ebankass.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankassShop.ebankass.model.Address;

@Repository
public interface AddresseRepository extends JpaRepository<Address, Long> {

}
