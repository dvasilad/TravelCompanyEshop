package com.travelcompany.eshop.domain;

import java.util.Date;

public class Itinerary {
    private int id;
    private String departureAirportCode;
    private String destinationAirportCode;
    private Date departureDate;
    private String airline;
    private double basicPrice;

    public Itinerary(int id, String departureAirportCode, String destinationAirportCode, Date departureDate, String airline, double basicPrice) {
        this.id = id;
        this.departureAirportCode = departureAirportCode;
        this.destinationAirportCode = destinationAirportCode;
        this.departureDate = departureDate;
        this.airline = airline;
        this.basicPrice = basicPrice;
    }

}

