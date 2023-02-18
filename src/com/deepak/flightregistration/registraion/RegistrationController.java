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



    /*------ Navigation ------*/

    @Override
    public void selectOption(int option) {
        switch (option){
            case 1 -> registrationView.getRegistrationDetails();
            case 2 -> registrationView.gotoStart();
            case 9 -> System.exit(0);
        }
    }

    /*------ Registration ------*/

    @Override
    public void userRegistration(String userName, String email, String password) {
        registrationModel.userRegisterDB(userName, email, password);
    }

    @Override
    public void userRegistrationSuccessful() {
        registrationView.userRegistrationSuccessful();
    }

    @Override
    public void userRegistrationFailed(String errorMessage) {
        registrationView.userRegistrationFailed(errorMessage);
    }
}
