/**
 * The class LoginClass represents the form for logging in
 * to sign in the system to use service from the store
 * 
 * Created by Pisut Suntronkiti  ID: 60070501037
 *            Wuttithat Krongyot ID: 60070501084
 */
public class LoginClass
{
	/** user name from input */
	private static String userName;

	/** password from input */
	private static String password;
	
	/**
	 * print the login interface of user for logging in to the store
	 */
	public static void login()
	{
		
		System.out.println("\n------------------Login page------------------\n");
		
		while(true)
		{
			
			System.out.print("Enter username> ");
			userName = IOUtils.getString();
			System.out.print("Enter password> ");
			password = IOUtils.getString();
			
			if(ProfileCollection.isUserNameExisted(userName))
			{
				if(ProfileCollection.isPasswordCorrect(userName, password))
				{
					System.out.println("\n*** Login success! ***");
					break;
				}
				else
				{
					System.out.println("\n*** Username or Password incorrect! ***\n");
					continue;
				}
			}
			else
			{
				System.out.println("\n*** Username or Password incorrect! ***\n");
				continue;
			}
		
		}
		
		HomePage.setCurrentUser(ProfileCollection.getProfile(userName));
		HomePage.showMainMenu();
		
	}
}
