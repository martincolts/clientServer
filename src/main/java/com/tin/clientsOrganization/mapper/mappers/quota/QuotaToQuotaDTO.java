package com.tin.clientsOrganization.mapper.mappers.quota;

import com.tin.clientsOrganization.dtos.QuotaDTO;
import com.tin.clientsOrganization.dtos.SaleDTO;
import com.tin.clientsOrganization.entities.Quota;
import com.tin.clientsOrganization.mapper.BaseMapper;
import com.tin.clientsOrganization.mapper.MapperManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuotaToQuotaDTO extends BaseMapper<Quota, QuotaDTO> {

    @Autowired
    private MapperManager mapperManager;

    @Override
    public QuotaDTO getInstance() {
        return new QuotaDTO();
    }

    @Override
    public void setSourceClass() {
        this.sourceClass=Quota.class.toString();
    }

    @Override
    public void setTargetClass() {
        this.targetClass=QuotaDTO.class.toString();
    }

    @Override
    public QuotaDTO convert(Quota quota, Class<QuotaDTO> className) {
        QuotaDTO quotaDTO = this.getInstance();
        quotaDTO.setAmount(quota.getAmount());
        quotaDTO.setDueDate(quota.getDueDate());
        quotaDTO.setId(quota.getId());
        //quotaDTO.setSaleDTO((SaleDTO) mapperManager.convert(quota.getSale(),SaleDTO.class));
        return quotaDTO;
    }
}
