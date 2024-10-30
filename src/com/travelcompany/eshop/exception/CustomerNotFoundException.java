package com.travelcompany.eshop.exception;

import com.travelcompany.eshop.domain.Customer;

import java.util.List;

public class CustomerNotFoundException extends Exception {
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
