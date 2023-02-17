package com.deepak.flightregistration.starting;

public class StartingController implements StartingViewControllerCallback, StartingModelControllerCallback {
    private StartingViewCallback startingView;
    private StartingModelCallback startingModel;

    StartingController(StartingViewCallback startingView) {
        this.startingView = startingView;
        startingModel = new StartingModel(this);
    }

    @Override
    public void selectOption(int option) {
        switch (option) {
            case 1 -> startingView.gotoUserLogin();
            case 2 -> startingView.gotoAdminLogin();
            case 3 -> startingView.gotoRegistration();
            case 9 -> startingView.exitSystem();
            default -> startingView.optionInvalidSelection();
        }
    }
}