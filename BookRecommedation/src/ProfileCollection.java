import java.util.Dictionary;

public class ProfileCollection
{
    private static Dictionary<String, Profile> profileDict;

    public static Profile getProfile(String userName)
    {
        return profileDict.get(userName);
    }
}