package com.deepak.flightregistration.setupflightlibrary;

import com.deepak.flightregistration.dto.Flight;

import java.util.List;

public interface SetupFlightLibraryModelControllerCallback {
    void addFlightDetailsSuccess(Flight flight);
    void addFlightDetailsExist();

    void viewFlightsEmpty();
    void viewFlightsSuccess(List<Flight> flightList);

    void removeFlightSuccess(List<Flight> flightList);
    void removeFlightDoesNotExist();
}
