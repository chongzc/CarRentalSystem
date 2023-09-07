package TestRun;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        boolean isVerified = false;
        Scanner scanner = new Scanner(System.in);

        while (!isVerified) {
            System.out.print("Welcome to Car Rental System\n");
            System.out.print("Enter username: ");
            String enteredUsername = scanner.nextLine();
            System.out.print("Enter password: ");
            String enteredPassword = scanner.nextLine();

            if (enteredUsername.equals(User.getUsername()) && enteredPassword.equals(User.getPassword())) {
                isVerified = true;
                System.out.println("Login successfully!\n");
            } else {
                System.out.println("Wrong username or password! Try again.");
            }
        }//login and verification

        if (isVerified) {//when login session been verified 
            Menu.MainMenu();//show the main menu from Menu class
            int mainMenuChoice = scanner.nextInt();
            scanner.nextLine();

            switch (mainMenuChoice) {
                case 1:
                    CarManager();
                    break;
                case 2:
                    Booking();
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
        
        scanner.close();
    }

    public static void CarManager() {
        ArrayList<CarManager> cars = new ArrayList<CarManager>();
        Scanner input = new Scanner(System.in);
        String relativeFilePath = "car.txt";
        String workingDirectory = System.getProperty("user.dir");
        String absoluteFilePath = workingDirectory + File.separator + relativeFilePath;

        File1 carFileManager = new File1(absoluteFilePath);

        try {
            carFileManager.loadFromFile();
            cars = carFileManager.getListOfCars(); 
        } catch (IOException e) {
            System.out.println("Error loading data from file: " + e.getMessage());
        }

        boolean continueManagingCars = true;

        while (continueManagingCars) {
            Menu.CarMenu();

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    CarManager.addCar(input, cars, carFileManager);
                    break;
                case 2:
                    File1.displayCars(absoluteFilePath);
                    break;
                case 3:
                    CarManager.removeCar(input, cars, carFileManager);
                    break;
                case 4:
                    continueManagingCars = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }

        input.close();

        carFileManager.setListOfCars(cars); 
        try 
        {
            carFileManager.saveToFile(); 
        } catch (IOException e) 
        {
            System.out.println("Error saving data to file: " + e.getMessage());
        }
    }
    
    public static void Booking() {
    	Scanner scanner = new Scanner(System.in);
    	Menu.BookingMenu();
    	
		int BookingMenuChoice = scanner.nextInt();
        scanner.nextLine();

        switch (BookingMenuChoice) {
            case 1:
                RentCar();
                break;
            case 2:
                CancelBooking();
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
                break;
        }
    	
    }
        
    public static void RentCar() {
    	Scanner scanner = new Scanner(System.in);
    	
    	//customer's details
    	System.out.println("Enter customer's name:");
    	String customerName = scanner.nextLine();
    	System.out.println("Enter customer I/C number:");
    	String customerIC = scanner.nextLine();
    	System.out.println("Enter customer contact number:");
    	int customerContact = scanner.nextInt();
    	System.out.println("Enter customer license:");
    	String customerLicense = scanner.nextLine();
    	scanner.nextLine();
    	
    	//duratjtion 
    	System.out.println("Enter rental start time(YYYY-MM-DD:");
    	String startRenting = scanner.nextLine();
    	System.out.println("Renting duration(day):");
    	int RentingDuration = scanner.nextInt();
    	
    	
    	
    	
    	System.out.println("The car had been successful rented");//x yet finish
        }

    public static void CancelBooking() {
            System.out.println("Booking had been canceled");//x yet finish
        }
}
