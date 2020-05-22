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
    
    public static boolean isValidEmailAddress(String email) 
    {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
    
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
    
    public static Profile getProfile(String userName)
    {
        return profileTable.get(userName);
    }
    
    public static void addUser(String userName, Profile profile)
    {
    	profileTable.put(userName, profile);
    }
    
//    public static void showAllProfile()
//    {
//    	System.out.println(profileTable);
//    }
    
    public static void initialize()
    {
    	try
		{
    		profileTable = (Hashtable<String, Profile>)IOUtils.ReadObjectFromFile("profileCollection");
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
    }
    
    public static void updateFile()
    {
    	IOUtils.WriteObjectToFile("profileCollection", (Hashtable<String, Profile>)profileTable);
    }

    public static Hashtable<String, Profile> getProfileCollection()
    {
        return profileTable;
    }
}