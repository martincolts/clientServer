package com.tin.clientsOrganization.mappers;

import com.tin.clientsOrganization.entities.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public Customer getCustomer (){
        Customer customer = new Customer();
        customer.setId(new Long (1));
        customer.setAddress("578 2136");
        customer.setDni("34421478");
        customer.setLastname("Lopez");
        customer.setPhoneNumber("2494209692");
        customer.setName("Martin");
        return customer;
    }
}
