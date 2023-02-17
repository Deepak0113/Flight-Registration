package com.deepak.flightregistration.registraion;

import java.util.Scanner;

public class RegistrationView implements RegistrationViewCallback{
    private final Scanner scanner = new Scanner(System.in);
    private RegistrationViewControllerCallback registrationController;

    public RegistrationView(){
        registrationController = new RegistrationController(this);
    }

    public void startRegistration(){
        getRegistrationDetails();
    }

    private void getRegistrationDetails(){
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter email: ");
        String email = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        registrationController.userRegistration(username, email, password);
    }

    @Override
    public void successfulRegistration() {
        System.out.println("Successfully registered!");
    }

    @Override
    public void failedRegistration(String message) {
        System.out.println("Registration failed: " + message);
        startRegistration();
    }
}