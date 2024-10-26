package com.travelcompany.eshop.reporting;

//List of the customers with the most tickets and with the largest cost of purchases

import com.travelcompany.eshop.domain.Customer;
import com.travelcompany.eshop.domain.Ticket;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopCustomersReportlmpl implements Reportable {
    private List<Customer> customers;
    private List<Ticket> tickets;

    public TopCustomersReportlmpl(List<Customer> customers, List<Ticket> tickets) {
        this.customers = customers;
        this.tickets = tickets;
    }

    @Override
    public void generateReport() {
        System.out.println("Customers with the most tickets:");

        // Group tickets by customer and sort by ticket count
        Map<Customer, Long> customerTicketCount = tickets.stream()
                .collect(Collectors.groupingBy(Ticket::getCustomer, Collectors.counting()));

        customerTicketCount.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(1)
                .forEach(entry -> System.out.println("Customer: " + entry.getKey().getName() +
                        ", Tickets: " + entry.getValue()));

        System.out.println("\nCustomers with the largest cost of purchases:");

        // Group tickets by customer and sum the payment amount
        Map<Customer, Double> customerTotalCost = tickets.stream()
                .collect(Collectors.groupingBy(Ticket::getCustomer, Collectors.summingDouble(Ticket::getPaymentAmount)));

        customerTotalCost.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(1)
                .forEach(entry -> System.out.println("Customer: " + entry.getKey().getName() +
                        ", Total Cost: " + entry.getValue()));
    }
}
