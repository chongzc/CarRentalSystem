import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BookingManagement 
{
    public static  ArrayList<Customer> customers;
    public static  long durationInDays;
    public static  String startBook;
    public static  String endBook;
    
    public BookingManagement() {
        customers = new ArrayList<>();
    }

    public static void registerCustomer(String customerName, String customerIC, String customerContact, String customerLicense) {
        Customer customer = new Customer(customerName, customerIC, customerContact, customerLicense);
        customers.add(customer);
    }

    public ArrayList<Customer> getAllCustomers() {
        return customers;
    }
    
    public String getStartBook()
    {
    	return startBook;
    }
    
    public String getEndBook()
    {
    	return endBook;
    }
    
    

    public static void registerCustomer() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Customer Registration");

        // Prompt the user for customer details
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter customer IC: ");
        String customerIC = scanner.nextLine();

        System.out.print("Enter customer contact: ");
        String customerContact = scanner.nextLine();

        System.out.print("Enter customer license: ");
        String customerLicense = scanner.nextLine();

        // Register the customer with the entered details
        registerCustomer(customerName, customerIC, customerContact, customerLicense);

        System.out.println("Customer registered successfully!");
    }
    
    public static void getDateDuration() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the date start booking (dd/mm/yyyy): ");
        String startBook = scanner.nextLine();

        System.out.print("Enter the date end booking (dd/mm/yyyy): ");
        String endBook = scanner.nextLine();

        // Define the date format pattern
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("d/M/yyyy");

        // Check if the input date strings have single-digit days or months and add leading zeros if needed
        String[] startParts = startBook.split("/");
        String[] endParts = endBook.split("/");
        
        if (startParts[0].length() == 1) {
            startParts[0] = "0" + startParts[0];
        }
        if (startParts[1].length() == 1) {
            startParts[1] = "0" + startParts[1];
        }
        if (endParts[0].length() == 1) {
            endParts[0] = "0" + endParts[0];
        }
        if (endParts[1].length() == 1) {
            endParts[1] = "0" + endParts[1];
        }

        // Reconstruct the corrected date strings
        startBook = String.join("/", startParts);
        endBook = String.join("/", endParts);

        // Parse the input into LocalDate objects using the specified format
        LocalDate date1 = LocalDate.parse(startBook, inputFormatter);
        LocalDate date2 = LocalDate.parse(endBook, inputFormatter);

        // Calculate the duration between the two dates in days
        long durationInDays = Math.abs(date1.toEpochDay() - date2.toEpochDay());

        // Define the date format pattern for displaying the result
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Display the result with the new format
        System.out.println("Duration between the two dates: " + outputFormatter.format(date1) +
                " and " + outputFormatter.format(date2) + " is " + durationInDays + " days");

        scanner.close();
    }

    public static void checkAvailability(Scanner input, ArrayList<CarManager> cars) {
        System.out.print("Enter car model (Press Enter to skip): ");
        String searchModel = input.nextLine().trim();
        System.out.print("Enter number of seats (Press Enter to skip): ");
        String seatsInput = input.nextLine().trim();

        // List available cars matching the search criteria
        ArrayList<CarManager> availableCars = new ArrayList<>();
        for (CarManager car : cars) {
            if (car.getStatus().equalsIgnoreCase("Available") &&
                (searchModel.isEmpty() || car.getModel().equalsIgnoreCase(searchModel)) &&
                (seatsInput.isEmpty() || Integer.toString(car.getSeats()).equals(seatsInput))) {
                availableCars.add(car);
            }
        }

        if (availableCars.isEmpty()) {
            System.out.println("No matching available cars found.");
        }

        System.out.println("Available cars:");
        System.out.println("----------------------------------------------------");
        System.out.printf("%-15s || %-20s || %-15s%n", "Car Plate No", "Car Model", "Payment Rate");
        System.out.println("----------------------------------------------------");
        for (CarManager car : availableCars) {
            System.out.printf("%-15s || %-20s || %-15.2f%n", car.getPlateno(), car.getModel(), car.getRate());
        }
    }    

    public static void CancelBooking() {
        System.out.println("Booking has been canceled.");
    }
}
