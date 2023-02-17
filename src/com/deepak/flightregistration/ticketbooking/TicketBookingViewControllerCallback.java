package com.deepak.flightregistration.ticketbooking;

import com.deepak.flightregistration.dto.Flight;
import com.deepak.flightregistration.dto.Passenger;
import com.deepak.flightregistration.dto.Ticket;

import java.util.List;

public interface TicketBookingViewControllerCallback {
    void chooseOption(int option);
    void filterUsingPreference(String preferredDeparture, String preferredDestination, String preferredDate, String preferredSeatingClass, int preferredTotalPassengers);
    void addPassenger(String name, String email, String gender, String phoneNumber, String nationality, String aadharID);
    List<Passenger> getPassengers();
    Flight getSelectedFlight(String flightNumber);
    String createTicket(Flight flight, List<Passenger> passengerList);
    boolean cancelTicket(String ticketId);
    List<Ticket> showTickets();
}