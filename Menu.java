package TestRun;

public class Menu {
	
	public static void MainMenu() 
    {
        System.out.println( "Main Menu");
        System.out.println( "1 - Car Menu");
        System.out.println( "2 - Booking");
        System.out.println( "0 - Exit");
        System.out.print  ( "Your choice: ");
    }
	
	public static void CarMenu() 
    {
        System.out.println( "Car Menu");
        System.out.println( "1 - Add a car");
        System.out.println( "2 - Display cars");
        System.out.println( "3 - Remove a car");
        System.out.println( "4 - Update car status");
        System.out.println( "5 - Quit");
        System.out.print  ( "Your choice: ");
    }
	
	public static void BookingMenu() 
    {
        System.out.println( "Booking Menu");
        System.out.println( "1 - Rent a car");
        System.out.println( "2 - Cancel booking");
        System.out.println( "3 - Quit");
        System.out.print  ( "Your choice: ");
    }
	

}
