package com.travelcompany.eshop.reporting;

//List of the total offered itineraries per destination and per departure

import com.travelcompany.eshop.domain.Itinerary;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ItineraryReportlmpl implements Reportable {
    private List<Itinerary> itineraries;

    public ItineraryReportlmpl(List<Itinerary> itineraries) {
        this.itineraries = itineraries;
    }

    @Override
    public void generateReport() {
        System.out.println("Total offered itineraries per destination:");

        // Group itineraries by destination
        Map<String, Long> destinationCount = itineraries.stream()
                .collect(Collectors.groupingBy(Itinerary::getDestinationAirportCode, Collectors.counting()));

        destinationCount.forEach((destination, count) ->
                System.out.println("Destination: " + destination + ", Itineraries: " + count));

        System.out.println("\nTotal offered itineraries per departure:");

        // Group itineraries by departure
        Map<String, Long> departureCount = itineraries.stream()
                .collect(Collectors.groupingBy(Itinerary::getDepartureAirportCode, Collectors.counting()));

        departureCount.forEach((departure, count) ->
                System.out.println("Departure: " + departure + ", Itineraries: " + count));
    }
}
