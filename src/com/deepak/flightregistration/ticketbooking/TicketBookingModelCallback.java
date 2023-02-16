package com.deepak.flightregistration.ticketbooking;

public interface TicketBookingModelCallback {
    void filterUsingPreferenceDB(String preferredDeparture, String preferredDestination, String preferredDate, String preferredSeatingClass, int preferredTotalPassengers);
}
