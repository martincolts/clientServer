package com.tin.clientsOrganization.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.tin.clientsOrganization.entities.Customer;

@Entity
@Table(name="sale")
public class Sale {

    private Long id ;
    private Date date;
    private Customer customer;
    private Integer fees;
    private String product;
    private Float amount;
    private List<Quota> quotas ;

    @Id
    @SequenceGenerator(name="saleSequence", sequenceName="sale_sequence")
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="saleSequence")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "sale_date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @ManyToOne
    @JoinColumn(name = "customer_id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sale", fetch = FetchType.EAGER)
    public List<Quota> getQuotas() {
        return quotas;
    }

    public void setQuotas(List<Quota> quotas) {
        this.quotas = quotas;
    }
}
