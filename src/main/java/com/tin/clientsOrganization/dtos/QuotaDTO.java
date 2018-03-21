package com.tin.clientsOrganization.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class QuotaDTO {

    private Long id;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date dueDate ;
    private Float amount ;

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
