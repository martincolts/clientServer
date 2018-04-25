package com.tin.clientsOrganization.services.baseServices;

import com.google.common.base.Strings;
import com.tin.clientsOrganization.entities.Customer;
import com.tin.clientsOrganization.repositories.CustomerRepository;
import com.tin.clientsOrganization.repositories.SaleRepository;
import com.tin.clientsOrganization.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BaseCustomerService implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private SaleRepository saleRepository;

    @Override
    public Customer findById(Long id) {
        Optional<Customer> c = customerRepository.findById(id);
        if (c.isPresent())
            return c.get();
        return null;
    }

    @Override
    public List<Customer> findByName(String name) {
        return customerRepository.findByName(name);
    }

    @Override
    public Customer update(Customer customer) {
        Optional<Customer> opCus= customerRepository.findById(customer.getId());
        Customer customerToModify = opCus.get();
        customer.setName(!Strings.isNullOrEmpty(customer.getName())?customer.getName():customerToModify.getName());
        customer.setLastname(!Strings.isNullOrEmpty(customer.getLastname())?customer.getLastname():customerToModify.getLastname());
        customer.setPhoneNumber(!Strings.isNullOrEmpty(customer.getPhoneNumber())?customer.getPhoneNumber():customerToModify.getPhoneNumber());
        customer.setDni(!Strings.isNullOrEmpty(customer.getDni())?customer.getDni():customerToModify.getDni());
        customer.setAddress(!Strings.isNullOrEmpty(customer.getAddress())?customer.getAddress():customerToModify.getAddress());
        customerRepository.updateById(customer.getName(),customer.getLastname(),customer.getPhoneNumber(),customer.getDni(),
                customer.getAddress(),customer.getId());
        return customer ;
    }

    @Override
    public void delete(Long id) {
        saleRepository.updateSales(customerRepository.findById(id).get());
        customerRepository.delete(id);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
}
