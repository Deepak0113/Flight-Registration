package com.deepak.flightregistration.setupflightlibrary;

import com.deepak.flightregistration.dto.Flight;

import java.util.ArrayList;
import java.util.List;

public interface SetupFlightLibraryViewCallback {
    void flightAddedSuccessfully(Flight flight);
    void flightAddFailed(String message);
    void viewAvailableFlights(List<Flight> flights);
    void getAvailableFlights();
    void addFlightDetails();
    void selectValidOption();
    void noFlightAvailableWarning();
}
