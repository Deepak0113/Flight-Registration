package com.deepak.flightregistration.ticketing;

import com.deepak.flightregistration.dto.Ticket;

import java.util.List;

public interface TicketingModelControllerCallback {
    void cancelTicketSuccessful();
    void cancelTicketFailed(String errorMessage);

    void viewBookedTicketsSuccessful(List<Ticket> ticketList);
    void viewBookedTicketsEmpty();
}