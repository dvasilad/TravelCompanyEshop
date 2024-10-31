package com.travelcompany.eshop.reporting;

//List of the total number and cost of tickets for all customers

import com.travelcompany.eshop.domain.Customer;
import com.travelcompany.eshop.domain.Ticket;

import java.util.List;

public class CustomerTicketReportlmpl implements Reportable {
    private final List<Customer> customers;
    private final List<Ticket> tickets;

    public CustomerTicketReportlmpl(List<Customer> customers, List<Ticket> tickets) {
        this.customers = customers;
        this.tickets = tickets;
    }

    @Override
    public void generateReport() {
        System.out.println("\nTotal number and cost of tickets for all customers:");
        for (Customer customer : customers) {
            long ticketCount = tickets.stream()
                    .filter(ticket -> ticket.getCustomer().equals(customer))
                    .count();
            double totalCost = tickets.stream()
                    .filter(ticket -> ticket.getCustomer().equals(customer))
                    .mapToDouble(Ticket::getPaymentAmount)
                    .sum();

            System.out.println("Customer: " + customer.getName() +
                    ", Tickets: " + ticketCount +
                    ", Total Cost: " + totalCost);
        }
    }
}
