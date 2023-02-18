package com.deepak.flightregistration.userlogin;

import com.deepak.flightregistration.dto.User;

public class UserLoginController implements UserLoginModelControllerCallback, UserLoginViewControllerCallback {
    private final UserLoginViewCallback userLoginView;
    private final UserLoginModelCallback userLoginModel;

    UserLoginController(UserLoginViewCallback userLoginView){
        this.userLoginView = userLoginView;
        userLoginModel = new UserLoginModel(this);
    }


    /*------ Navigation ------*/

    @Override
    public void selectOption(int option) {
        switch (option) {
            case 1 -> userLoginView.getUserLoginDetails();
            case 2 -> userLoginView.gotoStart();
            case 9 -> System.exit(0);
            default -> userLoginView.invalidOption();
        }
    }


    /*------ User Login ------*/

    @Override
    public void userLogin(String userName, String password){
        userLoginModel.checkCredentials(userName, password);
    }

    @Override
    public void userLoginSuccessful(User user) {
        userLoginView.userLoginSuccessfulView(user);


    }

    @Override
    public void userLoginFailed(String errorMessage) {
        userLoginView.userLoginFailedView(errorMessage);
    }
}
