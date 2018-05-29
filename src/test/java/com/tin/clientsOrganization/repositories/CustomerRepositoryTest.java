package com.tin.clientsOrganization.repositories;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

import com.tin.clientsOrganization.entities.Customer;

@Transactional
@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class CustomerRepositoryTest {
	
	@Autowired
	private CustomerRepository customerRepository ;
	
	@Autowired
	private TestEntityManager entityManager ;

	@Test
	public void contextLoad(){}

	@Test
	public void findPersonById () {
		Customer customer = new Customer();
		customer.setName("Martin");
		customer.setLastname("Lopez");
		customer.setDni("34421478");
		customer.setPhoneNumber("22265454");
		
		entityManager.persist(customer);
		entityManager.flush();
		
		List<Customer> customersFounds = customerRepository.findByName("Martin");
		
		assertEquals(customersFounds.get(0).getName(), customer.getName());
	}

}
	