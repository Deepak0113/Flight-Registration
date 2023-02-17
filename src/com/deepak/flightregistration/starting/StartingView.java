package com.deepak.flightregistration.starting;

import com.deepak.flightregistration.adminlogin.AdminLoginView;
import com.deepak.flightregistration.registraion.RegistrationView;
import com.deepak.flightregistration.userlogin.UserLoginView;

import java.util.Scanner;

public class StartingView implements StartingViewCallback {
    private final Scanner scanner = new Scanner(System.in);
    private StartingController startingController;

    StartingView() {
        startingController = new StartingController(this);
    }

    public static void main(String[] args) {
        StartingView startingView = new StartingView();
        startingView.getUserAuth();
    }

    private void getUserAuth(){
        System.out.println("\nUser Auth");
        System.out.println("1. User login");
        System.out.println("2. Admin login");
        System.out.println("3. Registration");
        System.out.println("9. Exit");
        System.out.print("Enter option");
        int option = Integer.parseInt(scanner.nextLine());

        startingController.selectOption(option);
    }

    @Override
    public void gotoAdminLogin() {
        AdminLoginView adminLogin = new AdminLoginView();
        adminLogin.startAdminLogin();
    }

    @Override
    public void gotoUserLogin() {
        UserLoginView userLoginView = new UserLoginView();
        userLoginView.startUserLogin();
    }

    @Override
    public void gotoRegistration() {
        RegistrationView registrationView = new RegistrationView();
        registrationView.startRegistration();
    }

    @Override
    public void exitSystem() {
        System.out.println("\nThank you for visiting!!");
        System.exit(0);
    }

    @Override
    public void optionInvalidSelection() {
        System.out.println("\nInvalid option. Select existing option");
    }
}