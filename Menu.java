import java.io.File;
import java.io.IOException;
import java.util.*;

public class Menu {
	
	public static void Login(){
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
	}
	
	public static void MainMenu() {
        System.out.println( "Main Menu");
        System.out.println( "1 - Car Menu");
        System.out.println( "2 - Booking");
        System.out.println( "0 - Exit");
        System.out.print  ( "Your choice: ");
    }
	
	public static void displayCarMenu() {
        System.out.println( "Car Menu");
        System.out.println( "1 - Add a car");
        System.out.println( "2 - Display cars");
        System.out.println( "3 - Remove a car");
        System.out.println( "4 - Search a car");
        System.out.println( "5 - Update Car Status");     
        System.out.println( "6 - Quit");
        System.out.print  ( "Your choice: ");
    }
	
    public static void CarMenu(Scanner scanner) {
        ArrayList<CarManager> cars = new ArrayList<CarManager>();
        String relativeFilePath = "car.txt";
        String workingDirectory = System.getProperty("user.dir");
        String absoluteFilePath = workingDirectory + File.separator + relativeFilePath;

        FileManagement carFileManager = new FileManagement(absoluteFilePath);

        try {
            carFileManager.loadFromFile();
            cars = carFileManager.getListOfCars();
        } catch (IOException e) {
            System.out.println("Error loading data from file: " + e.getMessage());
        }

        boolean continueManagingCars = true;

        while (continueManagingCars) {
            Menu.displayCarMenu();

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    CarManager.addCar(scanner, cars, carFileManager);
                    break;
                case 2:
                    CarManager.displayCars(absoluteFilePath);
                    break;
                case 3:
                    CarManager.removeCar(scanner, cars, carFileManager);
                    break;
                case 4:
                    CarManager.searchCar(scanner, cars);
                    break;
                case 5:
                    CarManager.updateStatus(scanner, cars); // Update Car Status
                    break;
                case 6:
                    continueManagingCars = false;
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }

        carFileManager.setListOfCars(cars);
        try {
            carFileManager.saveToFile();
        } catch (IOException e) {
            System.out.println("Error saving data to file: " + e.getMessage());
        }

    }
	
	public static void displayBookingMenu() {
        System.out.println( "Booking Menu");
        System.out.println( "1 - Rent a car");
        System.out.println( "2 - Cancel booking");
        System.out.println( "3 - Quit");
        System.out.print  ( "Your choice: ");
    }
	
    public static void BookingMenu(Scanner scanner) {
    	BookingManagement.customers = new ArrayList<Customer>();
    	BookingManagement.registerCustomer();
    	BookingManagement.getDateDuration();
    	
    }
	

	

}
