package com.tin.clientsOrganization.services;

import com.tin.clientsOrganization.entities.Sale;

import java.util.List;

public interface SaleService {

    Sale findById (Long id);
    Sale save (Sale sale);
    Sale delete (Sale sale);
    Sale update (Sale sale);
    List<Sale> findAll ();
    List<Sale> findByCustomer(Long id);
}
