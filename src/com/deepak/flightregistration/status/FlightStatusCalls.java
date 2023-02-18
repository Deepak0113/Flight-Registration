package com.deepak.flightregistration.status;

import com.deepak.flightregistration.dto.Flight;

import java.util.List;

public class FlightStatusCalls {
    private String status;
    private Flight flight;
    private List<Flight> flightList;

    public FlightStatusCalls(String status) {
        this.status = status;
    }

    public String getStatus(){
        return status;
    }

    public Flight getFlight(){
        return flight;
    }

    public void setFlight(Flight flight){
        this.flight = flight;
    }

    public List<Flight> getFlightList(){
        return flightList;
    }

    public void setFlightList(List<Flight> flightList){
        this.flightList = flightList;
    }
}
