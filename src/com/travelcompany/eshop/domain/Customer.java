package com.travelcompany.eshop.domain;

import com.travelcompany.eshop.enumeration.Category;
import com.travelcompany.eshop.enumeration.Nationality;

public class Customer {
    private Long id;
    private String name;
    private String email;
    private String address;
    private Nationality nationality;
    private Category category;

    public Customer(Long id, String name, String email, String address, Nationality nationality, Category category) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.nationality = nationality;
        this.category = category;
    }
}
