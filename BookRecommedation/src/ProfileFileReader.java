import java.util.ArrayList;

public class ProfileFileReader extends TextFileReader
{
	private String filename = "backup/profiles.txt";

	private boolean checkProfileCommand(String line)
	{
		String fields[] = line.split(";");
		if (fields.length >= 4 && fields.length <= 8)
		{
			return true;
		}
		return false;
	}

	public Profile readProfile()
	{
		Profile newProfile = null;
		String line;
		Boolean bOk = (openFile(filename));
		if (bOk)
		{
			do
			{
				line = getNextLine();
				if (line != null)
				{
					if (checkProfileCommand(line))
					{
						String fields[] = line.split(";");
						ArrayList<String> genre = new ArrayList<String>();
						for (int i = 3; i < fields.length; i++)
						{
							genre.add(fields[i]);
						}
						newProfile = new Profile(fields[0], fields[1], fields[2], genre);
					}
					else
					{
						System.out.println("Invalid command");
					}
				}
			} while (newProfile == null && line != null);
		}
		return newProfile;
	}
}