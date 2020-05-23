import java.io.Serializable;
import java.util.Hashtable;
/**
 * The class ProfileCollection is singleton and represents to handle
 * of Profile. it can add Profile and manipulate the authentication
 * 
 * ProfileCollection class implements Serializable for converting its
 * state to a byte stream. So, the byte stream can be reverted back
 * into a copy of the it.
 * 
 * Created by Pisut Suntronkiti  ID: 60070501037
 *            Wuttithat Krongyot ID: 60070501084
 */
public class ProfileCollection implements Serializable
{
    /** auto generated serialVersionUID is used for verifying the class in serialization and deserialization */
    private static final long serialVersionUID = 5306604982834603924L;

    /** table that keeps all profile with its username as the key */
    private static Hashtable<String, Profile> profileTable = new Hashtable<String, Profile>();

    /**
     * check that username have be even used in the system or not
     * @param userName user name for checking
     * @return true - if the name is already used
     */
    public static boolean isUserNameExisted(String userName)
    {
    	return profileTable.containsKey(userName);
    }
    
    /**
     * check that email is correct or not
     * @param email email for checking
     * @return true - if this email is correct
     */
    public static boolean isValidEmailAddress(String email) 
    {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
    
    /**
     * check that email is already used or not
     * @param email email for checking
     * @return true - if email is already used
     */
    public static boolean isEmailAlreadyUsed(String email)
    {
    	for(String keys: profileTable.keySet())
    	{
    		if(email.equals(profileTable.get(keys).getEmail()))
    		{
    			return true;
    		}
    	}
    	return false;
    }
    
    /**
     * verify authentication (check username and password)
     * @param username username from input
     * @param password password from input
     * @return true - if the authentication is approved that correct
     */
    public static boolean isPasswordCorrect(String username, String password)
    {
    	return password.equals(getProfile(username).getPassword());
    }
    
    /**
     * Profile getter method with user name
     * @param userName user name for getting the Profile
     * @return the wanted Profile
     */
    public static Profile getProfile(String userName)
    {
        return profileTable.get(userName);
    }
    
    /**
     * add a new user to the collection
     * @param userName the user name
     * @param profile the Profile that user want to add to collection
     */
    public static void addUser(String userName, Profile profile)
    {
    	profileTable.put(userName, profile);
    }
    
    /**
     * ProfileCollection getter method
     * @return table that keeps all profile with its username as the key
     */
    public static Hashtable<String, Profile> getProfileCollection()
    {
        return profileTable;
    }
    
    /**
     * for starting the program, this method would be called to read all books information from file.
     */
    public static void initialize()
    {
    	try
		{
    		profileTable = (Hashtable<String, Profile>)IOUtils.readObjectFromFile("profileCollection");
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
    }
    
    /**
     * everytime the profileCollection have changed, this method would be called to update new data to file
     */
    public static void updateFile()
    {
    	IOUtils.writeObjectToFile("profileCollection", (Hashtable<String, Profile>)profileTable);
    }


}