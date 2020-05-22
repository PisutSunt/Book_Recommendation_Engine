import java.io.Serializable;
import java.util.ArrayList;

public class Profile implements Serializable
{
	/**
	 *
	 */
	private static final long serialVersionUID = 422354925036457763L;
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
		return userBills.getBillCollection();
	}
}