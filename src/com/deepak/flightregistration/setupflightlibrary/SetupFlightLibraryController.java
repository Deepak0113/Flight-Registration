package com.deepak.flightregistration.setupflightlibrary;

import com.deepak.flightregistration.dto.Flight;

import java.util.Date;
import java.util.List;

public class SetupFlightLibraryController implements SetupFlightLibraryViewControllerCallback, SetupFlightLibraryModelControllerCallback {
    private final SetupFlightLibraryViewCallback setupFlightLibraryView;
    private final SetupFlightLibraryModelCallback setupFlightLibraryModel;

    SetupFlightLibraryController(SetupFlightLibraryViewCallback setupFlightLibraryView){
        this.setupFlightLibraryView = setupFlightLibraryView;
        setupFlightLibraryModel = new SetupFlightLibraryModel(this);
    }

    /*------ Input formatting ------*/

    // returns string array of seating classes
    @Override
    public String[] getSeatingClassesFromInput(String seatingClassInput) {
        return seatingClassInput.split(" ");
    }

    // returns int array of seating classes prices
    @Override
    public int[] getSeatingClassesPriceFromInput(String seatingClassPriceInput) {
        String[] prices = seatingClassPriceInput.split(" ");
        int[] seatingprices = new int[prices.length];

        for(int i=0; i<prices.length; i++){
            seatingprices[i] = Integer.parseInt(prices[i]);
        }

        return seatingprices;
    }


    /*------ Navigation ------*/

    @Override
    public void chooseOption(int option) {
        switch (option){
            case 1 -> setupFlightLibraryView.addFlightDetails();
            case 2 -> setupFlightLibraryView.getAvailableFlights();
            case 3 -> setupFlightLibraryView.removeFlightDetails();
            case 4 -> setupFlightLibraryView.gotoStarting();
            case 9 -> setupFlightLibraryView.exitApplication();
        }
    }


    /*------ Add Flight Details ------*/

    // sends add flight request to model
    @Override
    public void addFlightDetails(String flightNumber, String name, String departure, String destination, Date departureDateTime, Date destinationDateTime, String[] seatingClasses, int[] seatingClassesPrices, int totalSeats, int reservedSeats, int reservationPrice) {
        setupFlightLibraryModel.addFlightDetailsDB(
                flightNumber,
                name,
                departure,
                destination,
                departureDateTime,
                destinationDateTime,
                seatingClasses,
                seatingClassesPrices,
                totalSeats,
                reservedSeats,
                reservationPrice
        );
    }

    // success response to the view
    @Override
    public void addFlightDetailsSuccess(Flight flight) {
        setupFlightLibraryView.addFlightDetailsSuccessView(flight);
    }

    // failed response to the view
    @Override
    public void addFlightDetailsExist() {
        setupFlightLibraryView.addFlightDetailsExistView();
    }


    /*------ View Flight Details ------*/

    @Override
    public void getFlights() {
        setupFlightLibraryModel.getFlightsFromDB();
    }

    @Override
    public void viewFlightsEmpty() {
        setupFlightLibraryView.viewFlightsEmpty();
    }

    @Override
    public void viewFlightsSuccess(List<Flight> flightList) {
        setupFlightLibraryView.viewFlightsSuccessView(flightList);
    }


    /*------ Remove Flight Details ------*/

    @Override
    public void removeFlightDetails(String flightNumber) {
        setupFlightLibraryModel.removeFlightsFromDB(flightNumber);
    }

    @Override
    public void removeFlightSuccess(List<Flight> flightList) {
        setupFlightLibraryView.removeFlightDetailsSuccessView(flightList);
    }

    @Override
    public void removeFlightDoesNotExist() {
        setupFlightLibraryView.removeFlightDetailsDoesNotExist();
    }
}
