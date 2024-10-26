package com.travelcompany.eshop;

import com.travelcompany.eshop.domain.*;
import com.travelcompany.eshop.enumeration.CustomerCategory;
import com.travelcompany.eshop.service.*;
import com.travelcompany.eshop.exception.CustomerEmailException;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TravelCompanyEshop {
    public static void main(String[] args) throws CustomerEmailException {
        // data initialization
        Customer customer1 = new Customer(1L, "Maria Iordanou", "miordanou@mail.com", "Athens", "Greek", CustomerCategory.INDIVIDUAL);
        Customer customer2 = new Customer(2L, "Ioannis Ioannou", "iioannou@mail.com", "Athens", "Greek", CustomerCategory.BUSINESS);
        Customer customer3 = new Customer(3L, "Dimitris Papadopoulos", "dpapadopoulos@mail.com", "Thessaloniki", "Greek", CustomerCategory.INDIVIDUAL);
        Customer customer4 = new Customer(4L, "Anna Rossi", "anna.rossi@travelcompany.com", "Rome", "Italian", CustomerCategory.BUSINESS);

        System.out.println(customer1);
        System.out.println(customer2);
        System.out.println(customer3);
        System.out.println(customer4);


        Itinerary itinerary1 = new Itinerary(1, "ATH", "PAR", "10-04-2025", "SkyLines", 300);
        Itinerary itinerary2 = new Itinerary(2, "ATH", "LON", "12-05-2025", "SkyLines", 420);
        Itinerary itinerary3 = new Itinerary(3, "ATΗ", "AMS", "03-12-2024", "SkyLines", 280);
        Itinerary itinerary4 = new Itinerary(4, "ATH", "PAR","07-07-2024", "SkyLines", 310);

        System.out.println(itinerary1);
        System.out.println(itinerary2);
        System.out.println(itinerary3);
        System.out.println(itinerary4);

        // create Payment objects
        Payment paymentCash = new PaymentCash(itinerary1.getBasicPrice(), customer1);
        Payment paymentCreditCard = new PaymentCreditCard(itinerary3.getBasicPrice(), customer2);

        // calculate tickets price
        TicketService ticketService = new TicketService();

        double finalPriceCash = ticketService.calculatePrice(customer1, itinerary1, paymentCash);
        System.out.println("Final price with cash: " + finalPriceCash);

        double finalPriceCreditCard = ticketService.calculatePrice(customer2, itinerary1, paymentCreditCard);
        System.out.println("Final price with credit card: " + finalPriceCreditCard);

        // sample data creation
        List<Customer> customers = new ArrayList<>();
        List<Itinerary> itineraries = new ArrayList<>();
        List<Ticket> tickets = new ArrayList<>();



        //email exception
        for (Customer customer : customers) {
            if (customer.getEmail().endsWith("@travelcompany.com")) {
                throw new CustomerEmailException("Invalid email for customer: " + customer.getName());
            }
        }
    }
}