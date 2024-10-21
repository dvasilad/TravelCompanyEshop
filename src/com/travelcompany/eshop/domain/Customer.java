package com.travelcompany.eshop.domain;

import com.travelcompany.eshop.enumeration.CustomerCategory;
import com.travelcompany.eshop.enumeration.Nationality;

public class Customer {
    private Long id;
    private String name;
    private String email;
    private String address;
    private Nationality nationality;
    private CustomerCategory customerCategory;


    public Customer(Long id, String name, String email, String address, Nationality nationality, CustomerCategory customerCategory) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.nationality = nationality;
        this.customerCategory = customerCategory;
    }

    public Customer(int i, String maria_iordanou, String email, String athens, String greek, CustomerCategory individual) {

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

    public String getEmail() {
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

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public CustomerCategory getCategory() {
        return customerCategory;
    }

    public void setCategory(CustomerCategory customerCategory) {
        this.customerCategory = customerCategory;
    }
}
