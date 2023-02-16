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
            flightDB.setup();
        }

        return flightDB;
    }

    private void setup(){
        flights = new ArrayList<>();
        flights.add(new Flight("BA2490", "Air Asia", "Chennai", "Bangalore", "05:00"));
        flights.add(new Flight("BA2491A", "Indigo", "Chennai", "Mumbai", "08:00"));
        flights.add(new Flight("BA2492A", "Air Asia", "Bangalore", "Chennai", "90:00"));
    }

    public Flight addFlightToDB(String flightNumber, String flightName, String departure, String destination, String departureTime){
        Flight flight = new Flight(flightNumber, flightName, departure, destination, departureTime);
        flights.add(flight);
        return flight;
    }

    public List<Flight> getAvailableFlightsFromDB(){
        return flights;
    }
}
