import java.util.Scanner;

public class CreateAccount
{
	private static Scanner sc = new Scanner(System.in);
	private static String[] Genres = {"Education", "Sci-Fi", "Adventure", "Romance", "History"
										, "Biography", "Comics", "Mystery", "Technology", "Business", "Language", "Fantasy", "Horror"};
	private static String userName;
	private static String email;
	private static String password;
	private static String[] userGenre = new String[5];
	
	public static void createAccount()
	{
		System.out.println("\n------------------ Create account------------------ ");
		
		while(true)
		{
			System.out.print("Enter email> ");
//			if(sc.hasNext())
//			{
//				sc.next();				
//			}
			email = sc.nextLine();
			
			if(ProfileCollection.isEmailAlreadyUsed(email))
			{
				System.out.println("\t*** This email is already used! ***");
				continue;
			}
			else
			{
				break;
			}
		}
		
		while(true)
		{
			System.out.print("Enter username> ");
			userName = sc.nextLine();
			if(ProfileCollection.isUserNameExisted(userName))
			{
				System.out.println("\t*** This username is already used! ***");
				continue;
			}
			else
			{
				break;
			}
		}
		
		while(true)
		{			
			while(true)
			{
				System.out.print("Enter password> ");
				password = sc.nextLine();
				if(password.length() < 6)
				{
					System.out.println("\t*** Password is too short! ***");					
				}
				else
				{
					break;
				}
			}
			System.out.print("Confirm password> ");
			String confPass = sc.nextLine();
			if(password.equals(confPass))
			{
				break;
			}
			else
			{
				System.out.println("\t*** Password inconsistent! ***");
				continue;
			}
		}
		
		System.out.println("\n--- Choose your most interested book genres by enter their number(up to 5) ---");
		for(int i = 0; i<Genres.length; i++)
		{
			System.out.println("\t" + (i+1) + ". " + Genres[i]);
		}
		
		System.out.println("\t0. for complete choosing\n");
		
		int choice = -1;
		for(int i = 0; i<5; i++)
		{
			System.out.print("Genre " + (i+1));
			choice = IOUtils.checkInputMenu(0, Genres.length);
			if(choice == 0)
				break;
			userGenre[i] = Genres[choice];
		}
		
		while(true)
		{
			System.out.print("Confirm to create account (Y/N)?> ");
			String ans = sc.next();
			if(ans.equals("Y"))
			{
				Profile profile = new Profile(userName, email, password, userGenre);
				ProfileCollection.addUser(profile.getUserName(), profile);
				ProfileCollection.updateFile();
				System.out.println("\n\t*** Create account success! ***\n");
				Index.showIndex();
				break;
			}
			else if(ans.equals("N"))
			{
				System.out.println("\n\t*** Create account failed! ***\n");
				Index.showIndex();
				break;
			}
			else
			{
				continue;
			}
		}
		
	
	}
}
