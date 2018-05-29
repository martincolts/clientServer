package com.tin.clientsOrganization.controllers;

import com.tin.clientsOrganization.dtos.SaleDTO;
import com.tin.clientsOrganization.entities.Sale;
import com.tin.clientsOrganization.mapper.MapperManager;
import com.tin.clientsOrganization.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping(value="/sale" , headers = "Accept=application/json")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @Autowired
    private MapperManager mapperManager;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<SaleDTO> get (){
        List<Sale> sales = saleService.findAll();
        return mapperManager.convert(sales, SaleDTO.class);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public @ResponseBody SaleDTO getById(@PathVariable Long id){
        Sale sale = saleService.findById(id);
        return (SaleDTO) mapperManager.convert(sale, SaleDTO.class);
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody SaleDTO saveSale (@RequestBody SaleDTO saleDTO){
        Sale sale = saleService.save ((Sale) mapperManager.convert(saleDTO,Sale.class));
        return (SaleDTO) mapperManager.convert(sale, SaleDTO.class);
    }

    @RequestMapping(value="/ByCustomer/{customerID}", method = RequestMethod.GET)
    public @ResponseBody List<SaleDTO> findByCustomer (@PathVariable Long customerID){
        List<Sale> sales = saleService.findByCustomer(customerID);
        return mapperManager.convert(sales, SaleDTO.class);
    }

    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public @ResponseBody SaleDTO delete (@PathVariable Long id){
        Sale sale = new Sale();
        sale.setId(id);
        saleService.delete(sale);
        return (SaleDTO) mapperManager.convert(sale, SaleDTO.class);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public @ResponseBody SaleDTO update (@RequestBody SaleDTO saleDTO, @PathVariable Long id){
        saleDTO.setId(id);
        Sale sale = (Sale) mapperManager.convert(saleDTO, Sale.class);
        sale = saleService.update(sale);
        return (SaleDTO) mapperManager.convert(sale, SaleDTO.class);
    }
}
