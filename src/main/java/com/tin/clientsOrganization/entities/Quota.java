package com.tin.clientsOrganization.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="quota")
public class Quota {

    private Long id;
    private Date date ;
    private Float amount ;
    private Sale sale;

    @Id
    @SequenceGenerator(name="quotaSequence", sequenceName="quota_sequence")
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="quotaSequence")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="due_date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
