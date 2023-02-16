package com.deepak.flightregistration.setupflightlibrary;

import com.deepak.flightregistration.dto.Flight;

import java.util.List;

public interface SetupFlightLibraryModelControllerCallback {
    void flightAddedSuccessfully(Flight flight);
    void flightAddFailed(String message);

    void availableFlights(List<Flight> flights);

    void removeFlightDetailsStatus(boolean isRemoved);
}
