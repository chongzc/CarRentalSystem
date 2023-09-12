import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


public class BookingManagement implements Continuity{
    private static String customerName;
    private static String icNumber;
    private static String contactInfo;
    private static String licenseInfo;
    private static String startDate;
    private static String endDate;
    private static long durationInDays;
    private static String rentCarNo;
    private static String rentCarModel;
    private static double rentCarPay;

    public BookingManagement(String customerName, String icNumber, String contactInfo, String licenseInfo, String startDate, String endDate, long durationInDays, String rentCarNo, double rentCarPay) {
        this.customerName = customerName;
        this.icNumber = icNumber;
        this.contactInfo = contactInfo;
        this.licenseInfo = licenseInfo;
        this.startDate = startDate;
        this.endDate = endDate;
        this.durationInDays = durationInDays;
        this.rentCarNo = rentCarNo;
        this.rentCarModel = ""; // Initialize to an empty string
        this.rentCarPay = rentCarPay;
    }
    public BookingManagement() {
        this.customerName = null;
        this.icNumber = null;
        this.contactInfo = null;
        this.licenseInfo = null;
        this.startDate = null;
        this.endDate = null;
        this.durationInDays = 0;
        this.rentCarNo = null;
        this.rentCarPay = 0.0;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
    
    public static String getRentCarNo() {
        return rentCarNo;
    }

    public static String getRentCarModel() {
        return rentCarModel;
    }
	
    public static double getRentCarPay() {
        return rentCarPay;
    }
    
    public static long getDuration() {
    	return durationInDays;
    }
    
    public static void registerCustomer(Scanner scanner) {
        System.out.println("Customer Registration");
        
        System.out.print("Enter customer name (or 'x' to exit): ");
        String customerName = scanner.nextLine();
        
        if (customerName.equalsIgnoreCase("x")) {
            System.out.println("\nExiting customer registration.");
            Continuity.backMenu();
            return;
        }
        
        System.out.print("Enter customer IC (or 'x' to exit): ");
        String icNumber = scanner.nextLine();
        
        if (icNumber.equalsIgnoreCase("x")) {
            System.out.println("\nExiting customer registration.");
            Continuity.backMenu();
            return;
        }
        
        System.out.print("Enter customer contact (or 'x' to exit): ");
        String contactInfo = scanner.nextLine();
        
        if (contactInfo.equalsIgnoreCase("x")) {
            System.out.println("\nExiting customer registration.");
            Continuity.backMenu();
            return;
        }
        
        System.out.print("Enter customer license (or 'x' to exit): ");
        String licenseInfo = scanner.nextLine();
        
        if (licenseInfo.equalsIgnoreCase("x")) {
            System.out.println("\nExiting customer registration.");
            Continuity.backMenu();
            return;
        }
        
        System.out.println("Customer registered successfully!");
        
        // Perform any further actions needed for customer registration
    }

    
    public static void getDateDuration() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the date start booking (dd/mm/yyyy) (or 'x' to exit): ");
        String startDate = scanner.nextLine();

        if (startDate.equalsIgnoreCase("x")) {
            System.out.println("\nExiting date entry.");
            return;
        }

        System.out.print("Enter the date end booking (dd/mm/yyyy) (or 'x' to exit): ");
        String endDate = scanner.nextLine();

        if (endDate.equalsIgnoreCase("x")) {
            System.out.println("\nExiting date entry.");
            return;
        }

        // Define the date format pattern
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("d/M/yyyy");

        // Check if the input date strings have single-digit days or months and add leading zeros if needed
        String[] startParts = startDate.split("/");
        String[] endParts = endDate.split("/");
        
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
        startDate = String.join("/", startParts);
        endDate = String.join("/", endParts);

        // Parse the input into LocalDate objects using the specified format
        LocalDate date1 = LocalDate.parse(startDate, inputFormatter);
        LocalDate date2 = LocalDate.parse(endDate, inputFormatter);

        // Calculate the duration between the two dates in days
        long durationInDays = Math.abs(date1.toEpochDay() - date2.toEpochDay()) + 1;

        // Define the date format pattern for displaying the result
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Display the result with the new format
        System.out.println("Duration between the two dates: " + outputFormatter.format(date1) +
                " and " + outputFormatter.format(date2) + " is " + durationInDays + " days");
        
        scanner.close();
    }


    public static void checkAvailability(Scanner input, ArrayList<CarManager> cars) {
        System.out.println("Press 'x' to return to the menu at any time.");
        System.out.println("Press Enter twice to show all available car for booking.");
        
        String searchModel = "";
        String seatsInput = "";
        
        while (true) {
            System.out.print("Enter car model (Press Enter to skip): ");
            searchModel = input.nextLine().trim();

            if (searchModel.equalsIgnoreCase("x")) {
                System.out.println("\nReturning to the menu.");
                Continuity.backMenu();
                return;
            }

            System.out.print("Enter number of seats (Press Enter to skip): ");
            seatsInput = input.nextLine().trim();

            if (seatsInput.equalsIgnoreCase("x")) {
                System.out.println("\nReturning to the menu.");
                Continuity.backMenu();
                return;
            }

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
            System.out.println("-------------------------------------------------------------------");
            System.out.printf("%-15s || %-20s || %-15s%n", "Car Plate No", "Car Model", "Payment Rate");
            System.out.println("-------------------------------------------------------------------");
            for (CarManager car : availableCars) {
                System.out.printf("%-15s || %-20s || %-15.2f%n", car.getPlateno(), car.getModel(), car.getRate());
            }
            System.out.println("-------------------------------------------------------------------");

            System.out.print("\nPress 'x' to return to the menu or any other key to search again: ");
            String exitChoice = input.nextLine().trim();
            if (exitChoice.equalsIgnoreCase("x")) {
                System.out.println("\nReturning to the menu.");
                Continuity.backMenu();
                return;
            }
        }
    }


    public static boolean selectCar(Scanner input, ArrayList<CarManager> cars, FileManagement carFileManager) {
        System.out.print("Enter the plate number of the car you want to select (or 'x' to exit): ");
        String plateNumber = input.nextLine();
        boolean select = false;

        if (plateNumber.equalsIgnoreCase("x")) {
            System.out.println("\nExiting car selection.");
            return false; // Indicate that the user chose to exit car selection
        }

        // Find the car with the specified plate number
        for (CarManager car : cars) {
            if (car.getPlateno().equalsIgnoreCase(plateNumber) && car.getStatus().equalsIgnoreCase("Available")) {
                rentCarNo = car.getPlateno();
                rentCarPay = car.getRate();
                rentCarModel = car.getModel();
                car.setStatus("Not Available"); // Update car status to Not Available

                select = true;
                break;
            }
        }

        if (!select) {
            System.out.println("Car not found with the specified plate number or not available.");
        } else {
            // After updating the car status, save the changes to the file
            carFileManager.setListOfCars(cars);
            try {
                carFileManager.saveToFile();
            } catch (IOException e) {
                System.out.println("Error saving data to file: " + e.getMessage());
            }
        }

        return select;
    }

    
    // Method to store booking details and save to a file
    // Method to store booking details and save to a file
    public static void storeBookingDetails() {
        // Implement code to store booking details into an array or object.
        // Include customer details, chosen car details, booking dates, duration, and payment rate.

        // Create a string with booking details
        String bookingDetail = customerName + "," + icNumber + "," + contactInfo + ","
                + licenseInfo + "," + BookingManagement.getRentCarNo() + "," + BookingManagement.getRentCarModel() +"," + startDate + ","
                + endDate + "," + BookingManagement.getDuration() + "," + BookingManagement.getRentCarPay();

        // Save the booking detail to a file
        saveBookingDetailToFile(bookingDetail);
    }

    private static void saveBookingDetailToFile(String bookingDetail) {
        try {
            FileWriter writer = new FileWriter("bookingDetail.txt", true); // Append mode
            writer.write(bookingDetail + "\n");
            writer.close();
            System.out.println("Booking details saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving booking details: " + e.getMessage());
        }
    }

    public static void checkBookingDetail(Scanner input, ArrayList<CarManager> cars) {
        System.out.print("Enter Customer IC (or 'x' to exit): ");
        String icNumber = input.nextLine();

        if (icNumber.equalsIgnoreCase("x")) {
            System.out.println("Exiting booking detail check.");
            Continuity.backMenu();
            return;
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader("bookingDetail.txt"));
            String line;
            boolean found = false;

            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-15s || %-15s || %-15s || %-15s || %-15s || %-25s || %-15s || %-15s ||  %-15s || %-15s%n", "Name", "IC", "Contact", "License", "PlateNo", "Car", "Start", "End", "Duration", "Rate");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            while ((line = reader.readLine()) != null) {
                String[] bookingInfo = line.split(",");

                // Check if the IC number from the file matches the input IC number
                if (bookingInfo.length >= 5 && icNumber.equals(bookingInfo[1].trim())) {
                    found = true;
                    System.out.printf("%-15s || %-15s || %-15s || %-15s || %-15s || %-25s || %-15s || %-15s || %-16s || %-15s%n",
                            bookingInfo[0], bookingInfo[1], bookingInfo[2], bookingInfo[3],
                            bookingInfo[4], bookingInfo[5], bookingInfo[6], bookingInfo[7], bookingInfo[8], bookingInfo[9]);
                }
            }

            if (!found) {
                System.out.println("No booking details found for the specified IC number.");
            }
        } catch (IOException e) {
            System.out.println("Error reading booking details: " + e.getMessage());
        }

    }

    
    public static void CancelBooking(Scanner input, ArrayList<CarManager> cars, FileManagement carFileManager) {
        System.out.print("Enter customer IC to remove booking (or 'x' to exit): ");
        String customerIC = input.nextLine();

        if (customerIC.equalsIgnoreCase("x")) {
            System.out.println("Exiting booking cancellation.");
            Continuity.backMenu();
            return;
        }

        try {
            File inputFile = new File("bookingDetail.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            ArrayList<String> updatedBookingDetails = new ArrayList<>();

            String lineToRemove;
            boolean found = false;

            // Read each line from the file and check if it contains the customer IC
            while ((lineToRemove = reader.readLine()) != null) {
                String[] bookingInfo = lineToRemove.split(",");

                // If the line contains the customer IC, mark it as found and skip adding it to the updated list
                if (bookingInfo.length >= 2 && customerIC.equals(bookingInfo[1].trim())) {
                    found = true;

                    // Find the corresponding car and update its status
                    for (CarManager car : cars) {
                        if (car.getPlateno().equals(bookingInfo[4].trim())) {
                            car.setStatus("Available");
                            break; // Assuming each car has a unique registration number
                        }
                    }

                    continue;
                }

                // Add other lines to the updated list
                updatedBookingDetails.add(lineToRemove);
            }

            reader.close();

            if (found) {
                // Rewrite the entire file with the updated booking details
                BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile));

                for (String updatedBooking : updatedBookingDetails) {
                    writer.write(updatedBooking + "\n");
                }

                writer.close();

                carFileManager.setListOfCars(cars);
                try {
                    carFileManager.saveToFile();
                } catch (IOException e) {
                    System.out.println("Error saving data to file: " + e.getMessage());
                }

                System.out.println("Booking removed successfully.");
            } else {
                System.out.println("No booking found with the specified customer IC.");
            }
        } catch (IOException e) {
            System.out.println("Error removing booking: " + e.getMessage());
        }
    }


}
