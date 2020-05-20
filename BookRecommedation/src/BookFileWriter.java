import java.util.Enumeration;

public class BookFileWriter extends TextFileWriter
{
    private String filename = "backup/books.txt";

    @Override
    protected void writeStructureGuide() 
    {
        String guide = "title; author; genre; page length; price; [total bought]; abstract; remaining; ISBN;";
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

    public boolean writeBook()
    {
        boolean bOk = creatFile(filename);
        String line = null;
        writeStructureGuide();
        if (bOk)
        {
            for (Enumeration<Book> i = BookCollection.bookCollection.elements(); i.hasMoreElements();)
            {
                Book tempBook = i.nextElement();
                line = tempBook.getTitle() + ";" + tempBook.getAuthor() + ";" + tempBook.getGenre() + ";" 
                    + tempBook.getLengthInPages() + ";" + tempBook.getPrice() + ";" + tempBook.getTotalBought() 
                    + ";" + tempBook.getAbtract() + ";" + tempBook.getRemaining() + ";" + tempBook.getISBN() + ";";
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