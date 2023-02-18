package com.deepak.flightregistration.userlogin;

import com.deepak.flightregistration.dto.User;
import com.deepak.flightregistration.starting.StartingView;

import java.util.Scanner;

public class UserLoginView implements UserLoginViewCallback {
    private final Scanner scanner = new Scanner(System.in);
    private final UserLoginViewControllerCallback userLoginController;

    public UserLoginView(){
        userLoginController = new UserLoginController(this);
    }

    public static void main(String[] args) {
        UserLoginView adminLoginView = new UserLoginView();
        adminLoginView.startUserLogin();
    }


    /*------ Navigation ------*/

    public void startUserLogin(){
        System.out.println("1. continue with login");
        System.out.println("2. go to start");
        System.out.println("9. exit");
        System.out.print("Enter option: ");
        int option = Integer.parseInt(scanner.nextLine());

        userLoginController.selectOption(option);
    }

    @Override
    public void gotoStart() {
        StartingView startingView = new StartingView();
        startingView.startStartingView();
    }

    @Override
    public void invalidOption() {
        System.out.println("Invalid option.");
        startUserLogin();
    }


    /*------ User Login ------*/

    @Override
    public void getUserLoginDetails(){
        System.out.print("Enter username: ");
        String userName = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        userLoginController.userLogin(userName, password);
    }

    @Override
    public void userLoginSuccessfulView(User user) {
        System.out.println("Logged in successfully");
    }

    @Override
    public void userLoginFailedView(String errorMessage) {
        System.out.println("Login failed: " + errorMessage);
    }
}
