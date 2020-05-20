import java.util.Scanner;

public class CreateAccount
{
	private static Scanner sc = new Scanner(System.in);
	private static String[] Genres = {"Education", "Sci-Fi", "Adventure", "Romance", "History"
										, "Biography", "Comics", "Mystery", "Technology", "Business", "Language"};
	private String user;
	private String email;
	private String pass;
	private String[] userGenre = new String[5];
	public CreateAccount()
	{
		System.out.println("\n------------------ Create account------------------ ");
		
		System.out.print("Enter email> ");
		email = sc.nextLine();
		System.out.print("Enter username> ");
		user = sc.nextLine();
		while(true)
		{			
			System.out.print("Enter password> ");
			pass = sc.nextLine();
			System.out.print("Confirm password> ");
			String confPass = sc.nextLine();
			if(pass.equals(confPass))
			{
				break;
			}
			else
			{
				System.out.println("*** Password inconsistent ***");
				continue;
			}
		}
		
		System.out.println("--- Choose your most interested book genres by enter their number(up to 5) ---");
		for(int i = 0; i<Genres.length; i++)
		{
			System.out.println("\t" + (i+1) + ". " + Genres[i]);
		}
		
		System.out.println("\t0. for complete choosing\n");
		
		int choice = -1;
		for(int i = 0; i<5; i++)
		{
			System.out.print("Genre " + (i+1) + "> ");
			choice = sc.nextInt();
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
				System.out.println("*** Create account success! ***");
				Profile profile = new Profile(user, email, pass, userGenre);
				ProfileCollection.addUser(profile.getUserName(), profile);
				break;
			}
			else if(ans.equals("N"))
			{
				System.out.println("*** Create account failed! ***");
				break;
			}
			else
			{
				continue;
			}
		}
		
	}
}
