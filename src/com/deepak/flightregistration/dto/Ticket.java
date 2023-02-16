package com.deepak.flightregistration.dto;

import java.util.List;

public class Ticket {
    private String ticketID;
    private Flight flight;
    private List<Passenger> passengerList;
    private float ticketPrice;
    private int baggage;
    private float baggagePrice;
    private float totalPrice;

    public Ticket(String ticketID, Flight flight, List<Passenger> passengerList, float ticketPrice, int baggage, float baggagePrice, float totalPrice) {
        this.ticketID = ticketID;
        this.flight = flight;
        this.passengerList = passengerList;
        this.ticketPrice = ticketPrice;
        this.baggage = baggage;
        this.baggagePrice = baggagePrice;
        this.totalPrice = totalPrice;
    }

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    public float getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getBaggage() {
        return baggage;
    }

    public void setBaggage(int baggage) {
        this.baggage = baggage;
    }

    public float getBaggagePrice() {
        return baggagePrice;
    }

    public void setBaggagePrice(float baggagePrice) {
        this.baggagePrice = baggagePrice;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
}
