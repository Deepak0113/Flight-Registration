package com.deepak.flightregistration.ticketbooking;

import java.util.Scanner;

public class TicketBookingView implements TicketBookingViewCallback{
    private final Scanner scanner = new Scanner(System.in);
    private TicketBookingViewControllerCallback ticketBookingController;

    TicketBookingView(){
        ticketBookingController = new TicketBookingController(this);
    }

    // start booking model
    public void startBookingModel(){
        System.out.println("1. Ticket booking");
        System.out.println("2. Ticket cancellation");
        System.out.print("Enter option: ");
        int option = Integer.parseInt(scanner.nextLine());
    }

    // user preferred detail filters
    @Override
    public void getUserPreference(){
        System.out.println("Enter departure: ");
        String preferedDeparture = scanner.nextLine();
        System.out.println("Enter destination: ");
        String preferedDestination = scanner.nextLine();
        System.out.println("Enter date: ");
        String preferedDate = scanner.nextLine();
        System.out.println("Enter seating class: ");
        String preferedSeatingClass = scanner.nextLine();
        System.out.println("Enter total passengers: ");
        int preferedTotalPassengers = Integer.parseInt(scanner.nextLine());

        ticketBookingController.filterUsingPreference(preferedDeparture, preferedDestination, preferedDate, preferedSeatingClass, preferedTotalPassengers);
    }

    @Override
    public void selectValidOptionWarning() {
        System.out.println("Select valid option.");
    }
}
