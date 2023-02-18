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
    void bookTicket(){
        String ticketId = ticketingController.createTicket();
        getPassengersDetails(ticketId);
    }

    void getPassengersDetails(String ticketId){
        System.out.println("\nPassenger details");
        System.out.println("---------------------");

        for(int i=1; i<=10; i++){
            System.out.println("\nPassenger " + i);
            System.out.println("-------------------------");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Gender (male/female): ");
            String gender = scanner.nextLine();
            System.out.print("Phone Number: ");
            String phno = scanner.nextLine();
            System.out.print("Nationality: ");
            String nationality = scanner.nextLine();
            System.out.print("Aadhaar Id: ");
            String aadhaarId = scanner.nextLine();

            ticketingController.createPassenger(ticketId, name, email, gender, phno, nationality, aadhaarId);
        }
    }


    /*------ Ticket Cancellation ------*/

    @Override
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

    @Override
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