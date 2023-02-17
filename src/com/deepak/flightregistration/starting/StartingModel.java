package com.deepak.flightregistration.starting;

public class StartingModel implements StartingModelCallback {
    StartingModelControllerCallback startingController;

    StartingModel(StartingModelControllerCallback startingController) {
        this.startingController = startingController;
    }
}