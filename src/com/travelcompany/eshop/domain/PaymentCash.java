package com.travelcompany.eshop.domain;

public class PaymentCash extends Payment {

    public PaymentCash(double amount, Customer customer) {
        super(amount, customer);
    }

    @Override
    public double calculateFinalAmount() {
        // no discount
        return amount;
    }
}


