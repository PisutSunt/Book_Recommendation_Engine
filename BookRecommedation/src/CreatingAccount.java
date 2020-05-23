/**
 * The class CreatingAccount represents register form for 
 * new user who want to be the member of the book store.
 * 
 * Created by Pisut Suntronkiti  ID: 60070501037
 *            Wuttithat Krongyot ID: 60070501084
 */
public class CreatingAccount
{
	private static String[] Genres = { "Education", "Sci-Fi", "Adventure", "Romance", "History", "Biography", "Comics",
			"Mystery", "Technology", "Business", "Language", "Fantasy", "Horror" };
	private static String userName;
	private static String email;
	private static String password;
	private static String[] userGenre = new String[5];

	public static void createAccount()
	{
		System.out.println("\n------------------ Create account------------------ ");

		while (true)
		{
			System.out.print("Enter email> ");
			email = IOUtils.getString();
			if (ProfileCollection.isValidEmailAddress(email))
			{
				if (ProfileCollection.isEmailAlreadyUsed(email))
				{
					System.out.println("*** This email is already used! ***");
					continue;
				}
				else
				{
					break;
				}
			}
			else
			{
				System.out.println("*** Invalid format! ***");
				continue;
			}
		}

		while (true)
		{
			System.out.print("Enter username> ");
			userName = IOUtils.getString();
			if (ProfileCollection.isUserNameExisted(userName))
			{
				System.out.println("\t*** This username is already used! ***");
				continue;
			}
			else
			{
				break;
			}
		}

		while (true)
		{
			while (true)
			{
				System.out.print("Enter password> ");
				password = IOUtils.getString();
				if (password.length() < 6)
				{
					System.out.println("\t*** Password is too short! ***");
				}
				else
				{
					break;
				}
			}
			System.out.print("Confirm password> ");
			String confPass = IOUtils.getString();
			if (password.equals(confPass))
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
		for (int i = 0; i < Genres.length; i++)
		{
			System.out.println("\t" + (i + 1) + ". " + Genres[i]);
		}

		System.out.println("\t0. for complete choosing\n");

		int choice = -1;
		int check = 0;
		for (int i = 0; i < 5; i++)
		{
			System.out.print("Genre " + (i + 1));
			choice = IOUtils.checkInputMenu(0, Genres.length);
			if (choice == 0)
			{				
				if (userGenre[0] == null)
				{
					System.out.println("*** Please select at least one genre! ***");
					i--;
					continue;
				}
				else
					break;
			}
			for(String itr: userGenre)
			{
				if(Genres[choice-1].equals(itr))
				{
					check++;
					break;
				}
			}
			if(check > 0)
			{
				System.out.println("*** You already select this genre!, Please select again ***");
				check = 0;
				i--;
				continue;
			}
			else
				userGenre[i] = Genres[choice-1];
		}

		while (true)
		{
			System.out.print("Confirm to create account (Y/N)?> ");
			String ans = IOUtils.getString();
			if (ans.equals("Y"))
			{
				Profile profile = new Profile(userName, email, password, userGenre);
				ProfileCollection.addUser(profile.getUserName(), profile);
				ProfileCollection.updateFile();
				System.out.println("\n\t*** Create account success! ***\n");
				Index.showIndex();
				break;
			}
			else if (ans.equals("N"))
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
