package com.deepak.flightregistration.setupflightlibrary;


import java.util.Date;

public interface SetupFlightLibraryModelCallback {
    void addFlightDetailsDB(
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

    void getFlightsFromDB();
    void removeFlightsFromDB(String flightNumber);
}
