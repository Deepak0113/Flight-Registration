package com.deepak.flightregistration.ticketing;

import com.deepak.flightregistration.dto.Flight;
import com.deepak.flightregistration.dto.Ticket;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TicketingView implements TicketingViewCallback {
    private final Scanner scanner = new Scanner(System.in);
    private final TicketingViewControllerCallback ticketingController;

    public TicketingView() {
        ticketingController = new TicketingController(this);
    }

    /*------ Navigation ------*/
    public void startTicketing(){
        System.out.println("\n1. Book ticket");
        System.out.println("2. Cancel ticket");
        System.out.println("3. View ticket");
        System.out.println("9. Exit");
        System.out.print("Enter option: ");
        int option = Integer.parseInt(scanner.nextLine());
    }

    public static void main(String[] args) {
        TicketingView ticketingView = new TicketingView();
        ticketingView.bookTicket();
    }

    /*------ Ticket Booking ------*/
    @Override
    public void bookTicket(){
        String ticketId = ticketingController.createTicket();
        int passengerNo = getPassengerPreferredFlight(ticketId);
        getPassengersDetails(ticketId, passengerNo);
        float totalCost = ticketingController.getTotalCost(ticketId);
        System.out.println(totalCost);
    }

    void getPassengersDetails(String ticketId, int numOfPassengers){
        System.out.println("\nPassenger details");
        System.out.println("---------------------");

        for(int i=1; i<=numOfPassengers; i++){
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

    int getPassengerPreferredFlight(String ticketId){
        System.out.print("Departure: ");
        String departure = scanner.nextLine();
        System.out.print("Destination: ");
        String destination = scanner.nextLine();
        System.out.print("Departure date (MM/dd/yyyy hh:mm:ss) : ");
        Date departureDate = new Date(scanner.nextLine());
        System.out.print("Seating class: ");
        String seatingClass = scanner.nextLine();
        System.out.print("How many passengers: ");
        int passengerNo = Integer.parseInt(scanner.nextLine());

        ticketingController.viewPreferredFlights(ticketId, departure, destination, departureDate, seatingClass, passengerNo);
        return passengerNo;
    }

    @Override
    public void preferredFlightListView(String ticketId, List<Flight> flightList, int passengerCount) {
        for(Flight flight: flightList){
            System.out.println(flight);
        }

        System.out.print("Enter flight number: ");
        String flightNumber = scanner.nextLine();
        System.out.print("Enter seating class: ");
        String seatClass = scanner.nextLine();

        ticketingController.createSeat(ticketId, flightNumber, seatClass, passengerCount);
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