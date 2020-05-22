import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class IOUtils
{
	private static Scanner sc = new Scanner(System.in);

	public static Object ReadObjectFromFile(String filepath)
	{
		try
		{
			FileInputStream fileIn = new FileInputStream(filepath);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			Object obj = objectIn.readObject();
			System.out.println("Finish reading from the file: " + filepath);
			objectIn.close();
			return obj;
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			return null;
		}
	}

	public static void WriteObjectToFile(String filepath, Object targetObj)
	{
		try
		{
			FileOutputStream fileOut = new FileOutputStream(filepath);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(targetObj);
			objectOut.close();
			System.out.println("Finish writing to file: " + filepath);
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
	}

	public static int checkInputMenu(int min, int max)
	{
		int selMenu;
		while (true)
		{
			System.out.print("\n>> ");
			if (sc.hasNextInt())
			{
				selMenu = sc.nextInt();
				if (selMenu >= min && selMenu <= max)
				{
					break;
				}
				else
				{
					System.out.println("\t*** Please select between " + min + "-" + max + " ***");
					continue;
				}
			}
			else
			{
				System.out.println("\t*** Invalid input! ***");
				sc.next();
				continue;
			}
		}
		return selMenu;
	}
	
	public static String getString()
	{
		while(sc.hasNext("\n"))
		{
			sc.next();
		}
		return sc.next();
	}

}