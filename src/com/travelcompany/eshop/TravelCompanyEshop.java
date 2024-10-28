package com.travelcompany.eshop;

import com.travelcompany.eshop.domain.*;
import com.travelcompany.eshop.enumeration.*;
import com.travelcompany.eshop.service.*;
import com.travelcompany.eshop.exception.*;
import com.travelcompany.eshop.reporting.*;

import java.util.ArrayList;
import java.util.List;

public class TravelCompanyEshop {
    public static void main(String[] args) {
        try {
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
            Itinerary itinerary4 = new Itinerary(4, "ATH", "PAR", "07-07-2024", "SkyLines", 310);

            System.out.println(itinerary1);
            System.out.println(itinerary2);
            System.out.println(itinerary3);
            System.out.println(itinerary4);

            Ticket ticket1 = new Ticket(1, customer1, itinerary1, PaymentMethod.CREDIT_CARD, 300.0);
            Ticket ticket2 = new Ticket(2, customer2, itinerary2, PaymentMethod.CASH, 400.0);
            Ticket ticket3 = new Ticket(3, customer1, itinerary3, PaymentMethod.CREDIT_CARD, 680.0);
            Ticket ticket4 = new Ticket(4, customer3, itinerary4, PaymentMethod.CASH, 240.0);

            System.out.println(ticket1);
            System.out.println(ticket2);
            System.out.println(ticket3);
            System.out.println(ticket4);

            // create Payment objects
            Payment paymentCash = new PaymentCash(itinerary1.getBasicPrice(), customer1);
            Payment paymentCreditCard = new PaymentCreditCard(itinerary3.getBasicPrice(), customer2);

            // calculate tickets price
            TicketService ticketService = new TicketService();

            double finalPriceCash = ticketService.calculatePrice(customer1, itinerary1, paymentCash);
            System.out.println("Final price with cash: " + finalPriceCash);


            double finalPriceCreditCard = ticketService.calculatePrice(customer2, itinerary1, paymentCreditCard);
            System.out.println("Final price with credit card: " + finalPriceCreditCard);

            // customers & ticket list
            List<Customer> customers = new ArrayList<>();
            customers.add(customer1);
            customers.add(customer2);
            customers.add(customer3);

            List<Ticket> tickets = new ArrayList<>();
            tickets.add(ticket1);
            tickets.add(ticket2);
            tickets.add(ticket3);
            tickets.add(ticket4);

            // create and generate reporting for total number and cost of tickets for all customers
            CustomerTicketReportlmpl report = new CustomerTicketReportlmpl(customers, tickets);
            report.generateReport();


            //email exception
            for (Customer customer : new Customer[]{customer1, customer2, customer3, customer4}) {
                if (customer.getEmail().endsWith("@travelcompany.com")) {
                    throw new CustomerEmailException("Invalid email for customer: " + customer.getEmail());
                }
            }

        } catch (CustomerEmailException e) {
            System.err.println("Error: " + e.getMessage());
        }

    }
}



