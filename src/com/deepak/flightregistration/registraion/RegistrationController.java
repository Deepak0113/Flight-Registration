package com.deepak.flightregistration.registraion;

public class RegistrationController implements RegistrationViewControllerCallback, RegistrationModelControllerCallback{
    private RegistrationViewCallback registrationView;
    private RegistrationModelCallback registrationModel;

    RegistrationController(RegistrationViewCallback registrationView){
        this.registrationView = registrationView;
        registrationModel = new RegistrationModel(this);
    }
}
