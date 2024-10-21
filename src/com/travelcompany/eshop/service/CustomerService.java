package com.travelcompany.eshop.service;

import com.travelcompany.eshop.domain.Customer;
import java.util.ArrayList;
import java.util.List;


public class CustomerService {
    private List<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }
}







