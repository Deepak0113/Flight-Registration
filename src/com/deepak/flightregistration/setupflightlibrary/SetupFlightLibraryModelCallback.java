package com.deepak.flightregistration.setupflightlibrary;

import com.deepak.flightregistration.dto.Flight;

import java.util.ArrayList;

public interface SetupFlightLibraryModelCallback {
    void addFlightDetailsDB(String flightNumber, String flightName, String departure, String destination, String departureDateTime, String destinationDateTime, String seatingClass, int totalPassengers);
    void getAvailableFlightsDB();

    void removeFlightDetailsDB(String flightNumber);
}
