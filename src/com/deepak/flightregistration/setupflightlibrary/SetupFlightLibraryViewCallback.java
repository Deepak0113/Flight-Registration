package com.deepak.flightregistration.setupflightlibrary;

import com.deepak.flightregistration.dto.Flight;

import java.util.List;

public interface SetupFlightLibraryViewCallback {
    void addFlightDetailsSuccessView(Flight flight);
    void addFlightDetailsExistView();
    void addFlightDetails();

    void getAvailableFlights();
    void viewFlightsSuccessView(List<Flight> flightList);
    void viewFlightsEmpty();

    void removeFlightDetails();
    void removeFlightDetailsSuccessView(List<Flight> flightList);
    void removeFlightDetailsDoesNotExist();

    void gotoStarting();
    void exitApplication();
}
