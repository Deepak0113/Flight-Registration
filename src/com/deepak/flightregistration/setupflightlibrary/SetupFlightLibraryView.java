package com.deepak.flightregistration.setupflightlibrary;

import com.deepak.flightregistration.dto.Flight;
import com.deepak.flightregistration.starting.StartingView;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class SetupFlightLibraryView implements SetupFlightLibraryViewCallback{
    private final Scanner scanner = new Scanner(System.in);
    private final SetupFlightLibraryViewControllerCallback setupFlightController;

    public SetupFlightLibraryView(){
        setupFlightController = new SetupFlightLibraryController(this);
    }


    /*------ Navigation ------*/

    // starts when setup comes
    public void startSetupFlightLibrary(){
        System.out.println("\nHi admin");
        System.out.println("1. Add flight");
        System.out.println("2. View flights");
        System.out.println("3. Remove flights");
        System.out.println("4. Go to starting");
        System.out.print("Enter option: ");
        int option = Integer.parseInt(scanner.nextLine());
        setupFlightController.chooseOption(option);
    }

    // fo to starting module
    @Override
    public void gotoStarting() {
        StartingView startingView = new StartingView();
        startingView.startStartingView();
    }

    // exits the application
    @Override
    public void exitApplication() {
        System.exit(0);
    }


    /*------ Add Flight Section ------*/

    // add flight details to the database via controller
    @Override
    public void addFlightDetails(){
        // enter flight number from admin
        System.out.print("Enter flight number: ");
        String flightNumber = scanner.nextLine();

        // enter flight name from admin
        System.out.print("Enter flight name: ");
        String flightName = scanner.nextLine();

        // enter flight departure location from admin
        System.out.print("Enter flight departure: ");
        String departure = scanner.nextLine();

        // enter flight destination location from admin
        System.out.print("Enter flight destination: ");
        String destination = scanner.nextLine();

        // enter flight departure time from admin
        System.out.print("Enter flight departure time (MM-DD-YYYY HH:MM:SS): ");
        Date departureDateTime = new Date(scanner.nextLine());

        // enter flight destination tim efrom admin
        System.out.print("Enter flight destination time (MM-DD-YYYY HH:MM:SS): ");
        Date destinationDateTime = new Date(scanner.nextLine());

        // enter different flight seating classes like economic, business, etc
        System.out.print("Enter flight seating class: ");
        String[] seatingClasses = setupFlightController.getSeatingClassesFromInput(scanner.nextLine());

        // enter flight seating classes prices
        System.out.print("Enter flight seating class price: ");
        int[] seatingClassesPrices = setupFlightController.getSeatingClassesPriceFromInput(scanner.nextLine());

        // enter total seats in a flight
        System.out.print("Enter total passengers limit: ");
        int totalSeats = Integer.parseInt(scanner.nextLine());

        // enter reserved seats in a flight
        System.out.print("Enter reserved seats in a flight: ");
        int reservedSeats = Integer.parseInt(scanner.nextLine());

        // enter reserved seats in a flight price
        System.out.print("Enter reserved seating price addition in a flight: ");
        int reservationPrice = Integer.parseInt(scanner.nextLine());

        setupFlightController.addFlightDetails(
                flightNumber,
                flightName,
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

    @Override
    public void addFlightDetailsSuccessView(Flight flight) {
        System.out.println("Successfully flight added");
        System.out.println(flight);
    }

    @Override
    public void addFlightDetailsExistView() {
        System.out.println("Flight already exists");
    }


    /*------ View Flight Section ------*/

    // get available flights
    @Override
    public void getAvailableFlights() {
        setupFlightController.getFlights();
    }

    // view flights
    @Override
    public void viewFlightsSuccessView(List<Flight> flightList) {
        for(Flight flight: flightList){
            System.out.println(flight);
        }
    }

    // no available flights
    @Override
    public void viewFlightsEmpty() {
        System.out.println("There are no available flights.");
    }


    /*------ Remove Flight Section ------*/

    // remove flight details
    @Override
    public void removeFlightDetails() {
        System.out.println("Enter flight number: ");
        setupFlightController.removeFlightDetails(scanner.nextLine());
    }

    @Override
    public void removeFlightDetailsSuccessView(List<Flight> flightList) {
        System.out.println("Removed flight: ");
        System.out.println(flightList);
    }

    @Override
    public void removeFlightDetailsDoesNotExist() {
        System.out.println("Flight details does not exist.");
    }

}
