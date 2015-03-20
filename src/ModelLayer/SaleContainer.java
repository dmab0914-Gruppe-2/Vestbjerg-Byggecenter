package ModelLayer;
import java.util.ArrayList;
import java.io.*;


/**
 * Write a description of class SaleContainer here.
 * 
 * @author ARM & NW
 * @version 04/12-14
 */
@SuppressWarnings("serial")
public class SaleContainer implements Serializable
{
    private ArrayList<Sale> sales;
    private static SaleContainer saleContainer;
    
    /**
     * Constructor for objects of class SaleContainer
     */
    private SaleContainer()
    {
        // initialise instance variables
        sales = new ArrayList<Sale>();
    }

    /**
     * singleton method
     */
    public static synchronized SaleContainer getSaleContainer()
    {
        if(saleContainer == null)
        {
            saleContainer = new SaleContainer();
        }
        return saleContainer;
    }
    
    /**
     * initializes a new sale (order)
     * @param workerId, the id of the worker assigned to the sale
     * @return sale, the sales class created
     */
    public Sale makeNewSale(int workerId)
    {
        int i = sales.size();
        Sale sale = new Sale(i, workerId);
        sales.add(sale);
        return sale;
    }
    
    /**
     * returns the size of the sales container
     */
    public int getSize()
    {
        return sales.size();
    }
    
    /**
     * adds a sale to the container
     * @param s, a sale which is added to ArrayList<Sale> sales
     */
    public void addSale(Sale s)
    {
        sales.add(s);
    }
}
