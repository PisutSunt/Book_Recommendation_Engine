import java.util.Scanner;

public class Login
{
	Scanner sc = new Scanner(System.in);
	public Login()
	{
		
		System.out.println("\n------------------Login page------------------");
		
		while(true)
		{
			
			System.out.print("Enter username> ");
			String user = sc.nextLine();
			System.out.print("Enter password> ");
			String pass = sc.nextLine();
			
			if(user.equals("admin") && pass.equals("root"))
			{
				System.out.println("***Login successful!***");
				break;
				
			}
			else
			{
				System.out.println("***Username or Password incorrect!***\n");
				continue;
			}
		
		}
		
		//This line for link to homepage
		
	}
}
