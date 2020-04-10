
public class BookFileReader extends TextFileReader
{
    private String filename = "backup/books.txt";

    private boolean checkBookCommand(String line)
    {
        String fields[] = line.split(";");
        if (fields.length == 9)
        {
            try
            {
                Integer.parseInt(fields[3]);
                Float.parseFloat(fields[4]);
                Integer.parseInt(fields[5]);
                Integer.parseInt(fields[7]);
            }
            catch (NumberFormatException numberFormatException)
            {
                return false;
            }
            return true;
        }
        else if (fields.length == 8)
        {
            try
            {
                Integer.parseInt(fields[3]);
                Float.parseFloat(fields[4]);
                Integer.parseInt(fields[6]);
            }
            catch (NumberFormatException numberFormatException)
            {
                return false;
            }
            return true;
        }
        return false;
    }

    public Book readBook()
    {
        Book newBook = null;
        String line;
        Boolean bOk = (openFile(filename));
        if (bOk)
        {
            do
            {
                line = getNextLine();
                if (line != null)
                {
                    if (checkBookCommand(line))
                    {
                        String fields[] = line.split(";");
                        // with totalBought
                        if (fields.length == 9)
                            newBook = new Book(fields[0], fields[1], fields[2], Integer.parseInt(fields[3]), 
                                            Float.parseFloat(fields[4]), Integer.parseInt(fields[5]), 
                                            fields[6], Integer.parseInt(fields[7]), fields[8]);
                        // without totalBought
                        else
                            newBook = new Book(fields[0], fields[1], fields[2], Integer.parseInt(fields[3]), 
                                            Float.parseFloat(fields[4]), fields[5], 
                                            Integer.parseInt(fields[6]), fields[7]);
                    }
                    else
                    {
                        System.out.println("Invalid command");
                    }
                }
            } while (newBook == null && line != null);
        }
        return newBook;
    }
}