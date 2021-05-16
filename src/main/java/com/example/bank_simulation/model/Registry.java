package com.example.bank_simulation.model;


import javax.persistence.*;
import java.time.LocalDate;



@Entity
public class Registry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private Double transactionValue;

    @Column
    private Boolean credit;

    @Column
    private LocalDate date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private User user;

//    public Registry(Long id, Double value, Boolean signal, LocalDate date, String userDocument) {
//        this.id = id;
//        this.value = value;
//        this.signal = signal;
//        this.date = date;
//        this.userDocument = userDocument;
//    }
//
//    public Registry() {
//    }
//
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTransactionValue() {
        return transactionValue;
    }

    public void setTransactionValue(Double transactionValue) {
        this.transactionValue = transactionValue;
    }

    public Boolean getCredit() {
        return credit;
    }

    public void setCredit(Boolean credit) {
        this.credit = credit;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

//    public String getUserDocument() {
//        return userDocument;
//    }
//
//    public void setUserDocument(String userDocument) {
//        this.userDocument = userDocument;
//    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
