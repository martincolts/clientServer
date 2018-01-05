package com.tin.clientsOrganization.services.baseServices;

import com.tin.clientsOrganization.entities.Quota;
import com.tin.clientsOrganization.repositories.QuotaRepository;
import com.tin.clientsOrganization.services.QuotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseQuotaService implements QuotaService {

    @Autowired
    private QuotaRepository quotaRepository;

    @Override
    public Quota save(Quota quota) {
        return quotaRepository.save(quota);
    }
}
