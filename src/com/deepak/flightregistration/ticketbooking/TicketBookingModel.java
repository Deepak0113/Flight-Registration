package com.deepak.flightregistration.ticketbooking;

import com.deepak.flightregistration.repository.FlightDB;

import java.util.List;

public class TicketBookingModel implements TicketBookingModelCallback{
    private TicketBookingModelControllerCallback ticketBookingController;

    TicketBookingModel(TicketBookingModelControllerCallback ticketBookingController){
        this.ticketBookingController = ticketBookingController;
    }

    @Override
    public void filterUsingPreferenceDB(String preferredDeparture, String preferredDestination, String preferredDate, String preferredSeatingClass, int preferredTotalPassengers) {
        List<FlightDB> filteredFlights = FlightDB.getInstance().searchFlights(preferredDeparture, preferredDestination, preferredDate, preferredSeatingClass, preferredTotalPassengers);
    }
}
