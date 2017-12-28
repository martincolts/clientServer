package com.tin.clientsOrganization.mapper.mappers;

import com.tin.clientsOrganization.dtos.CustomerDTO;
import com.tin.clientsOrganization.entities.Customer;
import com.tin.clientsOrganization.mapper.BaseMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerDTOToCustomer extends BaseMapper<CustomerDTO, Customer> {

    @Override
    public Customer convert(CustomerDTO customerDTO, Class<Customer> className) {
        Customer customer = this.getInstance();
        customer.setAddress(customerDTO.getAddress());
        customer.setDni(customerDTO.getDni());
        customer.setLastname(customerDTO.getLastname());
        customer.setName(customerDTO.getName());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        return customer;
    }

    @Override
    public Customer getInstance() {
        return new Customer();
    }

    @Override
    public void setSourceClass() {
        this.sourceClass = CustomerDTO.class.toString();
    }

    @Override
    public void setTargetClass() {
        this.targetClass = Customer.class.toString();
    }
}
