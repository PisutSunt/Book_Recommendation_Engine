
public class BookFileWriter extends TextFileWriter
{
    private String filename = "backup/books.txt";

    @Override
    protected void writeStructureGuide() 
    {
        
    }

    public boolean writeBook(BookCollection books)
    {
        boolean success = true;
        boolean bOk = creatFile(filename);
        String line;
        if (bOk)
        {
            // extract the book and write to file
        }
        return success;
    }
}