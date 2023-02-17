package com.deepak.flightregistration.setupflightlibrary;

import com.deepak.flightregistration.dto.Flight;
import com.deepak.flightregistration.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class SetupFlightLibraryModel implements SetupFlightLibraryModelCallback{
    private SetupFlightLibraryModelControllerCallback setupFlightLibraryController;

    SetupFlightLibraryModel(SetupFlightLibraryModelControllerCallback setupFlightLibraryController){
        this.setupFlightLibraryController = setupFlightLibraryController;
    }

    @Override
    public void addFlightDetailsDB(String flightNumber, String flightName, String departure, String destination, String departureDateTime, String destinationDateTime, String seatingClass, int totalPassengers) {
        Flight addedFlight = Repository.getInstance().addFlightToDB(flightNumber, flightName, departure, destination, departureDateTime, destinationDateTime, seatingClass, totalPassengers);
        setupFlightLibraryController.flightAddedSuccessfully(addedFlight);
    }

    @Override
    public void getAvailableFlightsDB() {
        List<Flight> flights = Repository.getInstance().getAvailableFlightsFromDB();
        setupFlightLibraryController.availableFlights(flights);
    }

    @Override
    public void removeFlightDetailsDB(String flightNumber) {
        boolean isRemoved = Repository.getInstance().removeFlightFromDB(flightNumber);
        setupFlightLibraryController.removeFlightDetailsStatus(isRemoved);
    }
}
