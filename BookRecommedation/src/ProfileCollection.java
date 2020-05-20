import java.util.Dictionary;
import java.util.Hashtable;

public class ProfileCollection
{
    private static Dictionary<String, Profile> profileDict = new Hashtable();

    public static Profile getProfile(String userName)
    {
        return profileDict.get(userName);
    }

    public static Dictionary<String, Profile> getProfileDict()
    {
        return profileDict;
    }
    
    public static boolean addUser(String userName, Profile profile)
    {
    	profileDict.put(userName, profile);
    	return true;
    }
}