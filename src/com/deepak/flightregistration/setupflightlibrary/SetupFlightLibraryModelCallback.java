package com.deepak.flightregistration.setupflightlibrary;

import com.deepak.flightregistration.dto.Flight;

import java.util.ArrayList;

public interface SetupFlightLibraryModelCallback {
    void addFlightDetailsDB(String flighNumber, String flightName, String departure, String destination, String departureTime);
    void getAvailableFlightsDB();
}
