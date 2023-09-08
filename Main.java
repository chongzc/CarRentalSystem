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
	        	Menu.CarMenu(scanner);// Pass scanner to CarManager
	            break;
	        case 2:
	        	Menu.BookingMenu(scanner);
	            break;
	        default:
	            System.out.println("Invalid choice. Please select a valid option.");
	            break;
	        }
	            scanner.close();
	     }
	        

	        
    public static void Booking() {
        Scanner scanner = new Scanner(System.in);
        Menu.BookingMenu(scanner);

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
