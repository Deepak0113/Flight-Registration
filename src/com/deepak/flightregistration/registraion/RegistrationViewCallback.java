package com.deepak.flightregistration.registraion;

public interface RegistrationViewCallback {
    void successfulRegistration();
    void failedRegistration(String message);
}
