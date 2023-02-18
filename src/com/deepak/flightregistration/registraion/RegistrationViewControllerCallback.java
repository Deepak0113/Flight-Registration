package com.deepak.flightregistration.registraion;

public interface RegistrationViewControllerCallback {
    void selectOption(int option);
    void userRegistration(String userName, String email, String password);
}
