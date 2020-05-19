import java.util.ArrayList;

public class Profile
{
	private String userName;
	private String email;
	private String password;
	private String[] interestedGenre = new String[5];
	private Cart cart = new Cart();
	private BillCollection userBills = new BillCollection();

	public Profile(String userName, String email, String password, String[] genre)
	{
		this.userName = userName;
		this.email = email;
		this.password = password;
		interestedGenre = genre;
	}

	public String getUserName()
	{
		return userName;
	}

	public String getEmail()
	{
		return email;
	}

	public String getPassword()
	{
		return password;
	}

	public String[] getGenre()
	{
		return interestedGenre;
	}

	public Cart getCart()
	{
		return cart;
	}

	public ArrayList<Bill> getBill()
	{
		return null;
	}
}