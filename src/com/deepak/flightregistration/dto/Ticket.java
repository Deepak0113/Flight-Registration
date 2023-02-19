package com.deepak.flightregistration.dto;

import java.util.List;

public class Ticket {
    private String ticketID;
    private Flight flight;
    private List<Seat> seat;
    private int passengers;
    private List<Passenger> passengerList;
    private float totalPrice;

    public Ticket(String ticketID, Flight flight, int passengers, List<Passenger> passengerList, float totalPrice) {
        this.ticketID = ticketID;
        this.flight = flight;
        this.passengers = passengers;
        this.passengerList = passengerList;
        this.totalPrice = totalPrice;
    }

    public Ticket(String ticketID){
        this.ticketID = ticketID;
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

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public void setSeat(List<Seat> seat) {
        this.seat = seat;
    }

    public List<Seat> getSeat() {
        return seat;
    }

    @Override
    public String toString() {
        String res = "Ticket Id: " + ticketID + "\n";
        res += flight.toString() + "\n";
        for(Passenger passenger: passengerList){
            res += passenger + "\n";
        }

        res += getTotalPrice();

        return res;
    }
}
