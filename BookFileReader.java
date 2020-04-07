
public class BookFileReader extends TextFileReader
{
    private String filename = "backup/books.txt";

    private boolean checkBookCommand(String line)
    {
        String fields[] = line.split(";");
        if (fields.length == 8){
            // ยังไม่เช็ค attribute อื่นๆ
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