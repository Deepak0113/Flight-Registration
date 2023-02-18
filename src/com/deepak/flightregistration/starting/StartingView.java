package com.deepak.flightregistration.starting;

import com.deepak.flightregistration.adminlogin.AdminLoginView;
import com.deepak.flightregistration.registraion.RegistrationView;
import com.deepak.flightregistration.userlogin.UserLoginView;

import java.util.Scanner;

public class StartingView implements StartingViewCallback {
    private final Scanner scanner = new Scanner(System.in);
    private final StartingViewControllerCallback startingController;

    public StartingView() {
        startingController = new StartingController(this);
    }

    public static void main(String[] args) {
        StartingView startingView = new StartingView();
        startingView.startStartingView();
    }

    /*------ Navigation ------*/

    // user option auth
    public void startStartingView(){
        System.out.println("\nWelcome to FlyAround");
        System.out.println("----------------------------");
        System.out.println("1. User login");
        System.out.println("2. Admin login");
        System.out.println("3. Registration");
        System.out.println("9. Exit");
        System.out.print("Enter option: ");
        int option = Integer.parseInt(scanner.nextLine());

        startingController.selectOption(option);
    }

    // goes to admin login module
    @Override
    public void gotoAdminLogin() {
        AdminLoginView adminLogin = new AdminLoginView();
        adminLogin.startAdminLogin();
    }

    // goes to user login module
    @Override
    public void gotoUserLogin() {
        UserLoginView userLoginView = new UserLoginView();
        userLoginView.startUserLogin();
    }

    // goes to registration module
    @Override
    public void gotoRegistration() {
        RegistrationView registrationView = new RegistrationView();
        registrationView.startRegistration();
    }

    // exists the program
    @Override
    public void exitSystem() {
        System.out.println("\nThank you for visiting!!");
        System.exit(0);
    }

    // for invalid selection
    @Override
    public void optionInvalidSelection() {
        System.out.println("\nInvalid option. Select existing option");
    }
}