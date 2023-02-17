package com.deepak.flightregistration.ticketbooking;

import com.deepak.flightregistration.dto.Flight;
import com.deepak.flightregistration.dto.Passenger;
import com.deepak.flightregistration.dto.Ticket;
import com.deepak.flightregistration.repository.Repository;

import java.util.List;

public class TicketBookingModel implements TicketBookingModelCallback{
    private TicketBookingModelControllerCallback ticketBookingController;

    TicketBookingModel(TicketBookingModelControllerCallback ticketBookingController){
        this.ticketBookingController = ticketBookingController;
    }

    @Override
    public void filterUsingPreferenceDB(String preferredDeparture, String preferredDestination, String preferredDate, String preferredSeatingClass, int preferredTotalPassengers) {
        List<Flight> filteredFlights = Repository.getInstance().searchFlights(preferredDeparture, preferredDestination, preferredDate, preferredSeatingClass, preferredTotalPassengers);
        ticketBookingController.filteredFlightsResp(filteredFlights);
    }

    @Override
    public void addPassenger(String name, String email, String gender, String phoneNumber, String nationality, String aadharID) {
        Repository.getInstance().addPassengerToDB(name, email, gender, phoneNumber, nationality, aadharID);
    }

    @Override
    public List<Passenger> getPassenger() {
        return Repository.getInstance().getPassengerList();
    }

    @Override
    public Flight getSelectedFlight(String flightNumber) {
        return Repository.getInstance().getFlight(flightNumber);
    }

    @Override
    public String createTicket(Flight flight, List<Passenger> passengerList, int totalPrice) {
        return Repository.getInstance().createTicket(flight, passengerList, totalPrice);
    }

    @Override
    public boolean cancelTicket(String ticketId) {
        return Repository.getInstance().cancelTicket(ticketId);
    }

    @Override
    public List<Ticket> showTickets() {
        return Repository.getInstance().getTickets();
    }
}
