import java.util.Scanner;

public class HomePage
{
	private static Scanner sc = new Scanner(System.in);
	private static int selMenu;
	
	public static void showMainMenu()
	{
		System.out.println("\n------------------ Menu (type '!menu' to show menu again) ------------------\n");
		System.out.println("\t1. Request recommendations (based on your interested genres)");
		System.out.println("\t2. See best seller of the last month");
		System.out.println("\t3. Search for the books");
		System.out.println("\t4. View your cart");
		System.out.println("\t5. View buying history");
		
		while(true)
		{
			
			System.out.print("\n>> ");
			if(sc.hasNextInt())
			{
				selMenu = sc.nextInt();
				if(selMenu > 0 && selMenu < 5)
				{
					break;					
				}
				else
				{
					System.out.println("\t*** Please select menu 1-5 ***");
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
		System.out.println(">>> Request recommendations");
	}
	
	private static void seeBestSeller()
	{
		System.out.println(">>> See best seller");
	}
	
	private static void searchBooks()
	{
		System.out.println(">>> Search for the books");
	}
	
	private static void viewCart()
	{
		System.out.println(">>> View your cart");
	}
	
	private static void viewBuyingHistory()
	{
		System.out.println(">>> View buying history");
	}
}
