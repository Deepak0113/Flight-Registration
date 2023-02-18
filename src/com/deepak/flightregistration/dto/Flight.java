package com.deepak.flightregistration.dto;

import java.util.Date;

public class Flight {
    private String flightNumber;
    private String name;
    private String departure;
    private String destination;
    private Date departureDateTime;
    private Date destinationDateTime;
    private String[] seatingClasses;
    private int[] seatingClassesPrices;
    private int totalSeats;
    private int reservedSeats;
    private int reservationPrice;
    private int[] seats;

    public Flight(String flightNumber, String name, String departure, String destination, Date departureDateTime, Date destinationDateTime, String[] seatingClasses, int[] seatingClassesPrices, int totalSeats, int reservedSeats, int reservationPrice) {
        this.flightNumber = flightNumber;
        this.name = name;
        this.departure = departure;
        this.destination = destination;
        this.departureDateTime = departureDateTime;
        this.destinationDateTime = destinationDateTime;
        this.seatingClasses = seatingClasses;
        this.seatingClassesPrices = seatingClassesPrices;
        this.totalSeats = totalSeats;
        this.reservedSeats = reservedSeats;
        this.reservationPrice = reservationPrice;
        this.seats = new int[totalSeats];
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    @Override
    public String toString() {
        String res = flightNumber+" "+name+" "+departure+" "+destination+" "+departureDateTime+" "+destinationDateTime;
        return res;
    }
}
