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

        ItineraryService itineraryService = new ItineraryService();

        // data initialization
        Customer customer1 = new Customer(1L, "Maria Iordanou", "miordanou@mail.com", "Athens", "Greek", CustomerCategory.INDIVIDUAL);
        Customer customer2 = new Customer(2L, "Ioannis Ioannou", "iioannou@mail.com", "Athens", "Greek", CustomerCategory.BUSINESS);
        Customer customer3 = new Customer(3L, "Dimitris Papadopoulos", "dpapadopoulos@mail.com", "Thessaloniki", "Greek", CustomerCategory.INDIVIDUAL);
        Customer customer4 = new Customer(4L, "Anna Rossi", "anna.rossi@travelcompany.com", "Rome", "Italian", CustomerCategory.BUSINESS);
        Customer customer5 = new Customer(5L, "Frederico Rossi", "frossi@mail.com", "Milan", "Italian", CustomerCategory.INDIVIDUAL);
        Customer customer6 = new Customer(6L, "Mario Conti", "mconti@mail.com", "Rome", "Italian", CustomerCategory.BUSINESS);
        Customer customer7 = new Customer(7L, "Nathan Martin", "nmartin@mail.com", "Lyon", "French", CustomerCategory.BUSINESS);
        Customer customer8 = new Customer(8L, "Enzo Collin", "ecollin@mail.com", "Lyon", "French", CustomerCategory.INDIVIDUAL);

        System.out.println("\nCustomers:");
        System.out.println(customer1);
        System.out.println(customer2);
        System.out.println(customer3);
        System.out.println(customer4);
        System.out.println(customer5);
        System.out.println(customer6);
        System.out.println(customer7);
        System.out.println(customer8);


        Itinerary itinerary1 = new Itinerary(1, "ATH", "PAR", "10-04-2025", "SkyLines", 300);
        Itinerary itinerary2 = new Itinerary(2, "ATH", "LON", "12-05-2025", "SkyLines", 420);
        Itinerary itinerary3 = new Itinerary(3, "ATH", "AMS", "03-12-2024", "SkyLines", 280);
        Itinerary itinerary4 = new Itinerary(4, "ATH", "PAR", "07-07-2024", "SkyLines", 310);
        Itinerary itinerary5 = new Itinerary(5, "ATH", "FRA", "22-02-2022", "SkyLines", 350);
        Itinerary itinerary6 = new Itinerary(6, "ATH", "MEX", "22-02-2022", "SkyLines", 1020);
        Itinerary itinerary7 = new Itinerary(7, "ATH", "DUB", "22-02-2022", "SkyLines", 770);

        System.out.println("\nItineraries:");
        System.out.println(itinerary1);
        System.out.println(itinerary2);
        System.out.println(itinerary3);
        System.out.println(itinerary4);
        System.out.println(itinerary5);
        System.out.println(itinerary6);
        System.out.println(itinerary7);

        Ticket ticket1 = new Ticket(1, customer1, itinerary1, PaymentMethod.CREDIT_CARD, 300.0);
        Ticket ticket2 = new Ticket(2, customer2, itinerary2, PaymentMethod.CASH, 400.0);
        Ticket ticket3 = new Ticket(3, customer1, itinerary3, PaymentMethod.CREDIT_CARD, 680.0);
        Ticket ticket4 = new Ticket(4, customer3, itinerary4, PaymentMethod.CASH, 240.0);
        Ticket ticket5 = new Ticket(5, customer4, itinerary5, PaymentMethod.CREDIT_CARD, 350.0);
        Ticket ticket6 = new Ticket(6, customer5, itinerary6, PaymentMethod.CREDIT_CARD, 1020.0);
        Ticket ticket7 = new Ticket(7, customer6, itinerary7, PaymentMethod.CASH, 770.0);
        Ticket ticket8 = new Ticket(8, customer7, itinerary1, PaymentMethod.CREDIT_CARD, 300.0);

        System.out.println("\nTickets:");
        System.out.println(ticket1);
        System.out.println(ticket2);
        System.out.println(ticket3);
        System.out.println(ticket4);
        System.out.println(ticket5);
        System.out.println(ticket6);
        System.out.println(ticket7);
        System.out.println(ticket8);


        // calculate tickets price
        List<Customer> customers = null;
        List<Itinerary> itineraries = null;
        TicketService ticketService = new TicketService(customers, itineraries);

        // create Payment objects
        Payment paymentCash = new PaymentCash(itinerary1.getBasicPrice(), customer1);
        Payment paymentCreditCard = new PaymentCreditCard(itinerary3.getBasicPrice(), customer2);

        System.out.println("\nTicket cost per payment method ");

        double finalPriceCash = ticketService.calculatePrice(customer1, itinerary1, paymentCash);
        System.out.println("Final price with cash: " + finalPriceCash);

        double finalPriceCreditCard = ticketService.calculatePrice(customer2, itinerary1, paymentCreditCard);
        System.out.println("Final price with credit card: " + finalPriceCreditCard);

        // customers / tickets & itineraries  lists
        customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);
        customers.add(customer6);
        customers.add(customer7);
        customers.add(customer8);

        List<Ticket> tickets = new ArrayList<>();
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        tickets.add(ticket6);
        tickets.add(ticket7);
        tickets.add(ticket8);

        itineraries = new ArrayList<>();
        itineraries.add(itinerary1);
        itineraries.add(itinerary2);
        itineraries.add(itinerary3);
        itineraries.add(itinerary4);
        itineraries.add(itinerary5);
        itineraries.add(itinerary6);
        itineraries.add(itinerary7);



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
            customerService.addCustomer(customer5);
            customerService.addCustomer(customer6);
            customerService.addCustomer(customer7);
            customerService.addCustomer(customer8);


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


        //handling airport code exception
        try {
            Itinerary itinerary = itineraryService.createItinerary(8, "ATH", "XYZ", "10-04-2025", "SkyLines", 300);
            System.out.println("\nItinerary created: " + itinerary);
        } catch (InvalidAirportCodeException e) {
            System.err.println("\nError creating itinerary: " + e.getMessage());
        }
    }
}