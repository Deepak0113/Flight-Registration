package com.deepak.flightregistration.setupflightlibrary;

import java.util.Date;

public interface SetupFlightLibraryViewControllerCallback {
    void chooseOption(int option);
    void addFlightDetails(
            String flightNumber,
            String name,
            String departure,
            String destination,
            Date departureDateTime,
            Date destinationDateTime,
            String[] seatingClasses,
            int[] seatingClassesPrices,
            int totalSeats,
            int reservedSeats,
            int reservationPrice
    );

    String[] getSeatingClassesFromInput(String seatingClassInput);
    int[] getSeatingClassesPriceFromInput(String seatingClassPriceInput);
    void getFlights();

    void removeFlightDetails(String flightNumber);

}
