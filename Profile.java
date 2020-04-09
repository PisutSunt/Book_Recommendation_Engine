import java.util.ArrayList;

public class Profile
{
    private String userName;
    private String email;
    private String password;
    private ArrayList<String> interestedGenre = new ArrayList<>();
    private Cart cart = new Cart();
    private BillCollection userBills = new BillCollection();

    public Profile(String userName, String email, String password, ArrayList<String> genre)
    {
        this.userName = userName;
        this.email = email;
        this.password = password;
        interestedGenre = genre;
    }

    public String getName()
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

    public ArrayList<String> getGenre()
    {
        return interestedGenre;
    }

    public Cart getCart()
    {
        return cart;
    }

    public ArrayList<Bill> getBill()
    {
        
    }
}