package com.tin.clientsOrganization.repositories;

import com.tin.clientsOrganization.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Optional<Customer> findById(Long id);

    List<Customer> findByName(String name);
}
