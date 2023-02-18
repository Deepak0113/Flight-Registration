package com.deepak.flightregistration.setupflightlibrary;

import com.deepak.flightregistration.repository.Repository;
import com.deepak.flightregistration.status.FlightStatusCalls;

import java.util.Date;

public class SetupFlightLibraryModel implements SetupFlightLibraryModelCallback{
    private final SetupFlightLibraryModelControllerCallback setupFlightLibraryController;

    SetupFlightLibraryModel(SetupFlightLibraryModelControllerCallback setupFlightLibraryController){
        this.setupFlightLibraryController = setupFlightLibraryController;
    }


    @Override
    public void addFlightDetailsDB(String flightNumber, String name, String departure, String destination, Date departureDateTime, Date destinationDateTime, String[] seatingClasses, int[] seatingClassesPrices, int totalSeats, int reservedSeats, int reservationPrice) {
        FlightStatusCalls flightStatusCall = Repository.getInstance().addFlightToDB(flightNumber, name, departure, destination, departureDateTime, destinationDateTime, seatingClasses, seatingClassesPrices, totalSeats, reservedSeats, reservationPrice);

        switch(flightStatusCall.getStatus()){
            case "SUCCESS" -> setupFlightLibraryController.addFlightDetailsSuccess(flightStatusCall.getFlight());
            case "EXISTS" -> setupFlightLibraryController.addFlightDetailsExist();
        }
    }

    @Override
    public void getFlightsFromDB() {
        FlightStatusCalls flightStatusCall = Repository.getInstance().getAvailableFlightsFromDB();

        switch (flightStatusCall.getStatus()){
            case "SUCCESS" -> setupFlightLibraryController.viewFlightsSuccess(flightStatusCall.getFlightList());
            case "EMPTY" -> setupFlightLibraryController.viewFlightsEmpty();
        }
    }

    @Override
    public void removeFlightsFromDB(String flightNumber) {
        FlightStatusCalls flightStatusCall = Repository.getInstance().removeFlightFromDB(flightNumber);

        switch (flightStatusCall.getStatus()){
            case "SUCCESS" -> setupFlightLibraryController.removeFlightSuccess(flightStatusCall.getFlightList());
            case "NOT EXIST" -> setupFlightLibraryController.removeFlightDoesNotExist();
        }
    }
}
