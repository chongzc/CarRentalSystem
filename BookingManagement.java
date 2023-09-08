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
        System.out.println("Customer registered successfully!");
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
        startBook = scanner.nextLine();

        System.out.print("Enter the date end booking (dd/mm/yyyy): ");
        endBook = scanner.nextLine();

        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Parse the input into LocalDate objects using the specified format
        LocalDate date1 = LocalDate.parse(startBook, inputFormatter);
        LocalDate date2 = LocalDate.parse(endBook, inputFormatter);

        // Calculate the duration between the two dates in days
        durationInDays = Math.abs(date1.toEpochDay() - date2.toEpochDay());

        // Define the date format pattern for displaying the result
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Display the result with the new format
        System.out.println("Duration between the two dates: " + outputFormatter.format(date1) +
                " and " + outputFormatter.format(date2) + " is " + durationInDays + " days");

        scanner.close();
    }
    
    

    public static void CancelBooking() {
        System.out.println("Booking has been canceled.");
    }
}
