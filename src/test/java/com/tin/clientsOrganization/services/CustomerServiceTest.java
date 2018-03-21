package com.tin.clientsOrganization.services;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.tin.clientsOrganization.entities.Customer;
import com.tin.clientsOrganization.repositories.CustomerRepository;
import com.tin.clientsOrganization.services.baseServices.BaseCustomerService;

@RunWith(SpringRunner.class)

public class CustomerServiceTest {
	
	@TestConfiguration
	static class CustomerServiceTestConfiguration {
		@Bean
		public CustomerService customerService () {
			return new BaseCustomerService();
		}
	}
	
	@Autowired
	private CustomerService customerService;
	
	@MockBean
	private CustomerRepository customerRepository;
	
	@Before
	public void setUp() {
	    Customer customer = new Customer();
	    customer.setName("Martin");
	 
	List<Customer> customersFound = new ArrayList<>();
	customersFound.add(customer);
	
	Mockito.doReturn (customersFound).when(customerRepository).findByName(customer.getName());
	}
	
	@Test
	public void findPersonById() {
	    String name = "Martin";
	    List<Customer> found = customerService.findByName(name);
	  
	     assertEquals(found.get(0).getName(),name);
	      
	 }

}
