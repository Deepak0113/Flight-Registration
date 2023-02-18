package com.deepak.flightregistration.ticketing;

import com.deepak.flightregistration.repository.Repository;
import com.deepak.flightregistration.status.TicketStatusCalls;

public class TicketingModel implements TicketingModelCallback {
    TicketingModelControllerCallback ticketingController;

    TicketingModel(TicketingModelControllerCallback ticketingController) {
        this.ticketingController = ticketingController;
    }

    /*------ Ticket Booking ------*/

    @Override
    public String createNewTicket() {
        return Repository.getInstance().createNewTicket();
    }

    @Override
    public void createPassenger(String ticketId, String name, String email, String gender, String phoneNumber, String nationality, String aadhaarID) {
        Repository.getInstance().createPassenger(ticketId, name, email, gender, phoneNumber, nationality, aadhaarID);
    }

    /*------ Ticket Cancellation ------*/

    @Override
    public void cancelTicketDB(String ticketId) {
        TicketStatusCalls ticketStatusCalls = Repository.getInstance().cancelTicket(ticketId);

        switch (ticketStatusCalls.getStatus()){
            case "SUCCESS" -> ticketingController.cancelTicketSuccessful();
            case "NOT EXIST" -> ticketingController.cancelTicketFailed("Ticket doesn't exists");
        }
    }


    /*------ View Ticket ------*/

    @Override
    public void viewTicketDB() {
        TicketStatusCalls ticketStatusCalls = Repository.getInstance().viewTicket();

        switch (ticketStatusCalls.getStatus()){
            case "SUCCESS" -> ticketingController.viewBookedTicketsSuccessful(ticketStatusCalls.getTicketList());
            case "EMPTY" -> ticketingController.viewBookedTicketsEmpty();
        }
    }
}