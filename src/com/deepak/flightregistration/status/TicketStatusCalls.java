package com.deepak.flightregistration.status;

import com.deepak.flightregistration.dto.Ticket;

import java.util.List;

public class TicketStatusCalls {
    String status;
    Ticket ticket;
    List<Ticket> ticketList;

    public TicketStatusCalls(String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }
}
