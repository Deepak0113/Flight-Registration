package com.deepak.flightregistration.dto;

public class Flight {
    private String flightNumber;
    private String name;
    private String departure;
    private String destination;
    private String departureDateTime;
    private String destinationDateTime;
    private String seatingClass;
    private int totalPassengers;

    public Flight(String flightNumber, String name, String departure, String destination, String departureDateTime, String destinationDateTime, String seatingClass, int totalPassengers) {
        this.flightNumber = flightNumber;
        this.name = name;
        this.departure = departure;
        this.destination = destination;
        this.departureDateTime = departureDateTime;
        this.destinationDateTime = destinationDateTime;
        this.seatingClass = seatingClass;
        this.totalPassengers = totalPassengers;
    }

    public void setPreferredTotalPassengers(int preferredTotalPassengers) {
        this.totalPassengers = preferredTotalPassengers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(String departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public String getDestinationDateTime() {
        return destinationDateTime;
    }

    public void setDestinationDateTime(String destinationDateTime) {
        this.destinationDateTime = destinationDateTime;
    }

    public String getSeatingClass() {
        return seatingClass;
    }

    public void setPreferredSeatingClass(String preferredSeatingClass) {
        this.seatingClass = preferredSeatingClass;
    }

    public int getTotalPassengers() {
        return totalPassengers;
    }



    @Override
    public String toString() {
        return flightNumber+" "+name+" "+departure+" "+destination+" "+departureDateTime+" "+destinationDateTime+" "+seatingClass+" "+totalPassengers;
    }
}
