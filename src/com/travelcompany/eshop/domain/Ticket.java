package com.travelcompany.eshop.domain;

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

}

