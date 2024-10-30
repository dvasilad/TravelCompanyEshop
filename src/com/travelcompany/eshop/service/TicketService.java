package com.travelcompany.eshop.service;

import com.travelcompany.eshop.domain.*;
import com.travelcompany.eshop.enumeration.CustomerCategory;
import com.travelcompany.eshop.enumeration.PaymentMethod;
import com.travelcompany.eshop.exception.TicketIssuanceException;

import java.util.ArrayList;
import java.util.List;


public class TicketService {

    private List<Customer> customers;
    private List<Itinerary> itineraries;

    public TicketService(List<Customer> customers, List<Itinerary> itineraries) {
        this.customers = customers != null ? customers : new ArrayList<>();
        this.itineraries = itineraries != null ? itineraries : new ArrayList<>();
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public void setItineraries(List<Itinerary> itineraries) {
        this.itineraries = itineraries;
    }


    public double calculatePrice(Customer customer, Itinerary itinerary, Payment payment) {
        double finalPrice = itinerary.getBasicPrice();

        // discount for Business customers

        if (customer.getCategory() == CustomerCategory.BUSINESS) {
            finalPrice *= 0.90;
        }
        // additional for Individual customers
        else if (customer.getCategory() == CustomerCategory.INDIVIDUAL) {
            finalPrice *= 1.20;
        }

        // final amount calculation
        return payment.calculateFinalAmount();
    }

    public Ticket issueTicket(int ticketId, Customer customer, Itinerary itinerary, PaymentMethod paymentMethod, double paymentAmount) throws TicketIssuanceException {
        // customer not found exception
        if (!customers.contains(customer)) {
            throw new TicketIssuanceException("Customer ID does not exist: " + customer.getId());
        }

        // itinerary not found exception
        if (!itineraries.contains(itinerary)) {
            throw new TicketIssuanceException("Itinerary does not exist: " + itinerary.getId());
        }
        return new Ticket(ticketId, customer, itinerary, paymentMethod, paymentAmount);
    }
}
