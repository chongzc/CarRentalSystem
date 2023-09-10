import java.util.*;
import java.io.*;


	public class PaymentSystem {
	    // Define a method to calculate the payment for a booking.
	    public static double calculatePayment(int duration, double paymentRate) {
	        return duration * paymentRate;
	    }

	    // Define a method to generate a payment receipt and save it to a file.
	    public static void generatePaymentReceipt(Customer customer, double paymentAmount) {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        String currentDate = dateFormat.format(new Date());

	        String receipt = String.format("Payment Receipt\n"
	                + "Name: %s\n"
	                + "IC: %s\n"
	                + "Contact: %s\n"
	                + "Number Plate: %s\n"
	                + "Date: %s\n"
	                + "Payment Amount: %.2f\n\n",
	                customer.getName(), customer.getIC(), customer.getContact(), customer.getNumberPlate(), currentDate, paymentAmount);

	        try (FileWriter writer = new FileWriter(customer.getIC() + "_receipt.txt")) {
	            writer.write(receipt);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    // Define a method to update the payment history file.
	    public static void updatePaymentHistory(Customer customer, double paymentAmount) {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        String currentDate = dateFormat.format(new Date());

	        String paymentRecord = String.format("%s, %s, %s, %s, %.2f",
	                customer.getName(), customer.getIC(), customer.getContact(), currentDate, paymentAmount);

	        try (FileWriter writer = new FileWriter("payment_history.txt", true)) {
	            writer.write(paymentRecord + "\n");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    // Define a method to update the booking history file.
	    public static void updateBookingHistory(Customer customer) {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        String currentDate = dateFormat.format(new Date());

	        String bookingRecord = String.format("%s, %s, %s, %s pickup",
	                customer.getName(), customer.getIC(), customer.getNumberPlate(), currentDate);

	        try (FileWriter writer = new FileWriter("booking_history.txt", true)) {
	            writer.write(bookingRecord + "\n");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

