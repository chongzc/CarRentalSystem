import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Menu.Login();
    	Scanner scanner = new Scanner(System.in);
        Menu.MainMenu();//show the main menu from Menu class
        int mainMenuChoice = scanner.nextInt();
        scanner.nextLine();
        
        switch (mainMenuChoice) {
        case 1:
    		CarManager(scanner); // Pass scanner to CarManager
            break;
        case 2:
            Booking();
            break;
        default:
            System.out.println("Invalid choice. Please select a valid option.");
            break;
        }
            scanner.close();
     }
        

    public static void CarManager(Scanner scanner) {
        ArrayList<CarManager> cars = new ArrayList<CarManager>();
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

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    CarManager.addCar(scanner, cars, carFileManager);
                    break;
                case 2:
                    File1.displayCars(absoluteFilePath);
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
                    break;
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

    public static void Booking() {
        Scanner scanner = new Scanner(System.in);
        Menu.BookingMenu();

        int BookingMenuChoice = scanner.nextInt();
        scanner.nextLine();

        switch (BookingMenuChoice) {
            case 1:
                BookingManagement.RentCar();
                break;
            case 2:
                BookingManagement.CancelBooking();
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
                break;
        }
    }

    
}
