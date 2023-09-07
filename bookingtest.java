public class bookingtest {
    public static void main(String[] args) {
        BookingManagement bookingManagement = new BookingManagement();

        // Register a customer using user input
        bookingManagement.registerCustomer();

        // Calculate and display date duration using user input
        bookingManagement.calculateDateDuration();

        // Display registered customers
        System.out.println("Registered Customers:");
        for (Customer customer : bookingManagement.getAllCustomers()) {
            System.out.println("Name: " + customer.getCustomerName());
            System.out.println("IC: " + customer.getCustomerIC());
            System.out.println("Contact: " + customer.getCustomerContact());
            System.out.println("License: " + customer.getCustomerLicense());
            System.out.println();
        }
    }
}

