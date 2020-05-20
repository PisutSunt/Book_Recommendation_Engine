import java.util.Enumeration;

public class ProfileFileWriter extends TextFileWriter
{
    private String filename = "backup/profiles.txt";

    @Override
    protected void writeStructureGuide() 
    {
        String guide = "username; email; password; genre";
        try
        {
            writer.write(guide);
            writer.newLine();
        }
        catch (Exception exception)
        {
            System.out.println(exception);
        }
    }

    public boolean writeProfile()
    {
        boolean bOk = creatFile(filename);
        String line = null;
        writeStructureGuide();
        if (bOk)
        {
            for (Enumeration<Profile> i = ProfileCollection.getProfileDict().elements(); i.hasMoreElements();)
            {
                Profile tempProfile = i.nextElement();
                line = tempProfile.getName() + ";" + tempProfile.getEmail() + ";" + tempProfile.getPassword() + ";";
                for (String genre : tempProfile.getGenre())
                    line = line + genre + ";";
                try
                {
                    writer.write(line);
                    writer.newLine();
                }
                catch (Exception exception)
                {
                    System.out.println(exception);
                }
            }
        }
        return bOk;
    }
}