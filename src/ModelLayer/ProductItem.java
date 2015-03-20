package ModelLayer;


/**
 * Write a description of class ProductItem here.
 * 
 * @author (Jacob Pedersen & Ronnie Knudsen) 
 * @version (04-12-2014) dd-mm-yyyy
 */
public class ProductItem
{
    // instance variables
    private String serialNumber;

    /**
     * Constructor for objects of class ProductItem
     */
    public ProductItem()
    {
        serialNumber = null;
    }
    
    /**
     * Constructor for objects of class ProductItem
     * @param serialNumber the items personal serialnumber.
     */
    public ProductItem(String serialNumber)
    {
        this.serialNumber = serialNumber;
    }
    
    /**
     * get items serialnumber.
     * @return items serialnumber.
     */
    public String getSerialNumber()
    {
        return serialNumber;
    }
}
