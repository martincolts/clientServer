package com.tin.clientsOrganization.mapper.mappers.sale;

import com.tin.clientsOrganization.dtos.CustomerDTO;
import com.tin.clientsOrganization.dtos.QuotaDTO;
import com.tin.clientsOrganization.dtos.SaleDTO;
import com.tin.clientsOrganization.entities.Customer;
import com.tin.clientsOrganization.entities.Sale;
import com.tin.clientsOrganization.mapper.BaseMapper;
import com.tin.clientsOrganization.mapper.MapperManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaleToSaleDTO extends BaseMapper<Sale, SaleDTO> {

    @Autowired
    private MapperManager mapperManager;

    @Override
    public SaleDTO getInstance() {
        return new SaleDTO();
    }

    @Override
    public void setSourceClass() {
        this.sourceClass = Sale.class.toString();
    }

    @Override
    public void setTargetClass() {
        this.targetClass = SaleDTO.class.toString();
    }

    @Override
    public SaleDTO convert(Sale sale, Class<SaleDTO> className) {
        SaleDTO saleDTOtoReturn = getInstance();
        if (sale.getCustomer()!=null)
            saleDTOtoReturn.setCustomerDTO((CustomerDTO) mapperManager.convert(sale.getCustomer(), CustomerDTO.class));
        saleDTOtoReturn.setDate(sale.getDate());
        saleDTOtoReturn.setFees(sale.getFees());
        saleDTOtoReturn.setId(sale.getId());
        saleDTOtoReturn.setProduct(sale.getProduct());
        saleDTOtoReturn.setAmount(sale.getAmount());
        if (sale.getQuotas()!=null && sale.getQuotas().size()>0)
            saleDTOtoReturn.setQuotaDTOs(mapperManager.convert(sale.getQuotas(), QuotaDTO.class));
        return saleDTOtoReturn;
    }
}
