package com.deepak.flightregistration.ticketing;

import com.deepak.flightregistration.dto.Ticket;

import java.util.List;

public interface TicketingViewCallback {
    void ticketCancellation();
    void ticketCancellationSuccessful();
    void ticketCancellationFailed(String errorMessage);

    void viewBookedTickets();
    void viewBookedTicketsSuccessful(List<Ticket> ticketList);
    void viewBookedTicketsEmpty();
}