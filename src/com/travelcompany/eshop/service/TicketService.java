package com.travelcompany.eshop.service;

import com.travelcompany.eshop.domain.*;
import com.travelcompany.eshop.enumeration.CustomerCategory;

public class TicketService {

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
}
