package com.tin.clientsOrganization.dtos;

import com.tin.clientsOrganization.entities.Sale;

import java.util.Date;

public class QuotaDTO {

    private SaleDTO saleDTO;

    private Long id;
    private Date dueDate ;
    private Float amount ;

    public SaleDTO getSaleDTO() {
        return saleDTO;
    }

    public void setSaleDTO(SaleDTO saleDTO) {
        this.saleDTO = saleDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
}
