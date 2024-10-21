package com.travelcompany.eshop.domain;

public class PaymentCreditCard extends Payment {

    public PaymentCreditCard(double amount, Customer customer) {
        super(amount, customer);
    }

    @Override
    public double calculateFinalAmount() {
        // discount 10%
        return amount * 0.90;
    }
}
