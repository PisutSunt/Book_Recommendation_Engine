import java.util.ArrayList;
import javafx.util.Pair;

public class BillFileReader extends TextFileReader
{
    private String filename = "backup/bills.txt";

    private boolean checkBillCommand(String line)
    {
        String fields[] = line.split(";");
        try
        {
            Integer.parseInt(fields[0]);
            int itemsInBill = Integer.parseInt(fields[2]);
            if (fields.length == 6 + (2 * itemsInBill))
            {
                for (int i = 0; i < itemsInBill; i++)
                {
                    Integer.parseInt(fields[i + 4]);
                }
            }
            Long.parseLong(fields[fields.length - 1]);
        }
        catch (NumberFormatException numberFormatException)
        {
            return false;
        }
        return true;
    }

    public Bill readBill()
    {
        Bill newBill = null;
        String line;
        Boolean bOk = openFile(filename);
        if (bOk)
        {
            line = getNextLine();
            do
            {
                line = getNextLine();
                if (line != null)
                {
                    if (checkBillCommand(line))
                    {
                        String fields[] = line.split(";");
                        int billNo = Integer.parseInt(fields[0]);
                        Profile buyer = ProfileCollection.getProfile(fields[1]);
                        int noOfItem = Integer.parseInt(fields[2]);
                        ArrayList<Pair<Book, Integer>> boughtBooks = new ArrayList<>();
                        float totalPrice = 0;
                        for (int i = 0; i < noOfItem; i++)
                        {
                            Book tempBook = BookCollection.getBook(fields[i + 3]);
                            int numberOfBook = Integer.parseInt(fields[i + 4]);
                            boughtBooks.add(new Pair<Book,Integer>(tempBook, numberOfBook));
                            totalPrice += tempBook.getPrice() * numberOfBook;
                        }
                        long millisec = Long.parseLong(fields[fields.length - 1]);
                        newBill = new Bill(billNo, buyer, boughtBooks, fields[fields.length - 3], 
                                            fields[fields.length - 2], totalPrice, millisec);
                    }
                    else
					{
						System.out.println("Invalid command");
					}
                }
            } while (newBill == null && line != null);
        }
        return newBill;
    }
}