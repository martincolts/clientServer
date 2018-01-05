package com.tin.clientsOrganization.services.baseServices;

import com.tin.clientsOrganization.entities.Customer;
import com.tin.clientsOrganization.entities.Sale;
import com.tin.clientsOrganization.repositories.CustomerRepository;
import com.tin.clientsOrganization.repositories.SaleRepository;
import com.tin.clientsOrganization.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseSaleService implements SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Sale findById(Long id) {
        return saleRepository.findById(id);
    }

    @Override
    public Sale save(Sale sale) {
        Customer customer = customerRepository.findById(sale.getCustomer().getId()).get();
        sale.setCustomer(customer);
        return saleRepository.save(sale);
    }

    @Override
    public Sale delete(Sale sale) {
        try {
            saleRepository.delete(sale);
            return sale;
        } catch (Exception e){
            throw new RuntimeException("sale not found.");
        }
    }

    @Override
    public Sale update(Sale sale) {
        return null;
    }

    @Override
    public List<Sale> findAll() {
        return saleRepository.findAll();
    }

    @Override
    public List<Sale> findByCustomer(Long id) {
        Customer customer = customerRepository.findById(id).get();
        return saleRepository.findByCustomer(customer);
    }
}
