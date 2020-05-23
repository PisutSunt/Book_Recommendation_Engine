import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;

public class HomePage
{
	private static Profile currentUser;

	public static void showMainMenu()
	{

		System.out.println("\n------------------ Main menu ------------------");
		System.out.println("\t1. Request recommendations.");
		System.out.println("\t2. Search for the books.");
		System.out.println("\t3. View your cart.");
		System.out.println("\t4. View buying history.");
		System.out.println("\t0. Back to welcome page.");

		int selMenu = IOUtils.checkInputMenu(0, 5);

		switch (selMenu)
		{
			case 0:
				setCurrentUser(null);
				Index.showIndex();
				break;
			case 1:
				requestRecommendation();
				break;
			case 2:
				searchBooks();
				break;
			case 3:
				viewCart();
				break;
			case 4:
				viewBuyingHistory();
				break;
			default:
				break;
		}

	}

	private static void requestRecommendation()
	{
		System.out.println(">>> Request recommendations...");
		System.out.println("\t1. Based on your interested genres.");
		System.out.println("\t2. Based on community.");
		System.out.println("\t0. Back to Main menu.");

		int selMenu = IOUtils.checkInputMenu(0, 2);

		switch (selMenu)
		{
			case 0:
				showMainMenu();
				break;
			case 1:
				ArrayList<Book> list1 = BookCollection.recommendByContent(currentUser);
				System.out.println(
						"------------------------------------------- Recommended books -------------------------------------------");
				System.out.println("\t   Title\t\t\tAuthor\t\t\tGenre\t\t\tISBN");
				for (int i = 0; i < list1.size(); i++)
				{
					Book book = list1.get(i);
					System.out.printf("\t%d. %-28s %-23s %-23s %s\n", i + 1, book.getTitle(), book.getAuthor(),
							book.getGenre(), book.getISBN());
				}

				System.out.print("\nSelect a book number to see the detail (or type '0' to back to main menu).");
				int selBook1 = IOUtils.checkInputMenu(0, list1.size());

				if (selBook1 == 0)
				{
					showMainMenu();
				}
				else
				{
					Book book = list1.get(selBook1 - 1);
					seeBookDetail(book);
				}
				break;
			case 2:
				ArrayList<Book> list2 = BookCollection.recommendByCommunity(currentUser);
				if (list2 == null)
				{
					System.out.println("\t*** You need to buy something first to join community! ***");
					showMainMenu();
				}
				else
				{
					System.out.println(
							"------------------------------------------- Recommended books -------------------------------------------");
					System.out.println("\t   Title\t\t\tAuthor\t\t\tGenre\t\t\tISBN");
					for (int i = 0; i < list2.size(); i++)
					{
						Book book = list2.get(i);
						System.out.printf("\t%d. %-28s %-23s %-23s %s\n", i + 1, book.getTitle(), book.getAuthor(),
								book.getGenre(), book.getISBN());
					}

					System.out.print("\nSelect a book number to see the detail (or type '0' to back to main menu).");
					int selBook2 = IOUtils.checkInputMenu(0, list2.size());

					if (selBook2 == 0)
					{
						showMainMenu();
					}
					else
					{
						Book book = list2.get(selBook2 - 1);
						seeBookDetail(book);
					}
				}
				break;
			default:
				break;
		}
	}

	private static void searchBooks()
	{
		System.out.println(">>> Search for the books...");
		System.out.print("Enter keywords> ");
		String keywords = IOUtils.getString();
		List<String> list = BookCollection.searchBooks(keywords);

		System.out.println("\t   Title\t\t\tAuthor\t\t\tGenre\t\t\tISBN");
		int index = 1;
		for (String key : list)
		{
			Book book = BookCollection.getBook(key);
			System.out.printf("\t%d. %-28s %-23s %-23s %s\n", index, book.getTitle(), book.getAuthor(), book.getGenre(),
					book.getISBN());
			index++;
		}
		if (list != null)
		{
			System.out.print("\nSelect a book number to see the detail (or type '0' to back to main menu).");
			int selMenu = IOUtils.checkInputMenu(0, list.size());

			if (selMenu == 0)
			{
				showMainMenu();
			}
			else
			{
				Book book = BookCollection.getBook(list.get(selMenu - 1));
				seeBookDetail(book);
			}
		}
		else
		{
			System.out.println("*** No item match your search ***\n");
			showMainMenu();
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

		switch (selMenu)
		{
			case 0:
				showMainMenu();
				break;
			case 1:
				currentUser.getCart().showAllBooksInCart();
				viewCart();
				break;
			case 2:
				while (true)
				{
					currentUser.getCart().showAllBooksInCart();
					if (currentUser.getCart().getSelectedBooks().isEmpty())
						break;
					System.out.print("\nEnter number of book that you want to remove ('0' for cancel)> ");
					ArrayList<Pair<Book, Integer>> list = currentUser.getCart().getSelectedBooks();
					int selBook = IOUtils.checkInputMenu(0, list.size());

					if (selBook == 0)
					{
						viewCart();
					}
					else
					{
						currentUser.getCart().removeBookFromCart(list.get(selBook - 1));
						continue;
					}
				}
				viewCart();
			case 3:
				currentUser.getCart().showAllBooksInCart();
				if (currentUser.getCart().getSelectedBooks().isEmpty())
				{
					showMainMenu();					
				}
				else
				{
					boolean bOk = currentUser.getCart().purchase(currentUser);
					if (bOk)
						System.out.print("\t*** Purchase complete ***");
					else
						System.out.print("\t*** Purchase incomplete!! ***");
					
					showMainMenu();
				}
				break;
			default:
				break;
		}

	}

	private static void viewBuyingHistory()
	{
		System.out.println(">>> View buying history...");

		ArrayList<Bill> bills = BillManager.findBillCollection(currentUser);
		if (bills == null)
		{
			System.out.println("\t*** You need to buy something first! ***");
			showMainMenu();
		}
		else
		{
			int index = 0;
			System.out.println("\t   BillNo.\t\t\tOrderDate\t\t\tTotalPrice");
			for (Bill itr : bills)
			{
				index++;
				System.out.printf("\t%d. %-28s %-31s %s baht\n", index, itr.getBillNo(), itr.getOrderDate(),
						itr.getTotalPrice());
			}
			showMainMenu();
		}

	}

	private static void seeBookDetail(Book book)
	{

		System.out.println("\tTitle: " + book.getTitle());
		System.out.println("\tAuthor: " + book.getAuthor());
		System.out.println("\tGenre: " + book.getGenre());
		System.out.println("\tPage length: " + book.getLengthInPages());
		System.out.println("\tPrice (Baht): " + book.getPrice());
		System.out.println("\tAbstract: " + book.getAbtract());
		System.out.println("\tRamaining: " + book.getRemaining());
		System.out.println("\tISBN: " + book.getISBN());

		System.out.println("---------------------------------------");
		while (true)
		{
			System.out.print("Add this book to cart? (Y/N)> ");
			String ans = IOUtils.getString();
			if (ans.equals("Y"))
			{
				boolean bOk = currentUser.getCart().addBookToCart(book);
				if(bOk)
					System.out.println("*** Add complete ***");
				else
					System.out.println("*** Add failed ***");
				currentUser.getCart().showAllBooksInCart();
				showMainMenu();
				break;

			}
			else if (ans.equals("N"))
			{
				showMainMenu();
				break;
			}
			else
			{
				continue;
			}
		}

	}

	public static void setCurrentUser(Profile user)
	{
		currentUser = user;
	}
}
