package com.deepak.flightregistration.ticketbooking;

import com.deepak.flightregistration.dto.Flight;
import com.deepak.flightregistration.dto.Passenger;

import java.util.List;

public interface TicketBookingViewCallback {
    void getUserPreference();
    void selectValidOptionWarning();
    void displayFilteredFlights(List<Flight> flights);
    void getBookingDetails(int passengers);
    void getPassengerDetails(int passengers);
}
