/**
 * The class Index represents the index page that print
 * alternative action between creating account and logging in
 * 
 * Created by Pisut Suntronkiti  ID: 60070501037
 *            Wuttithat Krongyot ID: 60070501084
 */
public class Index
{
	/**
	 * Print the user interface of index page
	 */
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
