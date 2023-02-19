package com.deepak.flightregistration.dto;

public class Seat {
    String seatClass;
    int seatNumber;
    String flightNumber;
    float cost;

    public Seat(String seatClass, int seatNumber, String flightNumber, float cost){
        this.seatClass = seatClass;
        this.seatNumber = seatNumber;
        this.flightNumber = flightNumber;
        this.cost = cost;
    }

    public float getCost() {
        return cost;
    }
}
