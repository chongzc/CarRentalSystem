package CarRentalSystem;
import java.io.InputStream;
import java.util.*;
public interface Continuity {
	public static void backMenu()
	{	
		Scanner input = new Scanner(System.in);
		System.out.print("Press any key to continue: ");
		input.nextLine();
	}
}
