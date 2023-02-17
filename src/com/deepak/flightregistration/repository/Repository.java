package com.deepak.flightregistration.repository;

import com.deepak.flightregistration.dto.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Repository {
    private static Repository repository;
    private List<Credentials> adminTable;
    private List<Credentials> userTable;
    private List<Flight> flightsTable;
    private List<Passenger> passengerList;
    private List<Ticket> ticketList;

    public static Repository getInstance(){
        if(repository == null){
            repository = new Repository();
            repository.initSetup();
        }

        return repository;
    }

    private void initSetup(){
        // init
        adminTable = new ArrayList<>();
        userTable = new ArrayList<>();
        flightsTable = new ArrayList<>();
        passengerList = new ArrayList<>();
        ticketList = new ArrayList<>();

        // hard coded admin credentials
        adminTable.add(new Credentials("admin", "admin@gmail.com" , "admin"));
        adminTable.add(new Credentials("deepakm", "deepakm@gmail.com" , "deepakm"));

        // hard coded user credentials
        userTable.add(new Credentials("deepakm", "deepakm0113@gmail.com", "deepakm"));

        // hard coded flight details
        flightsTable.add(new Flight("BA3423", "Air Asia", "Chennai", "Mumbai", "12/02/2003", "13/02/2003", "Business", 500));
        flightsTable.add(new Flight("BA3424", "Air Asia", "Chennai", "Bangalore", "12/02/2003", "13/02/2003", "Business", 500));
        flightsTable.add(new Flight("BA3425", "Air Asia", "Chennai", "Mumbai", "12/02/2003", "13/02/2003", "Business", 500));
    }

    // check credentials for admin login
    public User checkValidAdmin(String userName, String password){
        for(Credentials credential: adminTable){
            if(credential.getUsername().equals(userName) && credential.getPassword().equals(password)){
                return credential;
            }
        }

        return null;
    }

    // check credentials for user login
    public User checkValidUser(String userName, String password){
        for(Credentials credential: userTable){
            if(credential.getUsername().equals(userName) && credential.getPassword().equals(password)){
                return credential;
            }
        }

        return null;
    }

    // add user to user table
    public String addUserToDB(String userName, String email, String password){
        if(isUserExist(email)){
            return "Already Exists";
        }

        userTable.add(new Credentials(userName, email, password));
        return "Successful";
    }

    // check user exist
    private boolean isUserExist(String email){
        for(Credentials credential: userTable){
            if(credential.getUsername().equals(email)){
                return true;
            }
        }

        return false;
    }

    // add flight to flights table
    public Flight addFlightToDB(String flightNumber, String flightName, String departure, String destination, String departureDateTime, String destinationDateTime, String seatingClass, int totalPassengers){
        Flight flight = new Flight(flightNumber, flightName, departure, destination, departureDateTime, destinationDateTime, seatingClass, totalPassengers);
        flightsTable.add(flight);
        return flight;
    }

    // all available flights
    public List<Flight> getAvailableFlightsFromDB(){
        return flightsTable;
    }

    // remove flights
    public boolean removeFlightFromDB(String flightNumber) {
        for(Flight flight: flightsTable){
            if(flight.getFlightNumber().equals(flightNumber)){
                flightsTable.remove(flight);
                return true;
            }
        }
        return false;
    }

    // search in flightTable
    public List<Flight> searchFlights(String preferredDeparture, String preferredDestination, String preferredDepartureDate, String preferredSeatingClass, int preferredTotalPassengers){
        List<Flight> filterFlight = new ArrayList<>();

        for(Flight flight: flightsTable){
            if(flight.getDeparture().equals(preferredDeparture) && flight.getDestination().equals(preferredDestination) &&
                    flight.getDepartureDateTime().equals(preferredDepartureDate) && flight.getSeatingClass().equals(preferredSeatingClass) &&
                    flight.getTotalPassengers() >= preferredTotalPassengers){
                filterFlight.add(flight);
            }
        }

        return filterFlight;
    }

    // add passengers
    public void addPassengerToDB(String name, String email, String gender, String phoneNumber, String nationality, String aadharID){
        passengerList.add(new Passenger(name, email, gender, phoneNumber, nationality, aadharID));
    }

    // get passengers
    public List<Passenger> getPassengerList(){
        return passengerList;
    }

    // get flight using flight number
    public Flight getFlight(String flightNumber){
        for(Flight flight: flightsTable){
            if(flight.getFlightNumber().equals(flightNumber)){
                return flight;
            }
        }
        return null;
    }

    // create ticket
    public String createTicket(Flight flight, List<Passenger> passengerList, int totalPrice){
        String ticketId = String.valueOf(gen());
        ticketList.add(new Ticket(ticketId, flight, passengerList.size(), passengerList, totalPrice));
        return ticketId;
    }

    // generate ticket id
    public int gen() {
        Random r = new Random( System.currentTimeMillis() );
        return 10000 + r.nextInt(20000);
    }

    public boolean cancelTicket(String ticketId) {
        for(Ticket ticket: ticketList){
            if(ticket.getTicketID().equals(ticketId)){
                ticketList.remove(ticket);
                return true;
            }
        }

        return false;
    }

    public List<Ticket> getTickets(){
        return ticketList;
    }
}
