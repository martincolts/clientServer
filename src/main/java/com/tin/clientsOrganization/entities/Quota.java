package com.tin.clientsOrganization.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="quota")
public class Quota {

    private Long id;
    private Date dueDate ;
    private Float amount ;
    private Sale sale;

    @Id
    @GeneratedValue
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

    @ManyToOne
    @JoinColumn(name = "sale_id")
    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }
}
