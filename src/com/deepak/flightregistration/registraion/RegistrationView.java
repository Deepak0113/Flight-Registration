package com.deepak.flightregistration.registraion;

public class RegistrationView implements RegistrationViewCallback{
    private RegistrationController registrationController;

    RegistrationView(){
        registrationController = new RegistrationController(this);
    }
}