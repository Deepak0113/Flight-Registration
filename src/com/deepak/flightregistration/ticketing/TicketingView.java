package com.deepak.flightregistration.ticketing;

import com.deepak.flightregistration.dto.Ticket;

import java.util.List;
import java.util.Scanner;

public class TicketingView implements TicketingViewCallback {
    private final Scanner scanner = new Scanner(System.in);
    private TicketingViewControllerCallback ticketingController;

    TicketingView() {
        ticketingController = new TicketingController(this);
    }

    /*------ Navigation ------*/
    public void startTicketing(){
        System.out.println("1. Book ticket");
        System.out.println("2. Cancel ticket");
        System.out.println("3. View ticket");
        System.out.println("9. Exit");
        int option = Integer.parseInt(scanner.nextLine());


    }

    /*------ Ticket Booking ------*/


    /*------ Ticket Cancellation ------*/
    public void ticketCancellation(){
        System.out.print("Enter ticket id: ");
        ticketingController.cancelTicket(scanner.nextLine());
    }

    @Override
    public void ticketCancellationSuccessful() {
        System.out.println("Ticket cancelled successfully");
        startTicketing();
    }

    @Override
    public void ticketCancellationFailed(String errorMessage) {
        System.out.println("Failed ticket cancellation: " + errorMessage);
        startTicketing();
    }


    /*------ View Tickets ------*/
    public void viewBookedTickets(){
        ticketingController.viewBookedTickets();
    }

    @Override
    public void viewBookedTicketsSuccessful(List<Ticket> ticketList) {
        for(Ticket ticket: ticketList){
            System.out.println(ticket);
        }
    }

    @Override
    public void viewBookedTicketsEmpty() {
        System.out.println("No tickets available. Book now to travel around!!");
    }

    /*------ Thatkal ------*/
}