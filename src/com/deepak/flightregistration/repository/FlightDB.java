package com.deepak.flightregistration.repository;

import com.deepak.flightregistration.dto.Flight;

import java.util.ArrayList;
import java.util.List;

public class FlightDB {
    private static FlightDB flightDB;
    private List<Flight> flights;

    public static FlightDB getInstance(){
        if(flightDB == null){
            flightDB = new FlightDB();
            flightDB.initSetup();
        }

        return flightDB;
    }

    private void initSetup(){
        flights = new ArrayList<>();
        flights.add(new Flight("BA3423", "Air Asia", "Chennai", "Mumbai", "12/02/2003 15:00", "13/02/2003 20:00", "Business", 500));
        flights.add(new Flight("BA3423", "Air Asia", "Chennai", "Mumbai", "12/02/2003 15:00", "13/02/2003 20:00", "Business", 500));
        flights.add(new Flight("BA3423", "Air Asia", "Chennai", "Mumbai", "12/02/2003 15:00", "13/02/2003 20:00", "Business", 500));
    }

    public Flight addFlightToDB(String flightNumber, String flightName, String departure, String destination, String departureDateTime, String destinationDateTime, String seatingClass, int totalPassengers){
        Flight flight = new Flight(flightNumber, flightName, departure, destination, departureDateTime, destinationDateTime, seatingClass, totalPassengers);
        flights.add(flight);
        return flight;
    }

    public List<Flight> getAvailableFlightsFromDB(){
        return flights;
    }

    public boolean removeFlightFromDB(String flightNumber) {
        for(Flight flight: flights){
            if(flight.getFlightNumber().equals(flightNumber)){
                flights.remove(flight);
                return true;
            }
        }
        return false;
    }

    public List<Flight> searchFlights(String preferredDeparture, String preferredDestination, String preferredDepartureDate, String preferredSeatingClass, int preferredTotalPassengers){
        List<Flight> filterFlight = new ArrayList<>();

        for(Flight flight: flights){
            if(flight.getDeparture().equals(preferredDeparture) && flight.getDestination().equals(preferredDestination) &&
            flight.getDepartureDateTime().equals(preferredDepartureDate) && flight.getSeatingClass().equals(preferredSeatingClass) &&
            flight.getTotalPassengers() >= preferredTotalPassengers){
                filterFlight.add(flight);
            }
        }

        return filterFlight;
    }
}
