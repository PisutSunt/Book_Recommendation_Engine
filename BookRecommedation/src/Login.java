import java.util.Scanner;

public class Login
{
	private static Scanner sc = new Scanner(System.in);
	private static String userName;
	private static String password;
	
	public static void login()
	{
		
		System.out.println("\n------------------Login page------------------");
		
		while(true)
		{
			
			System.out.print("Enter username> ");
			userName = sc.nextLine();
			System.out.print("Enter password> ");
			password = sc.nextLine();
			
			if(userName.equals("admin") && password.equals("root"))
			{
				System.out.println("\t*** Login success! ***");
				break;
				
			}
			else
			{
				System.out.println("\t*** Username or Password incorrect! ***\n");
				continue;
			}
		
		}
		
		//This line for link to homepage
		
	}
}
