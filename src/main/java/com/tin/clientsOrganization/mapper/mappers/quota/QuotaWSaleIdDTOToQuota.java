package com.tin.clientsOrganization.mapper.mappers.quota;

import com.tin.clientsOrganization.dtos.QuotaWSaleIdDTO;
import com.tin.clientsOrganization.entities.Quota;
import com.tin.clientsOrganization.entities.Sale;
import com.tin.clientsOrganization.mapper.BaseMapper;
import org.springframework.stereotype.Component;

@Component
public class QuotaWSaleIdDTOToQuota extends BaseMapper<QuotaWSaleIdDTO, Quota> {
    @Override
    public Quota getInstance() {
        return new Quota();
    }

    @Override
    public void setSourceClass() {
        this.sourceClass = QuotaWSaleIdDTO.class.toString();
    }

    @Override
    public void setTargetClass() {
        this.targetClass = Quota.class.toString();
    }

    @Override
    public Quota convert(QuotaWSaleIdDTO quotaWSaleIdDTO, Class<Quota> className) {
        Quota quota = this.getInstance();
        Sale sale = new Sale();
        sale.setId(quotaWSaleIdDTO.getSaleId());
        quota.setSale(sale);
        quota.setAmount(quotaWSaleIdDTO.getAmount());
        quota.setDueDate(quotaWSaleIdDTO.getDueDate());
        quota.setId(quotaWSaleIdDTO.getId());
        return quota;
    }
}
