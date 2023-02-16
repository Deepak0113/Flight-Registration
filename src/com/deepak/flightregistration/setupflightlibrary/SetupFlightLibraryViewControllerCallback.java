package com.deepak.flightregistration.setupflightlibrary;

import com.deepak.flightregistration.dto.Flight;

import java.util.ArrayList;

public interface SetupFlightLibraryViewControllerCallback {
    void addFlightDetails(String flightNumber, String flightName, String departure, String destination, String departureTime);

    void chooseOption(int option);
    void getAvailableFlights();
}
