package com.deepak.flightregistration.setupflightlibrary;

import com.deepak.flightregistration.dto.Flight;

import java.util.List;

public class SetupFlightLibraryController implements SetupFlightLibraryViewControllerCallback, SetupFlightLibraryModelControllerCallback {
    private SetupFlightLibraryViewCallback setupFlightLibraryView;
    private SetupFlightLibraryModelCallback setupFlightLibraryModel;

    SetupFlightLibraryController(SetupFlightLibraryViewCallback setupFlightLibraryView){
        this.setupFlightLibraryView = setupFlightLibraryView;
        setupFlightLibraryModel = new SetupFlightLibraryModel(this);
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
                setupFlightLibraryView.selectValidOptionWarning();
                break;
        }
    }

    @Override
    public void addFlightDetails(String flightNumber, String flightName, String departure, String destination, String departureDateTime, String destinationDateTime, String seatingClass, int totalPassengers) {
        setupFlightLibraryModel.addFlightDetailsDB(flightNumber, flightName, departure, destination, departureDateTime, destinationDateTime, seatingClass, totalPassengers);
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
    public void removeFlightDetailsControlller(String flightNumber) {
        setupFlightLibraryModel.removeFlightDetailsDB(flightNumber);
    }

    @Override
    public void removeFlightDetailsStatus(boolean isRemoved) {
        if(isRemoved){
            setupFlightLibraryView.removedFlightSuccessfully();
        } else{
            setupFlightLibraryView.removeFlightFailed();
        }
    }

    @Override
    public void getAvailableFlights() {
        setupFlightLibraryModel.getAvailableFlightsDB();
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
