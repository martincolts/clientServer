package com.tin.clientsOrganization.mappers;

import com.tin.clientsOrganization.entities.Customer;
import com.tin.clientsOrganization.mapper.BaseMapper;
import com.tin.clientsOrganization.mapper.MapperManager;
import com.tin.clientsOrganization.mapper.mappers.customer.CustomerToCustomerDTO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
	
	@Bean
	public MapperManager mapperManager () {
		return new MapperManager();
	}
	
	@Bean
	public List<BaseMapper> mappers (){
		List<BaseMapper> mappers = new ArrayList<>();
		mappers.add(new CustomerToCustomerDTO());
		return mappers ;
	}

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
