package com.tin.clientsOrganization.controllers;

import com.tin.clientsOrganization.dtos.QuotaDTO;
import com.tin.clientsOrganization.dtos.QuotaWSaleIdDTO;
import com.tin.clientsOrganization.entities.Quota;
import com.tin.clientsOrganization.mapper.MapperManager;
import com.tin.clientsOrganization.services.QuotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping(value="/quota" , headers = "Accept=application/json")
public class QuotaController {

    @Autowired
    private MapperManager mapperManager;

    @Autowired
    private QuotaService quotaService;

    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public QuotaDTO updateQuota (@PathVariable Long id, @RequestBody QuotaWSaleIdDTO quotaWSaleIdDTO){
        quotaWSaleIdDTO.setId(id);
        Quota quota = (Quota) mapperManager.convert(quotaWSaleIdDTO , Quota.class);
        quotaService.update(quota);
        return null;
    }

}
