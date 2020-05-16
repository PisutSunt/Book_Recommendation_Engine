import java.util.Enumeration;

public class BookFileWriter extends TextFileWriter
{
    private String filename = "backup/books.txt";

    @Override
    protected void writeStructureGuide() 
    {
        
    }

    public boolean writeBook()
    {
        boolean success = true;
        boolean bOk = creatFile(filename);
        String line = null;
        if (bOk)
        {
            for (Enumeration<Book> i = BookCollection.bookCollection.elements(); i.hasMoreElements();)
            {
                Book tempBook = i.nextElement();
                tempBook.getTitle()
            }
        }
        return success;
    }
}