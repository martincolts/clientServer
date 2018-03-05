package com.tin.clientsOrganization.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.tin.clientsOrganization.entities.Customer;
import com.tin.clientsOrganization.mapper.BaseMapper;
import com.tin.clientsOrganization.mapper.MapperManager;
import com.tin.clientsOrganization.mapper.mappers.customer.CustomerDTOToCustomer;
import com.tin.clientsOrganization.mapper.mappers.customer.CustomerToCustomerDTO;
import com.tin.clientsOrganization.services.CustomerService;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {
	
	/*@TestConfiguration
	static class CustomerControllerTestConfig {
		
		@Bean
		public MapperManager mapperManager(){
			return new MapperManager<>();
		}
		
		@Bean
		public List<BaseMapper> mappers (){
			List<BaseMapper> mappers = new ArrayList<>();
			mappers.add(new CustomerDTOToCustomer());
			mappers.add(new CustomerToCustomerDTO());
			return mappers;
		}
		
	}*/
	
	@Autowired
    private MockMvc mvc;

	@MockBean
	private MapperManager mapperManager ;
 
    @MockBean
    private CustomerService customerService;
    
    @Test
    public void returnPersonById()
      throws Exception {
         
        Customer customer = new Customer();
     
        List<Customer> customers = Arrays.asList(customer);
     
        when(customerService.findByName(customer.getName())).thenReturn(customers);
     
        mvc.perform(get("/customer")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk());
    }

}
