package com.tin.clientsOrganization.repositories;

import com.tin.clientsOrganization.entities.Customer;
import com.tin.clientsOrganization.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    Sale findById(Long id);
    List<Sale> findByCustomer (Customer customer);
}
