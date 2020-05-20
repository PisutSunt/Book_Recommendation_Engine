import java.io.Serializable;
import java.util.ArrayList;

public class BillCollection implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = -8532049033326057555L;
    private ArrayList<Bill> billCollection;

    public ArrayList<Bill> getBillCollection()
    {
        return billCollection;
    }
}