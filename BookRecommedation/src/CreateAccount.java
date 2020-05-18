import java.awt.TextField;
import java.io.Console;
import java.util.Scanner;

public class CreateAccount
{
	Scanner sc = new Scanner(System.in);
	Console console = System.console();
	public CreateAccount()
	{
		System.out.println("\n------------------Create account page------------------");
		
		System.out.print("Enter email> ");
		String email = sc.nextLine();
		System.out.print("Enter username> ");
		String user = sc.nextLine();
		while(true)
		{			
			System.out.print("Enter password> ");
			String pass = sc.nextLine();
			System.out.print("Confirm password> ");
			String confPass = sc.nextLine();
			if(pass.equals(confPass))
			{
				break;
			}
			else
			{
				System.out.println("***Password inconsistent***");
				continue;
			}
		}
		
		
	}
}
