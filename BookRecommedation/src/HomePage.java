
public class HomePage
{
	private static Profile currentUser;
	
	public static void showMainMenu()
	{
		int selMenu;
		
		System.out.println("\n------------------ Main menu ------------------");
		System.out.println("\t1. Request recommendations (based on your interested genres).");
		System.out.println("\t2. See best seller of the last month.");
		System.out.println("\t3. Search for the books.");
		System.out.println("\t4. View your cart.");
		System.out.println("\t5. View buying history.");
		System.out.println("\t0. Back to welcome page.");
		
		selMenu = IOUtils.checkInputMenu(0, 5);
		
		switch(selMenu)
		{
			case 0:
				Index.showIndex();
			case 1:
				requestRecommendation();
				break;
			case 2:
				seeBestSeller();
				break;
			case 3:
				searchBooks();
				break;
			case 4:
				viewCart();
				break;
			case 5:
				viewBuyingHistory();
				break;
			default:
				break;
		}
		
	}
	
	private static void requestRecommendation()
	{
		System.out.println(">>> Request recommendations...");
	}
	
	private static void seeBestSeller()
	{
		System.out.println(">>> See best seller...");
	}
	
	private static void searchBooks()
	{
		System.out.println(">>> Search for the books...");
	}
	
	private static void viewCart()
	{
		System.out.println(">>> View your cart...");
		System.out.println("\t1. Show all books in the cart.");
		System.out.println("\t2. Remove a book in the cart.");
		System.out.println("\t3. Make purchase.");
		System.out.println("\t0. Back to Main menu.");
	}
	
	private static void viewBuyingHistory()
	{
		System.out.println(">>> View buying history...");
//		System.out.println("Current user: " + currentUser.getUserName());
	}
	
	public static void setCurrentUser(Profile user)
	{
		currentUser = user;
	}
}
