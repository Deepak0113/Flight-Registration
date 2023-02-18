package com.deepak.flightregistration.ticketbooking;

import com.deepak.flightregistration.dto.Flight;

import java.util.List;

public interface TicketBookingViewCallback {
    void getUserPreferenceFlights();
    void displayFilteredFlights(List<Flight> flights);

    void selectValidOptionWarning();
    void getBookingDetails(int passengers);
    void getPassengerDetails(int passengers);
    void cancelTicket();
    void showTickets();
}
