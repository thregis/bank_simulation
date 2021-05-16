package com.example.bank_simulation.dto;

import com.example.bank_simulation.model.User;

import java.time.LocalDate;


public class RegistryDTO {

    private Long id;

    private Double transactionValue;

    private Boolean credit;

    private LocalDate date;

    private String userDocument;

//    public RegistryDTO(Long id, Double value, Boolean signal, LocalDate date, User user) {
//        this.id = id;
//        this.value = value;
//        this.signal = signal;
//        this.date = date;
//        this.user = user;
//    }
//
//    public RegistryDTO() {
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

    public void setTransactionValue(Double transactionValue) { this.transactionValue = transactionValue; }

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

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public String getUserDocument() {
        return userDocument;
    }

    public void setUserDocument(String userDocument) {
        this.userDocument = userDocument;
    }
}
