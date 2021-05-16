package com.example.bank_simulation.dto;




import java.util.List;

public class UserDTO {

    private String document;

    private String name;

    private String password;

    private Double balance;

    private List<RegistryDTO> registryDTO;

    private Boolean active;

    public UserDTO(String document, String name, String password) {
        this.document = document;
        this.name = name;
        this.password = password;

    }

    public UserDTO() {
    }

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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<RegistryDTO> getRegistryDTO() {
        return registryDTO;
    }

    public void setRegistryDTO(List<RegistryDTO> registryDTO) {
        this.registryDTO = registryDTO;
    }
}
