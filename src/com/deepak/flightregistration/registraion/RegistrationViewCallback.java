package com.deepak.flightregistration.registraion;

public interface RegistrationViewCallback {

    void getRegistrationDetails();
    void gotoStart();

    void userRegistrationSuccessful();
    void userRegistrationFailed(String errorMessage);
}
