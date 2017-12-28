package com.tin.clientsOrganization.mapper.mappers;

import com.tin.clientsOrganization.dtos.CustomerDTO;
import com.tin.clientsOrganization.entities.Customer;
import com.tin.clientsOrganization.mapper.BaseMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerToCustomerDTO extends BaseMapper<Customer, CustomerDTO> {
    @Override
    public CustomerDTO getInstance() {
        return new CustomerDTO() ;
    }

    @Override
    public void setSourceClass() {
        this.sourceClass = Customer.class.toString();
    }

    @Override
    public void setTargetClass() {
        this.targetClass = CustomerDTO.class.toString();
    }

    @Override
    public CustomerDTO convert(Customer customer, Class<CustomerDTO> className) {
        CustomerDTO customerDTO = this.getInstance();
        customerDTO.setAddress(customer.getAddress());
        customerDTO.setDni(customer.getDni());
        customerDTO.setLastname(customer.getLastname());
        customerDTO.setName(customer.getName());
        customerDTO.setPhoneNumber(customer.getPhoneNumber());
        return customerDTO;
    }
}
