package com.tin.clientsOrganization.mapper.mappers.sale;

import com.tin.clientsOrganization.dtos.SaleDTO;
import com.tin.clientsOrganization.entities.Customer;
import com.tin.clientsOrganization.entities.Quota;
import com.tin.clientsOrganization.entities.Sale;
import com.tin.clientsOrganization.mapper.BaseMapper;
import com.tin.clientsOrganization.mapper.MapperManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class SaleDTOToSale extends BaseMapper <SaleDTO, Sale> {

    @Autowired
    private MapperManager mapperManager;

    @Override
    public Sale getInstance() {
        return new Sale();
    }

    @Override
    public void setSourceClass() {
        this.sourceClass = SaleDTO.class.toString();
    }

    @Override
    public void setTargetClass() {
        this.targetClass = Sale.class.toString();
    }

    @Override
    public Sale convert(SaleDTO saleDTO, Class<Sale> className) {
        Sale saleToReturn = getInstance();
        saleToReturn.setCustomer((Customer) mapperManager.convert(saleDTO.getCustomerDTO(), Customer.class));
        saleToReturn.setDate(saleDTO.getDate());
        saleToReturn.setFees(saleDTO.getFees());
        saleToReturn.setId(saleDTO.getId());
        saleToReturn.setProduct(saleDTO.getProduct());
        saleToReturn.setAmount(saleDTO.getAmount());
        if (saleDTO.getQuotaDTOs()!=null && saleDTO.getQuotaDTOs().size()>0)
            saleToReturn.setQuotas(mapperManager.convert(saleDTO.getQuotaDTOs(), Quota.class));
        return saleToReturn;
    }
}
