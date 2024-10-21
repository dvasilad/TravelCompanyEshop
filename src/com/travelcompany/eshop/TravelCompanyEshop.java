package com.travelcompany.eshop;

import com.travelcompany.eshop.domain.Customer;
import com.travelcompany.eshop.enumeration.Category;
import com.travelcompany.eshop.enumeration.Nationality;

public class TravelCompanyEshop {
    public static void main(String[] args) {
        com.travelcompany.eshop.enumeration.Nationality nationality = com.travelcompany.eshop.enumeration.Nationality.valueOf("italian".toUpperCase());
        System.out.println(nationality);
        Customer businessCustomer = new Customer(1L, "Dora Vasiladioti", "dvasilad@gmail.com", "Stadiou 2", com.travelcompany.eshop.enumeration.Nationality.GREEK, com.travelcompany.eshop.enumeration.Category.BUSINESS);
        System.out.println(businessCustomer);
    }
}
