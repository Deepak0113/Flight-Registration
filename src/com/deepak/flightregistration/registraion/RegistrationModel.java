package com.deepak.flightregistration.registraion;

public class RegistrationModel implements RegistrationModelCallback{
    RegistrationModelControllerCallback registrationController;

    RegistrationModel(RegistrationModelControllerCallback registrationController){
        this.registrationController = registrationController;
    }
}
