import java.util.Scanner;

public class Index
{
	private static Scanner sc = new Scanner(System.in);
	private static int selMenu;
	public static void showIndex()
	{
		System.out.println("------------------ Welcome to book recommended engine! ------------------");
		System.out.println("\tPlease select menu number!");
		System.out.println("\t1. Login");
		System.out.println("\t2. Create account");
		
		while(true)
		{
			System.out.print("\n>> ");
			if(sc.hasNextInt())
			{
				selMenu = sc.nextInt();
				if(selMenu == 1 || selMenu == 2)
				{
					break;					
				}
				else
				{
					System.out.println("\t*** Please select menu 1 or 2 ***");
					continue;
				}
			}
			else
			{
				System.out.println("\t*** Invalid input! ***");
				sc.next();
				continue;
			}
		}
		
		
		switch(selMenu)
		{
			case 1:
				Login.login();
				break;
			case 2:
				CreateAccount.createAccount();
				break;
			default:
				break;
		}
		
		
	}
}
