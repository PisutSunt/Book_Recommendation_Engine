import java.io.IOException;
import java.util.Scanner;

public class Index
{
	Scanner sc = new Scanner(System.in);
	public Index()
	{
		System.out.println("******Welcome to book recommended engine!******");
		System.out.println("Please select option number!");
		System.out.println("1. Login");
		System.out.println("2. Create account");
		System.out.print("\n>> ");
		
		int option = sc.nextInt();
		
		if(option == 1)
		{
			Login login = new Login();
		}
		else if(option == 2)
		{
			CreateAccount createAccount = new CreateAccount();
		}
		
	}
	
	
	
}
