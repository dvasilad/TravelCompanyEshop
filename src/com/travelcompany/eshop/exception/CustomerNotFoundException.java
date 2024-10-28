package com.travelcompany.eshop.exception;

import com.travelcompany.eshop.domain.Customer;
import com.travelcompany.eshop.service.CustomerService;

public class CustomerNotFoundException extends TravelCompanyException {
    public CustomerNotFoundException(String message) {
        super(message);
    }

}
