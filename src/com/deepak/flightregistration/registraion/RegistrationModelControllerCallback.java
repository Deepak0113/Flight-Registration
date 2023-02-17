package com.deepak.flightregistration.registraion;

public interface RegistrationModelControllerCallback {
    void successfulRegistrationController();
    void failedRegistrationController(String message);
}
