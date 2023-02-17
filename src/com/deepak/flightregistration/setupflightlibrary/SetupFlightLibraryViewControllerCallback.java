package com.deepak.flightregistration.setupflightlibrary;

public interface SetupFlightLibraryViewControllerCallback {
    void chooseOption(int option);
    void getAvailableFlights();

    void removeFlightDetailsControlller(String flightNumber);

    void addFlightDetails(String flightNumber, String flightName, String departure, String destination, String departureDateTime, String destinationDateTime, String seatingClass, int totalPassengers);
}
