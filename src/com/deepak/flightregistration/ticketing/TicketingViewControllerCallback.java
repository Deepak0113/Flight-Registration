package com.deepak.flightregistration.ticketing;

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
}
