package com.deepak.flightregistration.registraion;

public interface RegistrationModelControllerCallback {
    void userRegistrationSuccessful();
    void userRegistrationFailed(String errorMessage);
}
