package com.tin.clientsOrganization.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class QuotaDTO {

    private Long id;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date dueDate ;
    private Float amount ;
    private boolean paidOut;
    
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

	public void setPaidOut(boolean paidOut) {
		this.paidOut = paidOut ;
	}
	
	public boolean getPaidOut () {
		return this.paidOut;
	}
}
