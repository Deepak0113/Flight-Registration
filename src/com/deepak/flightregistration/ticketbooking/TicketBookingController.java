package com.deepak.flightregistration.ticketbooking;

public class TicketBookingController implements TicketBookingViewControllerCallback, TicketBookingModelControllerCallback{
    private TicketBookingViewCallback ticketBookingView;
    private TicketBookingModelCallback ticketBookingModel;

    TicketBookingController(TicketBookingViewCallback ticketBookingView){
        this.ticketBookingView = ticketBookingView;
        ticketBookingModel = new TicketBookingModel(this);
    }

    @Override
    public void chooseOption(int option) {
        switch (option){
            case 1:
                ticketBookingView.getUserPreference();
                break;
            default:
                ticketBookingView.selectValidOptionWarning();
        }
    }

    @Override
    public void filterUsingPreference(String preferredDeparture, String preferredDestination, String preferredDate, String preferredSeatingClass, int preferredTotalPassengers) {
        ticketBookingModel.filterUsingPreferenceDB(preferredDeparture, preferredDestination, preferredDate, preferredSeatingClass, preferredTotalPassengers);
    }
}
