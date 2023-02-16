package com.deepak.flightregistration.setupflightlibrary;

import com.deepak.flightregistration.dto.Flight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SetupFlightLibraryView implements SetupFlightLibraryViewCallback{
    private final Scanner scanner = new Scanner(System.in);
    private SetupFlightLibraryViewControllerCallback setupFlightController;

    SetupFlightLibraryView(){
        setupFlightController = new SetupFlightLibraryController(this);
    }

    public static void main(String[] args) {
        SetupFlightLibraryView setupFlightLibraryView = new SetupFlightLibraryView();
        setupFlightLibraryView.startSetupFlightLibrary();
    }

    public void startSetupFlightLibrary(){
        System.out.println("\nHi admin");
        System.out.println("1. Add flight");
        System.out.println("2. View flights");
        System.out.print("Enter option: ");
        int option = Integer.parseInt(scanner.nextLine());
        setupFlightController.chooseOption(option);
    }

    @Override
    public void addFlightDetails(){
        System.out.print("Enter flight number: ");
        String flightNumber = scanner.nextLine();
        System.out.print("Enter flight name: ");
        String flightName = scanner.nextLine();
        System.out.print("Enter flight departure: ");
        String departure = scanner.nextLine();
        System.out.print("Enter flight destination: ");
        String destination = scanner.nextLine();
        System.out.print("Enter flight departure time: ");
        String departureTime = scanner.nextLine();

        setupFlightController.addFlightDetails(flightNumber, flightName, departure, destination, departureTime);
    }

    @Override
    public void selectValidOption() {
        System.out.println("Select valid option.");
    }


    @Override
    public void flightAddedSuccessfully(Flight flight) {
        System.out.println("\nFlight added successfully.");
        System.out.println(flight);

        startSetupFlightLibrary();
    }

    @Override
    public void flightAddFailed(String message) {
        System.out.println("Failed to add flight. " + message);
    }

    @Override
    public void viewAvailableFlights(List<Flight> flights) {
        System.out.println("\nAvailable Flights");
        for(Flight flight: flights){
            System.out.println(flight);
        }

        startSetupFlightLibrary();
    }

    @Override
    public void getAvailableFlights() {
        setupFlightController.getAvailableFlights();
    }

    @Override
    public void noFlightAvailableWarning() {

    }
}
