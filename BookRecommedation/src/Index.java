/**
 * The class Index represents
 */
public class Index
{
	
	public static void showIndex()
	{
		int selMenu;
		
		System.out.println("------------------ Welcome to book recommended engine! ------------------");
		System.out.println("\tPlease select menu number!");
		System.out.println("\t1. Login");
		System.out.println("\t2. Create account");
		
		selMenu = IOUtils.checkInputMenu(1, 2);
		
		switch(selMenu)
		{
			case 1:
				LoginClass.login();
				break;
			case 2:
				CreatingAccount.createAccount();
				break;
			default:
				break;
		}
		
		
	}
}
