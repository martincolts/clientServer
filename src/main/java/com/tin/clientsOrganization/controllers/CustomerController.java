package com.tin.clientsOrganization.controllers;

import com.tin.clientsOrganization.dtos.CustomerDTO;
import com.tin.clientsOrganization.entities.Customer;
import com.tin.clientsOrganization.entities.Sale;
import com.tin.clientsOrganization.mapper.MapperManager;
import com.tin.clientsOrganization.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer", headers = "Accept=application/json")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private MapperManager mapperManager;

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public @ResponseBody Customer findById(@PathVariable Long id){
        return customerService.findById(id);
    }

    @RequestMapping(method=RequestMethod.POST)
    public @ResponseBody  CustomerDTO saveCustomer (@RequestBody CustomerDTO customerDTO){
        Customer customer = (Customer) mapperManager.convert(customerDTO, Customer.class);
        Customer customerSaved = customerService.save(customer);
        return (CustomerDTO) mapperManager.convert(customerSaved, CustomerDTO.class);
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<CustomerDTO> getAllCustomers (){
        List<Customer> customers = customerService.getAll();
        return mapperManager.convert(customers,CustomerDTO.class);
    }
    
    @RequestMapping(value="/byName/{name}", method = RequestMethod.GET)
    public @ResponseBody List<CustomerDTO> getCustomerByName(@PathVariable String name){
    	List<Customer> customers = customerService.findByName(name);
    	return mapperManager.convert(customers, CustomerDTO.class);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public @ResponseBody ResponseEntity<CustomerDTO> updateCustomer (@RequestBody CustomerDTO customerDTO, @PathVariable Long id){
        if (customerService.findById(id)!=null) {
            Customer customer = (Customer) mapperManager.convert(customerDTO, Customer.class);
            customer.setId(id);
            customer = customerService.update (customer);
            CustomerDTO customerDTOToReturn = (CustomerDTO) mapperManager.convert(customer, CustomerDTO.class);
            return new ResponseEntity<>(customerDTOToReturn,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping (value="/{id}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseEntity<CustomerDTO> deleteCustomer (@PathVariable Long id){
        Customer customer = customerService.findById(id);
        if (customer != null){
            CustomerDTO customerDTO = (CustomerDTO) mapperManager.convert(customer, CustomerDTO.class);
            customerService.delete(id);
            return ResponseEntity.ok(customerDTO);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

}
