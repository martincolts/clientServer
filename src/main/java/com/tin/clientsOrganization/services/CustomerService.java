package com.tin.clientsOrganization.services;

import com.tin.clientsOrganization.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Customer findById (Long id);

    List<Customer> findByName(String name);

    Customer update (Customer customer);

    void delete (Long id);

    Customer save(Customer customer);

    List<Customer> getAll();
}
