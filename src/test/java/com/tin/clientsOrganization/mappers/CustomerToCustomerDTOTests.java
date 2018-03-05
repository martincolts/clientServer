package com.tin.clientsOrganization.mappers;

import com.tin.clientsOrganization.dtos.CustomerDTO;
import com.tin.clientsOrganization.entities.Customer;
import com.tin.clientsOrganization.mapper.BaseMapper;
import com.tin.clientsOrganization.mapper.MapperManager;
import com.tin.clientsOrganization.mapper.mappers.customer.CustomerToCustomerDTO;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(classes=MapperConfig.class)
public class CustomerToCustomerDTOTests {
	
	@Autowired
    private MapperManager mapperManager ;

    @Autowired
    private Customer customer ;

    /*@Before
    public void LoadMappers(){
        mapperManager.setMapper(new CustomerToCustomerDTO());
    }*/

    @Test
    public void CustomerToCustomerDTOTest (){
        CustomerDTO customerDTO = (CustomerDTO) mapperManager.convert(customer, CustomerDTO.class);
        Assert.assertEquals(customerDTO.getAddress(), customer.getAddress());
    }
}
