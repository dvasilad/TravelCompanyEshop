package com.travelcompany.eshop;

import com.travelcompany.eshop.domain.*;
import com.travelcompany.eshop.enumeration.*;
import com.travelcompany.eshop.exception.*;
import com.travelcompany.eshop.reporting.*;
import com.travelcompany.eshop.service.*;

import java.util.ArrayList;
import java.util.List;



public class TravelCompanyEshop {
    public static void main(String[] args) {

        CustomerService customerService = new CustomerService();

        // data initialization
        Customer customer1 = new Customer(1L, "Maria Iordanou", "miordanou@mail.com", "Athens", "Greek", CustomerCategory.INDIVIDUAL);
        Customer customer2 = new Customer(2L, "Ioannis Ioannou", "iioannou@mail.com", "Athens", "Greek", CustomerCategory.BUSINESS);
        Customer customer3 = new Customer(3L, "Dimitris Papadopoulos", "dpapadopoulos@mail.com", "Thessaloniki", "Greek", CustomerCategory.INDIVIDUAL);
        Customer customer4 = new Customer(4L, "Anna Rossi", "anna.rossi@travelcompany.com", "Rome", "Italian", CustomerCategory.BUSINESS);

        System.out.println("\nCustomers:");
        System.out.println(customer1);
        System.out.println(customer2);
        System.out.println(customer3);
        System.out.println(customer4);


        Itinerary itinerary1 = new Itinerary(1, "ATH", "PAR", "10-04-2025", "SkyLines", 300);
        Itinerary itinerary2 = new Itinerary(2, "ATH", "LON", "12-05-2025", "SkyLines", 420);
        Itinerary itinerary3 = new Itinerary(3, "ATH", "AMS", "03-12-2024", "SkyLines", 280);
        Itinerary itinerary4 = new Itinerary(4, "ATH", "PAR", "07-07-2024", "SkyLines", 310);

        System.out.println("\nItineraries:");
        System.out.println(itinerary1);
        System.out.println(itinerary2);
        System.out.println(itinerary3);
        System.out.println(itinerary4);

        Ticket ticket1 = new Ticket(1, customer1, itinerary1, PaymentMethod.CREDIT_CARD, 300.0);
        Ticket ticket2 = new Ticket(2, customer2, itinerary2, PaymentMethod.CASH, 400.0);
        Ticket ticket3 = new Ticket(3, customer1, itinerary3, PaymentMethod.CREDIT_CARD, 680.0);
        Ticket ticket4 = new Ticket(4, customer3, itinerary4, PaymentMethod.CASH, 240.0);

        System.out.println("\nTickets:");
        System.out.println(ticket1);
        System.out.println(ticket2);
        System.out.println(ticket3);
        System.out.println(ticket4);

        // create Payment objects
        Payment paymentCash = new PaymentCash(itinerary1.getBasicPrice(), customer1);
        Payment paymentCreditCard = new PaymentCreditCard(itinerary3.getBasicPrice(), customer2);

        // calculate tickets price
        List<Customer> customers = null;
        List<Itinerary> itineraries = null;
        TicketService ticketService = new TicketService(customers, itineraries);

        double finalPriceCash = ticketService.calculatePrice(customer1, itinerary1, paymentCash);
        System.out.println("\nFinal price with cash: " + finalPriceCash);


        double finalPriceCreditCard = ticketService.calculatePrice(customer2, itinerary1, paymentCreditCard);
        System.out.println("\nFinal price with credit card: " + finalPriceCreditCard);

        // customers / tickets & itineraries  lists
        customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);

        List<Ticket> tickets = new ArrayList<>();
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);

        itineraries = new ArrayList<>();
        itineraries.add(itinerary1);
        itineraries.add(itinerary2);
        itineraries.add(itinerary3);
        itineraries.add(itinerary4);

        // create and generate reporting for total number and cost of tickets for all customers
        CustomerTicketReportlmpl ticketReport = new CustomerTicketReportlmpl(customers, tickets);
        ticketReport.generateReport();

        // create and generate reporting of the total offered itineraries per destination and per departure
        ItineraryReportlmpl itineraryReport = new ItineraryReportlmpl(itineraries);
        itineraryReport.generateReport();

        //create and generate reporting  of the customers who have not purchased any tickets
        CustomersWithoutTicketsReportlmpl report = new CustomersWithoutTicketsReportlmpl(customers, tickets);
        report.generateReport();

        //create and generate reporting  of the customers with the most tickets and with the largest cost of purchases
        TopCustomersReportlmpl topCustomers = new TopCustomersReportlmpl(customers, tickets);
        topCustomers.generateReport();

        // handling email exception
        try {
            customerService.addCustomer(customer1);
            customerService.addCustomer(customer2);
            customerService.addCustomer(customer3);
            customerService.addCustomer(customer4); //  CustomerEmailException

        } catch (CustomerEmailException e) {
            System.err.println("\nError: " + e.getMessage());
        }

        // handling ticketing exception
        try {
            Ticket ticket = ticketService.issueTicket(1, customer1, itinerary1, PaymentMethod.CREDIT_CARD, 300.0);
            System.out.println("\nTicket issued: " + ticket);
        } catch (TicketIssuanceException e) {
            System.err.println("\nError issuing ticket: " + e.getMessage());
        }
    }
}