package com.deepak.flightregistration.setupflightlibrary;

import com.deepak.flightregistration.dto.Flight;
import com.deepak.flightregistration.repository.FlightDB;

import java.util.ArrayList;
import java.util.List;

public class SetupFlightLibraryModel implements SetupFlightLibraryModelCallback{
    private SetupFlightLibraryModelControllerCallback setupFlightLibraryController;

    SetupFlightLibraryModel(SetupFlightLibraryModelControllerCallback setupFlightLibraryController){
        this.setupFlightLibraryController = setupFlightLibraryController;
    }

    @Override
    public void addFlightDetailsDB(String flightNumber, String flightName, String departure, String destination, String departureTime) {
        Flight addedFlight = FlightDB.getInstance().addFlightToDB(flightNumber, flightName, departure, destination, departureTime);
        setupFlightLibraryController.flightAddedSuccessfully(addedFlight);
    }

    @Override
    public void getAvailableFlightsDB() {
        List<Flight> flights = FlightDB.getInstance().getAvailableFlightsFromDB();
        setupFlightLibraryController.availableFlights(flights);
    }
}
