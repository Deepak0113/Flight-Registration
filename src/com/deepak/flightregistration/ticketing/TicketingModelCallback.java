package com.deepak.flightregistration.ticketing;

import java.util.Date;

public interface TicketingModelCallback {
    void cancelTicketDB(String ticketId);
    void viewTicketDB();

    void createPassenger(String ticketId, String name, String email, String gender, String phoneNumber, String nationality, String aadhaarID);
    String createNewTicket();

    void viewPreferredFlights(String ticketId, String departure, String destination, Date departureDate, String seatingClass, int passengerNo);

    void createSeat(String ticketId, String flightNumber, String seatClass, int passengerCount);

    float getTotalCost(String ticketId);
}