package com.tin.clientsOrganization.entities;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="customer")
public class Customer implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "customerGen")
    @SequenceGenerator(name = "customerGen",
            sequenceName = "customer_sequence")
    private Long id ;
    private String name ;
    private String lastname ;
    private String phoneNumber ;
    private String dni ;
    private String address;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
