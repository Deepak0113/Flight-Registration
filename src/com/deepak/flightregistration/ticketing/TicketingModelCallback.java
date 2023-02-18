package com.deepak.flightregistration.ticketing;

public interface TicketingModelCallback {
    void cancelTicketDB(String ticketId);
    void viewTicketDB();

    void createPassenger(String ticketId, String name, String email, String gender, String phoneNumber, String nationality, String aadhaarID);
    String createNewTicket();
}