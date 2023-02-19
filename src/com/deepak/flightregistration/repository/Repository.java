package com.deepak.flightregistration.repository;

import com.deepak.flightregistration.dto.*;
import com.deepak.flightregistration.status.FlightStatusCalls;
import com.deepak.flightregistration.status.TicketStatusCalls;
import com.deepak.flightregistration.status.UserStatusCalls;

import java.util.*;

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
        flightsTable.add(new Flight("BA3423", "Air Asia", "Chennai", "Mumbai", new Date("02/20/2014 15:00:00"),  new Date("02/21/2014 15:00:00"), new String[]{"Economy", "Business"}, new int[]{1000, 2000}, 50, 20, 1500));
        flightsTable.add(new Flight("BA3424", "Air Asia", "Chennai", "Bangalore", new Date("02/20/2014 15:00:00"),  new Date("02/21/2014 15:00:00"), new String[]{"Economy", "Business"}, new int[]{1000, 2000}, 50, 20, 1500));
        flightsTable.add(new Flight("BA3425", "Air Asia", "Chennai", "Mumbai",  new Date("02/20/2014 15:00:00"),  new Date("02/21/2014 15:00:00"), new String[]{"Economy", "Business"}, new int[]{1000, 2000}, 50, 20, 1500));
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

    public List<Ticket> getTickets(){
        return ticketList;
    }


    /*------ User Table ------*/

    // user login
    public UserStatusCalls checkValidUser(String userName, String password){
        UserStatusCalls userStatusCalls = new UserStatusCalls("SUCCESS");

        for(Credentials credentials: userTable){
            if(credentials.getUsername().equals(userName)){
                if(credentials.getPassword().equals(password)){
                    User user = credentials;
                    userStatusCalls.setUser(user);
                    return userStatusCalls;
                }
                return new UserStatusCalls("PASSWORD NOT MATCH");
            }
        }

        return new UserStatusCalls("NOT EXISTS");
    }

    // register user
    public UserStatusCalls registerUser(String userName, String emailid, String password){
        UserStatusCalls userStatusCalls = new UserStatusCalls("SUCCESS");

        for(Credentials credentials: userTable){
            if(credentials.getUsername().equals(userName)){
                return new UserStatusCalls("EXIST");
            }
        }

        Credentials cred = new Credentials(userName, emailid, password);
        User user = cred;

        userStatusCalls.setUser(user);
        return userStatusCalls;
    }


    /*----- Flight Table -----*/

    // add flight to flights table
    public FlightStatusCalls addFlightToDB(String flightNumber, String name, String departure, String destination, Date departureDateTime, Date destinationDateTime, String[] seatingClasses, int[] seatingClassesPrices, int totalSeats, int reservedSeats, int reservationPrice){
        Flight addFlight = new Flight(flightNumber, name, departure, destination, departureDateTime, destinationDateTime, seatingClasses, seatingClassesPrices, totalSeats, reservedSeats, reservationPrice);
        FlightStatusCalls flightStatusCalls = new FlightStatusCalls("SUCCESS");

        for(Flight flight: flightsTable){
            if(flight.getFlightNumber().equals(flightNumber)){
                return new FlightStatusCalls("EXISTS");
            }
        }

        flightsTable.add(addFlight);
        flightStatusCalls.setFlight(addFlight);
        return flightStatusCalls;
    }

    // get all available flights
    public FlightStatusCalls getAvailableFlightsFromDB(){
        FlightStatusCalls flightStatusCalls = new FlightStatusCalls("SUCCESS");

        if(flightsTable.size() == 0){
            return new FlightStatusCalls("EMPTY");
        }

        flightStatusCalls.setFlightList(flightsTable);
        return flightStatusCalls;
    }

    // remove flight details from flightsTable
    public FlightStatusCalls removeFlightFromDB(String flightNumber){
        FlightStatusCalls flightStatusCalls = new FlightStatusCalls("SUCCESS");

        for(Flight flight: flightsTable){
            if(flight.getFlightNumber().equals(flightNumber)){
                flightsTable.remove(flight);
                flightStatusCalls.setFlight(flight);
                return flightStatusCalls;
            }
        }

        return new FlightStatusCalls("NOT EXIST");
    }

    // get flight details
    public FlightStatusCalls getFlightDetails(String flightNumber){
        FlightStatusCalls flightStatusCalls = new FlightStatusCalls("SUCCESS");

        for(Flight flight: flightsTable){
            if(flight.getFlightNumber().equals(flightNumber)){
                flightStatusCalls.setFlight(flight);
                return flightStatusCalls;
            }
        }

        return new FlightStatusCalls("INVALID");
    }

    public List<Flight> getPreferredFlights(String departure, String destination, Date departureDate, String seatingClass, int passengerNo){
        List<Flight> preferred = new ArrayList<>();

        for(Flight flight: flightsTable){
            if(flight.getDeparture().equals(departure) &&
                    flight.getDestination().equals(destination) &&
                    flight.getAvailableSeats() >= passengerNo &&
                    Arrays.asList(flight.getSeatingClasses()).contains(seatingClass) &&
                    flight.getDepartureDateTime().compareTo(departureDate)==0){
                preferred.add(flight);
            }
        }

        return preferred;
    }

    public void createSeat(String ticketId, String flightNumber, String seatClass, int passengerCount){
        Flight flight = null;
        Ticket ticket = null;

        for (Flight currFlight: flightsTable){
            if(currFlight.getFlightNumber().equals(flightNumber)){
                flight = currFlight;
                break;
            }
        }

        for (Ticket currTicket: ticketList){
            if(currTicket.getTicketID().equals(ticketId)){
                ticket = currTicket;
                break;
            }
        }

        if(flight == null) return;

        List<Seat> seatList = new ArrayList<>();
        int[] seats = flight.getSeats();
        for(int i=0; i<passengerCount; i++){
            for(int j=0; j<seats.length; j++){
                if(seats[j] == 0){
                    int ind=0;
                    for(String seatC: flight.getSeatingClasses()){
                        if(seatC.equals(seatClass)){
                            int cost = flight.getSeatingClassesPrices()[ind];
                            Seat seat = new Seat(flightNumber, j, seatClass, cost);
                            seatList.add(seat);
                            ticket.setTotalPrice(ticket.getTotalPrice()+cost);
                        }
                        ind++;
                    }
                    seats[j] = 1;
                    flight.setAvailableSeats(flight.getAvailableSeats()-1);

                }
            }
        }

        flight.setSeats(seats);
        assert ticket != null;
        ticket.setSeat(seatList);
    }


    /*----- Ticket Table -----*/

    public TicketStatusCalls cancelTicket(String ticketId){
        for(Ticket ticket: ticketList){
            if(ticket.getTicketID().equals(ticketId)){
                ticketList.remove(ticket);
                return new TicketStatusCalls("SUCCESS");
            }
        }

        return new TicketStatusCalls("NOT EXIST");
    }

    public TicketStatusCalls viewTicket(){
        TicketStatusCalls ticketStatusCalls = new TicketStatusCalls("SUCCESS");

        if(ticketList.size()==0){
            return new TicketStatusCalls("EMPTY");
        }

        ticketStatusCalls.setTicketList(ticketList);
        return ticketStatusCalls;
    }

    public String createNewTicket(){
        int rand = (int) (Math.random() * (99999-10000+1) + 10000);
        String ticketId = String.valueOf(rand);
        Ticket ticket = new Ticket(ticketId);
        ticketList.add(ticket);

        return ticketId;
    }

    public float getTotalCostOfTicket(String ticketId){
        float totalCost = 0;
        System.out.println(ticketId);

        for(Ticket ticket: ticketList){
            if(ticket.getTicketID().equals(ticketId)){
                return ticket.getTotalPrice();
            }
        }

        return 50000;
    }


    /*------ Passenger Table ------*/

    public void createPassenger(String ticketId, String name, String email, String gender, String phoneNumber, String nationality, String aadhaarID){
        for(Ticket ticket: ticketList){
            if(ticket.getTicketID().equals(ticketId)){
                Passenger passenger = new Passenger(name, email, gender, phoneNumber, nationality, aadhaarID);

                List<Passenger> passengerList = ticket.getPassengerList() == null ? new ArrayList<>() : ticket.getPassengerList();
                passengerList.add(passenger);

                ticket.setPassengerList(passengerList);
            }
        }
    }
}
