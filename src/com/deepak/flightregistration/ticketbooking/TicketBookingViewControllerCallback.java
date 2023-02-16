package com.deepak.flightregistration.ticketbooking;

public interface TicketBookingViewControllerCallback {
    void chooseOption(int option);
    void filterUsingPreference(String preferredDeparture, String preferredDestination, String preferredDate, String preferredSeatingClass, int preferredTotalPassengers);
}