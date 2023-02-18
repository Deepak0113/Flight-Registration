package com.deepak.flightregistration.ticketing;

public interface TicketingModelCallback {
    void cancelTicketDB(String ticketId);
    void viewTicketDB();
}