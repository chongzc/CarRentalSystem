	import java.io.*;
	import java.util.*;
	
	public class Main {
	    public static void main(String[] args) {
	    	//Menu.Login();
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
	           
}
