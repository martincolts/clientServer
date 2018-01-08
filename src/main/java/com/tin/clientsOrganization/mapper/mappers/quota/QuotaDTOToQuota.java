package com.tin.clientsOrganization.mapper.mappers.quota;

import com.tin.clientsOrganization.dtos.QuotaDTO;
import com.tin.clientsOrganization.entities.Quota;
import com.tin.clientsOrganization.entities.Sale;
import com.tin.clientsOrganization.mapper.BaseMapper;
import com.tin.clientsOrganization.mapper.MapperManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuotaDTOToQuota extends BaseMapper<QuotaDTO, Quota> {

    @Autowired
    private MapperManager mapperManager;

    @Override
    public Quota getInstance() {
        return new Quota();
    }

    @Override
    public void setSourceClass() {
        this.sourceClass=QuotaDTO.class.toString();
    }

    @Override
    public void setTargetClass() {
        this.targetClass=Quota.class.toString();
    }


    @Override
    public Quota convert(QuotaDTO quotaDTO, Class<Quota> className) {
        Quota quota = this.getInstance();
        quota.setAmount(quotaDTO.getAmount());
        quota.setDueDate(quotaDTO.getDueDate());
        quota.setId(quotaDTO.getId());
        quota.setSale((Sale) mapperManager.convert(quotaDTO.getSaleDTO(),Sale.class));
        return quota;
    }
}
