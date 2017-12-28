package com.tin.clientsOrganization.services;

import com.tin.clientsOrganization.entities.Customer;

import java.util.List;

public interface CustomerService {

    Customer findById (Long id);

    List<Customer> findByName(String name);

    void update (Customer customer);

    void delete (Long id);

    void save(Customer customer);

    List<Customer> getAll();
}
