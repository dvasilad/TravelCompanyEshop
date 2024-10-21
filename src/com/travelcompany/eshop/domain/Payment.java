package com.travelcompany.eshop.domain;

public abstract class Payment {
    protected double amount;
    protected Customer customer;

    public Payment(double amount, Customer customer) {
        this.amount = amount;
        this.customer = customer;
    }

    public abstract double calculateFinalAmount();

    public double getAmount() {
        return amount;
    }

    public Customer getCustomer() {
        return customer;
    }
}
