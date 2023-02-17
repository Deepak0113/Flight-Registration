package com.deepak.flightregistration.ticketbooking;

import com.deepak.flightregistration.dto.Flight;
import com.deepak.flightregistration.dto.Passenger;
import com.deepak.flightregistration.dto.Ticket;

import java.util.List;

public class TicketBookingController implements TicketBookingViewControllerCallback, TicketBookingModelControllerCallback{
    private TicketBookingViewCallback ticketBookingView;
    private TicketBookingModelCallback ticketBookingModel;

    TicketBookingController(TicketBookingViewCallback ticketBookingView){
        this.ticketBookingView = ticketBookingView;
        ticketBookingModel = new TicketBookingModel(this);
    }

    // choose option
    @Override
    public void chooseOption(int option) {
        switch (option){
            case 1:
                ticketBookingView.getUserPreference();
                break;
            default:
                ticketBookingView.selectValidOptionWarning();
        }
    }

    // get flights filter
    @Override
    public void filterUsingPreference(String preferredDeparture, String preferredDestination, String preferredDate, String preferredSeatingClass, int preferredTotalPassengers) {
        ticketBookingModel.filterUsingPreferenceDB(preferredDeparture, preferredDestination, preferredDate, preferredSeatingClass, preferredTotalPassengers);
    }

    @Override
    public void addPassenger(String name, String email, String gender, String phoneNumber, String nationality, String aadharID) {
        ticketBookingModel.addPassenger(name, email, gender, phoneNumber, nationality, aadharID);
    }

    @Override
    public List<Passenger> getPassengers() {
        return ticketBookingModel.getPassenger();
    }

    @Override
    public Flight getSelectedFlight(String flightNumber) {
        return ticketBookingModel.getSelectedFlight(flightNumber);
    }

    @Override
    public String createTicket(Flight flight, List<Passenger> passengerList) {
        return ticketBookingModel.createTicket(flight, passengerList, passengerList.size() * 2000);
    }

    @Override
    public boolean cancelTicket(String ticketId) {
        return ticketBookingModel.cancelTicket(ticketId);
    }

    @Override
    public List<Ticket> showTickets() {
        return ticketBookingModel.showTickets();
    }

    // filtered flights response
    @Override
    public void filteredFlightsResp(List<Flight> flights) {
        ticketBookingView.displayFilteredFlights(flights);
    }
}
