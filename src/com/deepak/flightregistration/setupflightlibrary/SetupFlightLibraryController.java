package com.deepak.flightregistration.setupflightlibrary;

import com.deepak.flightregistration.dto.Flight;

import java.util.ArrayList;
import java.util.List;

public class SetupFlightLibraryController implements SetupFlightLibraryViewControllerCallback, SetupFlightLibraryModelControllerCallback {
    private SetupFlightLibraryViewCallback setupFlightLibraryView;
    private SetupFlightLibraryModelCallback setupFlightLibraryModel;

    SetupFlightLibraryController(SetupFlightLibraryViewCallback setupFlightLibraryView){
        this.setupFlightLibraryView = setupFlightLibraryView;
        setupFlightLibraryModel = new SetupFlightLibraryModel(this);
    }

    @Override
    public void addFlightDetails(String flightNumber, String flightName, String departure, String destination, String departureTime) {
        setupFlightLibraryModel.addFlightDetailsDB(flightNumber, flightName, departure, destination, departureTime);
    }

    @Override
    public void chooseOption(int option) {
        switch (option){
            case 1:
                setupFlightLibraryView.addFlightDetails();
                break;
            case 2:
                setupFlightLibraryView.getAvailableFlights();
                break;
            default:
                setupFlightLibraryView.selectValidOption();
                break;
        }
    }

    @Override
    public void getAvailableFlights() {
        setupFlightLibraryModel.getAvailableFlightsDB();
    }

    @Override
    public void flightAddedSuccessfully(Flight flight) {
        setupFlightLibraryView.flightAddedSuccessfully(flight);
    }

    @Override
    public void flightAddFailed(String message) {
        setupFlightLibraryView.flightAddFailed(message);
    }

    @Override
    public void availableFlights(List<Flight> flights) {
        if(flights.size() != 0){
            setupFlightLibraryView.viewAvailableFlights(flights);
        } else{
            setupFlightLibraryView.noFlightAvailableWarning();
        }
    }


}
