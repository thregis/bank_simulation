package com.example.bank_simulation.model;



import javax.persistence.*;
import java.util.List;


@Entity
public class User {

    @Id
    @Column
    private String document;

    @Column
    private String name;

    @Column
    private String password;

    @Column
    private Double balance;

    @OneToMany
    @JoinColumn
    @Transient
    private List<Registry> registry;

    @Column
    private Boolean active;

//    public User(String document, String name, String password, Double balance, List<Long> registryIds, Boolean active) {
//        this.document = document;
//        this.name = name;
//        this.password = password;
//        this.balance = balance;
//        this.registryIds = registryIds;
//        this.active = active;
//    }
//
//    public User() {
//    }
//
    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

//    public List<Long> getRegistryIds() {
//        return registryIds;
//    }
//
//    public void setRegistry(List<Long> registrIds) {
//        this.registryIds = registryIds;
//    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<Registry> getRegistry() {
        return registry;
    }

    public void setRegistry(List<Registry> registry) {
        this.registry = registry;
    }
}
