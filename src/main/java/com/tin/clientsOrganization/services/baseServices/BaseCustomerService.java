package com.tin.clientsOrganization.services.baseServices;

import com.tin.clientsOrganization.entities.Customer;
import com.tin.clientsOrganization.repositories.CustomerRepository;
import com.tin.clientsOrganization.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BaseCustomerService implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer findById(Long id) {
        Optional<Customer> c = customerRepository.findById(id);
        return c.get();
    }

    @Override
    public List<Customer> findByName(String name) {
        return customerRepository.findByName(name);
    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void delete(Long id) {
        customerRepository.delete(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
}
