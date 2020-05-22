import java.util.ArrayList;

public class HomePage
{
	private static Profile currentUser;
	
	public static void showMainMenu()
	{
		
		System.out.println("\n------------------ Main menu ------------------");
		System.out.println("\t1. Request recommendations (based on your interested genres).");
		System.out.println("\t2. See best seller.");
		System.out.println("\t3. Search for the books.");
		System.out.println("\t4. View your cart.");
		System.out.println("\t5. View buying history.");
		System.out.println("\t0. Back to welcome page.");
		
		int selMenu = IOUtils.checkInputMenu(0, 5);
		
		switch(selMenu)
		{
			case 0:
				Index.showIndex();
				break;
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
		System.out.println("    Search by...");
		System.out.println("\t1. Title");
		System.out.println("\t2. Author");
		System.out.println("\t3. Genre");
		System.out.println("\t4. ISBN");
		System.out.println("\t0. Back to Main menu.");
		
		int selMenu = IOUtils.checkInputMenu(0, 4);
		
		switch(selMenu)
		{
			case 0:
				showMainMenu();
				break;
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			default:
				break;
		}
	}
	
	private static void viewCart()
	{
		System.out.println(">>> View your cart...");
		System.out.println("\t1. Show all books in the cart.");
		System.out.println("\t2. Remove a book in the cart.");
		System.out.println("\t3. Make purchase.");
		System.out.println("\t0. Back to Main menu.");
		
		int selMenu = IOUtils.checkInputMenu(0, 3);
		
		switch(selMenu)
		{
			case 0:
				showMainMenu();
				break;
			case 1:
				currentUser.getCart().showAllBooksInCart();
				viewCart();
				break;
			case 2:
				break;
			case 3:
				break;
			default:
				break;
		}
		
	}
	
	private static void viewBuyingHistory()
	{
		System.out.println(">>> View buying history...");

		System.out.println("\tOrderNo.\tOrderDate\tTotalPrice");
		ArrayList<Bill> bills = currentUser.getUserBillCollection();
		int index = 0;
		for(Bill itr: bills)
		{
			index++;
			System.out.print("\t" + index + ")" + itr.getBillNo());
			System.out.print("\t" + itr.getOrderDate());
			System.out.print("\t" + itr.getTotalPrice() + "Baht");
			System.out.print("\n");
		}
	}
	
	public static void setCurrentUser(Profile user)
	{
		currentUser = user;
	}
}
