package com.travelcompany.eshop.reporting;

import com.travelcompany.eshop.domain.Customer;
import com.travelcompany.eshop.domain.Ticket;
import com.travelcompany.eshop.domain.Itinerary;

import java.util.*;
import java.util.stream.Collectors;

public class ReportService {

    private List<Ticket> tickets;
    private List<Customer> customers;
    private List<Itinerary> itineraries;

    public ReportService(List<Ticket> tickets, List<Customer> customers, List<Itinerary> itineraries) {
        this.tickets = tickets;
        this.customers = customers;
        this.itineraries = itineraries;
    }

    // 1. List of the total number and list of the cost of tickets for all customers
    public void reportTotalTicketsAndCostPerCustomer() {
        System.out.println("=== Total Tickets and Cost Per Customer ===");
        for (Customer customer : customers) {
            List<Ticket> customerTickets = tickets.stream()
                    .filter(ticket -> ticket.getCustomer().equals(customer))
                    .collect(Collectors.toList());

            double totalCost = customerTickets.stream()
                    .mapToDouble(Ticket::getPaymentAmount)
                    .sum();

            System.out.println("Customer: " + customer.getName() + " | Tickets: " + customerTickets.size() + " | Total Cost: " + totalCost);
        }
    }

    // 2. List of the total offered itineraries per destination and offered itineraries per departure
    public void reportItinerariesPerDestinationAndDeparture() {
        System.out.println("=== Total Offered Itineraries Per Destination ===");
        Map<String, Long> destinationCount = itineraries.stream()
                .collect(Collectors.groupingBy(Itinerary::getDestinationAirportCode, Collectors.counting()));

        destinationCount.forEach((destination, count) ->
                System.out.println("Destination: " + destination + " | Itineraries: " + count)
        );

        System.out.println("\n=== Total Offered Itineraries Per Departure ===");
        Map<String, Long> departureCount = itineraries.stream()
                .collect(Collectors.groupingBy(Itinerary::getDepartureAirportCode, Collectors.counting()));

        departureCount.forEach((departure, count) ->
                System.out.println("Departure: " + departure + " | Itineraries: " + count)
        );
    }

    // 3. List of the customers with the most tickets and with the largest cost of purchases
    public void reportCustomersWithMostTicketsAndLargestCost() {
        System.out.println("=== Customer with Most Tickets ===");
        Optional<Customer> customerWithMostTickets = customers.stream()
                .max(Comparator.comparingInt(customer -> (int) tickets.stream()
                        .filter(ticket -> ticket.getCustomer().equals(customer)).count()));

        customerWithMostTickets.ifPresent(customer ->
                System.out.println("Customer: " + customer.getName())
        );

        System.out.println("\n=== Customer with Largest Cost of Purchases ===");
        Optional<Customer> customerWithLargestCost = customers.stream()
                .max(Comparator.comparingDouble(customer -> tickets.stream()
                        .filter(ticket -> ticket.getCustomer().equals(customer))
                        .mapToDouble(Ticket::getPaymentAmount)
                        .sum()));

        customerWithLargestCost.ifPresent(customer ->
                System.out.println("Customer: " + customer.getName())
        );
    }

    // 4. List of the customers who have not purchased any tickets
    public void reportCustomersWithoutTickets() {
        System.out.println("=== Customers Without Tickets ===");
        customers.stream()
                .filter(customer -> tickets.stream().noneMatch(ticket -> ticket.getCustomer().equals(customer)))
                .forEach(customer -> System.out.println("Customer: " + customer.getName()));
    }
}

