import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BookingManagement 
{
    private ArrayList<Customer> customers;
    public long durationInDays;
    public String startBook;
    public String endBook;
    
    public BookingManagement() {
        customers = new ArrayList<>();
    }

    public void registerCustomer(String customerName, String customerIC, String customerContact, String customerLicense) {
        Customer customer = new Customer(customerName, customerIC, customerContact, customerLicense);
        customers.add(customer);
        System.out.println("Customer registered successfully!");
    }

    public ArrayList<Customer> getAllCustomers() {
        return customers;
    }

    public void registerCustomer() {
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
    
    public void calculateDateDuration() {
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
    
    public static void RentCar() {
        Scanner scanner = new Scanner(System.in);

        //customer's details
        System.out.println("Enter customer's name:");
        String customerName = scanner.nextLine();
        System.out.println("Enter customer I/C number:");
        String customerIC = scanner.nextLine();
        System.out.println("Enter customer contact number:");
        int customerContact = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter customer license:");
        String customerLicense = scanner.nextLine();
        // ...
        System.out.println("The car has been successfully rented.");
    }

    public static void CancelBooking() {
        System.out.println("Booking has been canceled.");
    }
}
