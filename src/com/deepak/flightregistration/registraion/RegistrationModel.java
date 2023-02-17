package com.deepak.flightregistration.registraion;

import com.deepak.flightregistration.repository.Repository;

public class RegistrationModel implements RegistrationModelCallback{
    RegistrationModelControllerCallback registrationController;

    RegistrationModel(RegistrationModelControllerCallback registrationController){
        this.registrationController = registrationController;
    }

    @Override
    public void userRegisterDB(String userName, String email, String password) {
        String message = Repository.getInstance().addUserToDB(userName, email, password);
        if(message.equals("Successful")){
            registrationController.successfulRegistrationController();
        } else{
            registrationController.failedRegistrationController(message);
        }
    }
}
