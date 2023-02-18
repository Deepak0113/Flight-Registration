package com.deepak.flightregistration.registraion;

import com.deepak.flightregistration.repository.Repository;
import com.deepak.flightregistration.status.UserStatusCalls;

public class RegistrationModel implements RegistrationModelCallback{
    RegistrationModelControllerCallback registrationController;

    RegistrationModel(RegistrationModelControllerCallback registrationController){
        this.registrationController = registrationController;
    }

    @Override
    public void userRegisterDB(String userName, String email, String password) {
        UserStatusCalls message = Repository.getInstance().registerUser(userName, email, password);

        switch (message.getStatus()){
            case "SUCCESS" -> registrationController.userRegistrationSuccessful();
            case "EXIST" -> registrationController.userRegistrationFailed("ACCOUNT ALREADY EXIST");
        }
    }
}
