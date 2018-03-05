package com.tin.clientsOrganization.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tin.clientsOrganization.ClientsOrganizationApplication;
import com.tin.clientsOrganization.entities.Customer;
import com.tin.clientsOrganization.mapper.MapperManager;
import com.tin.clientsOrganization.mappers.MapperConfig;
import com.tin.clientsOrganization.services.CustomerService;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
@ContextConfiguration(classes= {ClientsOrganizationApplication.class, MapperConfig.class})
public class CustomerControllerTest {
	
	@Autowired
    private MockMvc mvc;

	@Autowired
	private MapperManager mapperManager ;
 
	@Autowired
	private Customer customer ;
	
    @MockBean
    private CustomerService customerService;
    
    @Test
    public void returnPersonById()
      throws Exception {
    	//customer.setName("Martin");
        List<Customer> customers = Arrays.asList(customer);
     
        given(customerService.findByName(customer.getName())).willReturn(customers);
        when(customerService.findByName(customer.getName())).thenReturn(customers);
     
        MvcResult result = mvc.perform(get("/customer/byName/Martin")
          .accept(MediaType.APPLICATION_JSON)
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andReturn();
        
        String content = result.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<Customer> customerResponse = objectMapper.readValue(content, new TypeReference<List<Customer>>(){});
        assertEquals(customerResponse.get(0).getName(), customer.getName());
    }

}
