package com.deepak.flightregistration.ticketing;

import java.util.Date;

public interface TicketingViewControllerCallback {
    void selectOption(int option);

    /*------ Cancellation ------*/
    void cancelTicket(String ticketId);

    /*------ View Tickets ------*/
    void viewBookedTickets();

    /*------ Ticket Booking ------*/
    void createPassenger(
            String ticketId,
            String name,
            String email,
            String gender,
            String phoneNumber,
            String nationality,
            String aadhaarID
    );

    String createTicket();

    void viewPreferredFlights(String ticketId, String departure, String destination, Date departureDate, String seatingClass, int passengerNo);

    void createSeat(String flightNumber, String seatClass, String aClass, int passengerCount);

    float getTotalCost(String ticketId);
}
