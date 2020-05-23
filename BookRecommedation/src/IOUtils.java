import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
/**
 * The class IOUtils handles about reading and writing file
 * 
 * Created by Pisut Suntronkiti  ID: 60070501037
 *            Wuttithat Krongyot ID: 60070501084
 */
public class IOUtils
{
	/** scanner for get input from System.in */
	private static Scanner sc = new Scanner(System.in);

	/**
	 * read file and return for the object
	 * @param filepath directory of file
	 * @return imported object
	 */
	public static Object readObjectFromFile(String filepath)
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

	/**
	 * write the object to the file with spcific filepath
	 * @param filepath directory of the file
	 * @param targetObj target object
	 */
	public static void writeObjectToFile(String filepath, Object targetObj)
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

	/**
	 * limit input value
	 * @param min minimum value
	 * @param max maimum value
	 * @return exact value of input
	 */
	public static int checkInputMenu(int min, int max)
	{
		int selMenu;
		while (true)
		{
			System.out.print("\n>> ");
			while(sc.hasNext("\n"))
			{
				sc.next();
			}
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