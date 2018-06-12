package com.tin.clientsOrganization.entities;

import javax.persistence.*;

@Entity
@Table(name="application_user")
public class ApplicationUser {

    private long id;
    private String username;
    private String password;

    @Id
    @SequenceGenerator(name="userSequence", sequenceName="app_user_sequence")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="userSequence")
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}