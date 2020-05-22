import java.util.Scanner;

public class Login
{
	private static Scanner sc = new Scanner(System.in);
	private static String userName;
	private static String password;
	
	public static void login()
	{
		
		System.out.println("\n------------------Login page------------------\n");
		
		while(true)
		{
			
			System.out.print("Enter username> ");
			userName = sc.nextLine();
			System.out.print("Enter password> ");
			password = sc.nextLine();
			
			if(ProfileCollection.isUserNameExisted(userName))
			{
				if(password.equals(ProfileCollection.getProfile(userName).getPassword()))
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
