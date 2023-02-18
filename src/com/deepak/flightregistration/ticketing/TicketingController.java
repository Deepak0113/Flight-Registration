package com.deepak.flightregistration.ticketing;

import com.deepak.flightregistration.dto.Ticket;

import java.util.List;

public class TicketingController implements TicketingViewControllerCallback, TicketingModelControllerCallback {
    private TicketingViewCallback ticketingView;
    private TicketingModelCallback ticketingModel;

    TicketingController(TicketingViewCallback ticketingView) {
        this.ticketingView = ticketingView;
        ticketingModel = new TicketingModel(this);
    }

    /*------ Navigation ------*/

    @Override
    public void selectOption(int option) {
        switch (option){
            case 2 -> ticketingView.ticketCancellation();
            case 9 -> System.exit(0);
        }
    }


    /*------ Cancel Ticket ------*/

    @Override
    public void cancelTicket(String ticketId) {
        ticketingModel.cancelTicketDB(ticketId);
    }

    @Override
    public void cancelTicketSuccessful() {
        ticketingView.ticketCancellationSuccessful();
    }

    @Override
    public void cancelTicketFailed(String errorMessage) {
        ticketingView.ticketCancellationFailed(errorMessage);
    }


    /*------ View Tickets ------*/

    @Override
    public void viewBookedTickets() {
        ticketingModel.viewTicketDB();
    }

    @Override
    public void viewBookedTicketsSuccessful(List<Ticket> ticketList) {
        ticketingView.viewBookedTicketsSuccessful(ticketList);
    }

    @Override
    public void viewBookedTicketsEmpty() {
        ticketingView.viewBookedTicketsEmpty();
    }
}