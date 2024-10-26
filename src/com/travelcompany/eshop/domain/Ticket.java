package com.travelcompany.eshop.domain;

import com.travelcompany.eshop.enumeration.PaymentMethod;

public class Ticket {
    private int id;
    private Customer customer;
    private Itinerary itinerary;
    private PaymentMethod paymentMethod;
    private double paymentAmount;

    public Ticket(int id, Customer customer, Itinerary itinerary, PaymentMethod paymentMethod, double paymentAmount) {
        this.id = id;
        this.customer = customer;
        this.itinerary = itinerary;
        this.paymentMethod = paymentMethod;
        this.paymentAmount = paymentAmount;
    }

    public Ticket(Long id, Customer customer, Itinerary itinerary) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Itinerary getItinerary() {
        return itinerary;
    }

    public void setItinerary(Itinerary itinerary) {
        this.itinerary = itinerary;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
}

