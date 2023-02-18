package com.deepak.flightregistration.ticketbooking;

import com.deepak.flightregistration.dto.Flight;
import com.deepak.flightregistration.dto.Passenger;
import com.deepak.flightregistration.dto.Ticket;

import java.util.List;

public interface TicketBookingViewControllerCallback {
    void getUserPreferredFlights(
            String preferredDeparture,
            String preferredDestination,
            String preferredDate,
            String preferredSeatingClass,
            int preferredTotalPassengers
    );
    Flight getFlightDetails(String flightNumber);

    void addPassenger(String name, String email, String gender, String phoneNumber, String nationality, String aadharID);
    List<Passenger> getPassengers();
    String createTicket(Flight flight, List<Passenger> passengerList);
    boolean cancelTicket(String ticketId);
    List<Ticket> showTickets();

    void chooseOption(int option);
}