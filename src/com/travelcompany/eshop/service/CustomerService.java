package com.travelcompany.eshop.service;

import com.travelcompany.eshop.domain.Customer;
import com.travelcompany.eshop.enumeration.CustomerCategory;
import com.travelcompany.eshop.exception.CustomerEmailException;


import java.util.ArrayList;
import java.util.List;


public class CustomerService {
    private List<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer) throws CustomerEmailException {
        if (customer.getEmail().endsWith("@travelcompany.com")) {
            throw new CustomerEmailException("Invalid email for customer: " + customer.getEmail());
        }

        customers.add(customer);
    }


    public List<Customer> getAllCustomers() {
        return customers;
    }

    public Customer findCustomerById(int customerId) {
        return null;
    }
}


