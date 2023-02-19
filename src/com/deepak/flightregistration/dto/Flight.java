package com.deepak.flightregistration.dto;

import java.text.SimpleDateFormat;
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
    private int availableSeats;
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
        this.availableSeats = totalSeats;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public Date getDepartureDateTime() {
        return departureDateTime;
    }

    public String[] getSeatingClasses() {
        return seatingClasses;
    }

    public int[] getSeats() {
        return seats;
    }

    public void setSeats(int[] seats) {
        this.seats = seats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public int[] getSeatingClassesPrices() {
        return seatingClassesPrices;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm");
        String res = flightNumber+" | "+
                name+" | "+
                departure+" | "+
                destination+" | "+
                dateFormat.format(departureDateTime)+" | "+
                dateFormat.format(destinationDateTime)+" | ";
        String result = "";
        for(int i=0; i<seatingClasses.length; i++){
            result += res+seatingClasses[i]+" | "+"Rs"+seatingClassesPrices[i]+"\n";
        }
        return result;
    }
}
