package com.deepak.flightregistration.ticketbooking;

import com.deepak.flightregistration.dto.Flight;

import java.util.List;

public interface TicketBookingModelControllerCallback {
    void filteredFlightsResponse(List<Flight> flights);

    void addPassenger(String name, String email, String gender, String phoneNumber, String nationality, String aadharID);

    void getFlightDetailsSuccess(Flight flight);
    void getFlightDetailsInvalid();
}
