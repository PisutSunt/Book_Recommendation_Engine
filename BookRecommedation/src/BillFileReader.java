
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
                    String fields[] = line.split(";");
                    // search Profile and Books to implement Bill constructor
                }
            }
        }
    }
}