import java.io.File;
import java.io.IOException;
import java.util.*;

public class Menu {
	
	private static ArrayList<CarManager> cars = new ArrayList<CarManager>();
    private static FileManagement carFileManager;
	
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
	        }
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
	

	public static String findPath() {
        String TextName = "car.txt";
        String workingDirectory = System.getProperty("user.dir");
        String absoluteFilePath = workingDirectory + File.separator + TextName;
        return absoluteFilePath;
    }
		
	public static void cars() {
        String filePath = findPath();
        carFileManager = new FileManagement(filePath);

        try {
            carFileManager.loadFromFile();
            cars = carFileManager.getListOfCars();
        } catch (IOException e) {
            System.out.println("Error loading data from file: " + e.getMessage());
        }
    }
	
	public static void CarMenu(Scanner scanner) {
        Menu.displayCarMenu();

        Scanner sc = new Scanner(System.in);
        int ChooseCarMenu = sc.nextInt();

        switch (ChooseCarMenu) {
            case 1:
                CarManager.addCar(scanner, cars, carFileManager); // Pass Scanner and other parameters
                break;
            case 2:
                CarManager.displayCars(findPath());
                break;
            case 3:
                CarManager.removeCar(scanner, cars, carFileManager); // Pass Scanner and other parameters
                break;
            case 4:
                CarManager.searchCar(scanner, cars); // Pass Scanner and cars ArrayList
                break;
            case 5:
                CarManager.updateStatus(scanner, cars); // Pass Scanner and cars ArrayList
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
                break;
        }
    }
	
	public static void displayBookingMenu() {
        System.out.println( "Booking Menu");
        System.out.println( "1 - Rent a car");
        System.out.println( "2 - Cancel booking");
        System.out.println( "3 - Quit");
        System.out.print  ( "Your choice: ");
    }
	
	public static void BookingMenu(Scanner scanner) 
	{
        	Scanner sc = new Scanner(System.in);
        	BookingManagement bookingManagement = new BookingManagement();

        	while (true) 
		{
            		System.out.println("Booking Menu:");
            		System.out.println("1. Rent a Car");
           		System.out.println("2. Cancel Booking");
           		System.out.println("3. Exit");
            		System.out.print("Enter your choice: ");
            		int choice = sc.nextInt();
            		sc.nextLine(); // Consume the newline character

            		switch (choice) 
	    		{
                		case 1:
                    		bookingManagement.registerCustomer();
                    		bookingManagement.getDateDuration();
                   		break;
                		case 2:
                    
                    		break;
                		case 3:
                    		bookingManagement.CancelBooking();
                    		break;
                		case 4:
                    		System.out.println("Exiting program.");
                    		scanner.close();
                    		System.exit(0);
                		default:
                    		System.out.println("Invalid choice. Please select a valid option.");
                    		break;
            		}
		}
        }	

}
