package com.travelcompany.eshop.reporting;

//List of the customers who have not purchased any tickets

import com.travelcompany.eshop.domain.Customer;
import com.travelcompany.eshop.domain.Ticket;

import java.util.List;
import java.util.stream.Collectors;

public class CustomersWithoutTicketsReportlmpl implements Reportable {
    private List<Customer> customers;
    private List<Ticket> tickets;

    public CustomersWithoutTicketsReportlmpl(List<Customer> customers, List<Ticket> tickets) {
        this.customers = customers;
        this.tickets = tickets;
    }

    @Override
    public void generateReport() {
        System.out.println("\nCustomers who have not purchased any tickets:");

        List<Customer> customersWithTickets = tickets.stream()
                .map(Ticket::getCustomer)
                .distinct()
                .collect(Collectors.toList());

        customers.stream()
                .filter(customer -> !customersWithTickets.contains(customer))
                .forEach(customer -> System.out.println("Customer: " + customer.getName()));
    }
}
