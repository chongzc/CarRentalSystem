package CarRentalSystem;
public class User 
{
	private static String username = "username";//username to login is set as "username" 
	private static String password = "password";//password to login is set as "password"
	
	public User(String username, String password)//constructor
	{
		this.username = username;
		this.password = password;
	}


	//getter & setter
	public static String getUsername()
	{
		return username;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public static String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
}
