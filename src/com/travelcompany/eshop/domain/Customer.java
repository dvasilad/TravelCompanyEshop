package com.travelcompany.eshop.domain;

import com.travelcompany.eshop.enumeration.CustomerCategory;

public class Customer {
    private Long id;
    private String name;
    private String email;
    private String address;
    private String nationality;
    private CustomerCategory customerCategory;

    public Customer(Long id, String name, String email, String address, String nationality, CustomerCategory customerCategory) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.nationality = nationality;
        this.customerCategory = customerCategory;

    }

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

    public String getEmail(){
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public CustomerCategory getCustomerCategory() {
        return customerCategory;
    }

    public void setCustomerCategory(CustomerCategory customerCategory) {
        this.customerCategory = customerCategory;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", nationality='" + nationality + '\'' +
                ", customerCategory=" + customerCategory +
                '}';
    }

    public CustomerCategory getCategory() {
        return null;
    }
}