import java.util.Enumeration;

public class BillFileWriter extends TextFileWriter
{
    private String filename = "backup/bills.txt";

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
        if (bOk)
        {
            writeStructureGuide();
            for (Enumeration<Profile> i = BillCollection..elements(); i.hasMoreElements();)
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