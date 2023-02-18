package com.deepak.flightregistration.ticketing;

public interface TicketingViewControllerCallback {
    void selectOption(int option);

    /*------ Cancellation ------*/
    void cancelTicket(String ticketId);

    /*------ View Tickets ------*/
    void viewBookedTickets();
}
