package com.travelcompany.eshop.service;

import com.travelcompany.eshop.domain.Itinerary;
import com.travelcompany.eshop.exception.InvalidAirportCodeException;

import java.util.Arrays;
import java.util.List;

public class ItineraryService {

    private final List<String> validAirportCodes = Arrays.asList("ATH", "PAR", "LON", "AMS", "DUB", "FRA", "MEX");

    public Itinerary createItinerary(int id, String departureCode, String destinationCode, String date, String airline, double price) throws InvalidAirportCodeException {
        if (!validAirportCodes.contains(departureCode)) {
            throw new InvalidAirportCodeException("Invalid departure airport code: " + departureCode);
        }
        if (!validAirportCodes.contains(destinationCode)) {
            throw new InvalidAirportCodeException("Invalid destination airport code: " + destinationCode);
        }
        return new Itinerary(id, departureCode, destinationCode, date, airline, price);
    }
}
