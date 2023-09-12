package CarRentalSystem;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Menu {
	
	public static void Login(){//for admin to login into the system
		boolean isVerified = false;
	        Scanner scanner = new Scanner(System.in);

	        while (!isVerified) {
		    System.out.println("-----------------------------------------");
	            System.out.println("|     Welcome to Car Rental System      |");
		    System.out.println("-----------------------------------------"); //display banner
	            System.out.print("Enter username: ");
	            String enteredUsername = scanner.nextLine();
	            System.out.print("Enter password: ");
	            String enteredPassword = scanner.nextLine();

	            if (enteredUsername.equals(User.getUsername()) && enteredPassword.equals(User.getPassword())) {
	                isVerified = true;
	                System.out.println("Login successfully!\n");//if username and password correct, login successful ,exit while loop
	            } else {
	                System.out.println("Wrong username or password! Try again.\n");//login fail, back into while loop
	            }
	        }
	}
	
	public static void MainMenu() {//to show the main menu
        System.out.println( "\nMain Menu");
        System.out.println( "1 - Car Menu");
        System.out.println( "2 - Booking");
        System.out.println( "3 - Pickup & Return");
        System.out.println( "4 - View History");
        System.out.println( "5 - Quit");
        System.out.print  ( "Your choice: ");
    }
	
	public static void displayCarMenu() {//to show the Car Menu
        System.out.println( "\nCar Menu");
        System.out.println( "1 - Add a car");
        System.out.println( "2 - Display cars");
        System.out.println( "3 - Remove a car");
        System.out.println( "4 - Search a car");
        System.out.println( "5 - Update Car Status");     
        System.out.println( "6 - Quit");
        System.out.print  ( "Your choice: ");
    }
			
	public static void displayBookingMenu() {//to show the Booking Menu
        System.out.println( "\nBooking Menu");
        System.out.println( "1 - Check Availability");
        System.out.println( "2 - Rent a car");
        System.out.println( "3 - Check Booking Details");
        System.out.println( "4 - Cancel Booking");
        System.out.println( "5 - Quit");
        System.out.print  ( "Your choice: ");
    }
	
	public static void displayHistoryMenu() {//to show the History Menu
        System.out.println( "\nHistory Menu");
        System.out.println( "1 - View Booking History");
        System.out.println( "2 - View Payment History");
        System.out.println( "3 - Quit");
        System.out.print  ( "Your choice: ");
    }
	public static void displayPickupReturnMenu() {//to show the Return Menu
        System.out.println( "\nPickup and Return");
        System.out.println( "1 - Pickup");
        System.out.println( "2 - Return");
        System.out.println( "3 - Quit");
        System.out.print  ( "Your choice: ");
	}

}
