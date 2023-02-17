package com.deepak.flightregistration.registraion;

public class RegistrationController implements RegistrationViewControllerCallback, RegistrationModelControllerCallback{
    private RegistrationViewCallback registrationView;
    private RegistrationModelCallback registrationModel;

    RegistrationController(RegistrationViewCallback registrationView){
        this.registrationView = registrationView;
        registrationModel = new RegistrationModel(this);
    }

    @Override
    public void successfulRegistrationController() {
        registrationView.successfulRegistration();
    }

    @Override
    public void failedRegistrationController(String message) {
        registrationView.failedRegistration(message);
    }

    @Override
    public void userRegistration(String userName, String email, String password) {
        registrationModel.userRegisterDB(userName, email, password);
    }
}
