package com.tin.clientsOrganization.repositories;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

import com.tin.clientsOrganization.entities.Customer;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTest {
	
	@Autowired
	private CustomerRepository customerRepository ;
	
	@Autowired
	private TestEntityManager entityManager ;
	
	@Test
	public void findPersonById () {
		Customer customer = new Customer();
		customer.setName("Martin");
		
		entityManager.persist(customer);
		entityManager.flush();
		
		List<Customer> customersFounds = customerRepository.findByName("Martin");
		
		assertEquals(customersFounds.get(0).getName(), customer.getName());
	}

}
	