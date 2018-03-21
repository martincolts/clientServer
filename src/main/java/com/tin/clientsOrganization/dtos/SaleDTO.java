package com.tin.clientsOrganization.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class SaleDTO {

    private CustomerDTO customerDTO ;

    private Long id ;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date date;
    private Integer fees;
    private String product;
    private Float amount;
    private List<QuotaDTO> quotaDTOs;

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getFees() {
        return fees;
    }

    public void setFees(Integer fees) {
        this.fees = fees;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public List<QuotaDTO> getQuotaDTOs() {
        return quotaDTOs;
    }

    public void setQuotaDTOs(List<QuotaDTO> quotaDTOs) {
        this.quotaDTOs = quotaDTOs;
    }
}
