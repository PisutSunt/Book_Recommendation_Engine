import java.io.Serializable;
/**
 * The class Profile represents to the user account in the book store
 * 
 * Profile class implements Serializable for converting its
 * state to a byte stream. So, the byte stream can be reverted back
 * into a copy of the it.
 * 
 * Created by Pisut Suntronkiti  ID: 60070501037
 *            Wuttithat Krongyot ID: 60070501084
 */
public class Profile implements Serializable
{
	/** auto generated serialVersionUID is used for verifying the class in serialization and deserialization */
	private static final long serialVersionUID = 422354925036457763L;

	/** user name in String */
	private String userName;

	/** user email in String */
	private String email;

	/** password of this account */
	private String password;

	/** interested genre by user */
	private String[] interestedGenre = new String[5];

	/** user's cart. even program is terminated, the items in the cart is still exist in the cart */
	private Cart cart = new Cart();

	/**
	 * constructor of Profile to create the account
	 * @param userName user name in String
	 * @param email user email in String
	 * @param password password of this account
	 * @param genre interested genre by user
	 */
	public Profile(String userName, String email, String password, String[] genre)
	{
		this.userName = userName;
		this.email = email;
		this.password = password;
		interestedGenre = genre;
	}

	/**
	 * user name getter method
	 * @return user name in String
	 */
	public String getUserName()
	{
		return userName;
	}

	/**
	 * email getter method
	 * @return user email in String
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * password getter method
	 * @return password of this account
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 * genre getter method
	 * @return interested genre by user
	 */
	public String[] getGenre()
	{
		return interestedGenre;
	}

	/**
	 * cart getter method
	 * @return user's cart
	 */
	public Cart getCart()
	{
		return cart;
	}
}
