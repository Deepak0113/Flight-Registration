package com.deepak.flightregistration.setupflightlibrary;

import com.deepak.flightregistration.dto.Flight;

import java.util.ArrayList;

public interface SetupFlightLibraryViewControllerCallback {
    void chooseOption(int option);
    void getAvailableFlights();

    void removeFlightDetails(String flightNumber);

    void addFlightDetails(String flightNumber, String flightName, String departure, String destination, String departureDateTime, String destinationDateTime, String seatingClass, int totalPassengers);
}
