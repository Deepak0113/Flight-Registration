package com.deepak.flightregistration.ticketbooking;

import com.deepak.flightregistration.dto.Flight;
import com.deepak.flightregistration.dto.Passenger;
import com.deepak.flightregistration.dto.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicketBookingView implements TicketBookingViewCallback{
    private final Scanner scanner = new Scanner(System.in);
    private TicketBookingViewControllerCallback ticketBookingController;

    TicketBookingView(){
        ticketBookingController = new TicketBookingController(this);
    }

    public static void main(String[] args) {
        TicketBookingView ticketBookingView = new TicketBookingView();
        ticketBookingView.getUserPreference();
    }

    // start booking model
    public void startBookingModel(){
        System.out.println("1. Ticket booking");
        System.out.println("2. Ticket cancellation");
        System.out.println("3. View my ticket");
        System.out.print("Enter option: ");
        int option = Integer.parseInt(scanner.nextLine());

        ticketBookingController.chooseOption(option);
    }

    public void cancelTicket(){
        System.out.print("Enter ticket id: ");
        String ticketId = scanner.nextLine();
        ticketBookingController.cancelTicket(ticketId);
    }

    public void showTickets(){
        List<Ticket> tickets = ticketBookingController.showTickets();
        for(Ticket ticket: tickets){
            System.out.println(ticket);
            System.out.println();
        }
    }

    // user preferred detail filters
    @Override
    public void getUserPreference(){
        System.out.print("Enter departure: ");
        String preferredDeparture = scanner.nextLine();
        System.out.print("Enter destination: ");
        String preferredDestination = scanner.nextLine();
        System.out.print("Enter date: ");
        String preferredDate = scanner.nextLine();
        System.out.print("Enter seating class: ");
        String preferredSeatingClass = scanner.nextLine();
        System.out.print("Enter total passengers: ");
        int preferredTotalPassengers = Integer.parseInt(scanner.nextLine());

        ticketBookingController.filterUsingPreference(preferredDeparture, preferredDestination, preferredDate, preferredSeatingClass, preferredTotalPassengers);

        getBookingDetails(preferredTotalPassengers);
    }

    @Override
    public void displayFilteredFlights(List<Flight> flights) {
        System.out.println("\n" + flights.size() + " results....");
        for(Flight flight: flights)
            System.out.println(flight);
    }

    @Override
    public void getBookingDetails(int passengers) {
        System.out.print("Enter flight number: ");
        String flightNumber = scanner.nextLine();
        Flight selectedFlight = ticketBookingController.getSelectedFlight(flightNumber);
        System.out.println("Enter passenger details");
        getPassengerDetails(passengers);
        List<Passenger> passengerList = ticketBookingController.getPassengers();

        String ticketId = ticketBookingController.createTicket(selectedFlight, passengerList);
    }

    @Override
    public void getPassengerDetails(int passengers) {
        int val = 0;
        while(val++ < passengers){
            System.out.println("Passenger " + val);
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter email: ");
            String email = scanner.nextLine();
            System.out.print("Enter gender: ");
            String gender = scanner.nextLine();
            System.out.print("Enter phoneNumber: ");
            String phoneNumber = scanner.nextLine();
            System.out.print("Enter nationality: ");
            String nationality = scanner.nextLine();
            System.out.print("Enter aadharID: ");
            String aadharID = scanner.nextLine();

            ticketBookingController.addPassenger(name, email, gender, phoneNumber, nationality, aadharID);
        }
    }

    @Override
    public void selectValidOptionWarning() {
        System.out.println("Select valid option.");
    }
}
