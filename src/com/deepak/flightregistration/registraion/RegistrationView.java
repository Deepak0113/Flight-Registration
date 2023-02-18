package com.deepak.flightregistration.registraion;

import com.deepak.flightregistration.starting.StartingView;

import java.util.Scanner;

public class RegistrationView implements RegistrationViewCallback{
    private final Scanner scanner = new Scanner(System.in);
    private final RegistrationViewControllerCallback registrationController;

    public RegistrationView(){
        registrationController = new RegistrationController(this);
    }

    /*------ Navigation ------*/
    public void startRegistration(){
        System.out.println("1. continue with registration");
        System.out.println("2. go to start");
        System.out.println("9. exit");
        System.out.print("Enter option: ");
        int option = Integer.parseInt(scanner.nextLine());

        registrationController.selectOption(option);
    }

    @Override
    public void gotoStart() {
        StartingView startingView = new StartingView();
        startingView.startStartingView();
    }

    /*------ User Registration ------*/

    @Override
    public void getRegistrationDetails(){
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter email: ");
        String email = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        registrationController.userRegistration(username, email, password);
    }

    @Override
    public void userRegistrationSuccessful() {
        System.out.println("Successfully registered. Login to continue");
        gotoStart();
    }

    @Override
    public void userRegistrationFailed(String errorMessage) {
        System.out.println("Registration failed: " + errorMessage);
    }
}