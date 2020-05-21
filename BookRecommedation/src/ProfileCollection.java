import java.io.Serializable;
import java.util.Hashtable;

public class ProfileCollection implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = 5306604982834603924L;
    private static Hashtable<String, Profile> profileTable = new Hashtable<String, Profile>();

    public static boolean isUserNameExisted(String userName)
    {
    	return profileTable.containsKey(userName);
    }
    
    public static boolean isEmailAlreadyUsed(String email)
    {
    	return email.equals("email");
    }
    
    public static Profile getProfile(String userName)
    {
        return profileTable.get(userName);
    }
    
    public static void addUser(String userName, Profile profile)
    {
    	profileTable.put(userName, profile);
    }
    
    public static void showAllProfile()
    {
    	System.out.println(profileTable);
    }
    
    public static void initialize()
    {
        profileTable = (Hashtable<String, Profile>)IOUtils.ReadObjectFromFile(".\\backup\\profileCollection");
    }

    public static Hashtable<String, Profile> getProfileCollection()
    {
        return profileTable;
    }
}