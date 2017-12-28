package com.tin.clientsOrganization.controllers;

import com.tin.clientsOrganization.dtos.CustomerDTO;
import com.tin.clientsOrganization.entities.Customer;
import com.tin.clientsOrganization.mapper.MapperManager;
import com.tin.clientsOrganization.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private MapperManager mapperManager;

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Customer findById(@PathVariable Long id){
        return customerService.findById(id);
    }

    @RequestMapping(method=RequestMethod.POST)
    public CustomerDTO saveCustomer (CustomerDTO customerDTO){
        Customer customer = (Customer) mapperManager.convert(customerDTO, Customer.class);
        customerService.save(customer);
        return customerDTO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<CustomerDTO> getAllCustomers (){
        List<Customer> customers = customerService.getAll();
        return mapperManager.convert(customers,CustomerDTO.class);
    }

}
