package ModelLayer;
import java.io.*;

/**
 * Write a description of class PartSale here.
 * 
 * @author ARM & NW
 * @version 04/12-14
 */
@SuppressWarnings("serial")
public class PartSale implements Serializable
{
    private Product p;
    private int amount;
    private double partPrice;
    private boolean specialPrice;
    /**
     * Constructor for objects of class PartSale
     */
    public PartSale(Product p)
    {
        amount = 1;
        specialPrice = false;
        this.p = p;
    }

    /**
     * adds an item to the partsale
     */
    public int amountCount()
    {
        amount++;
        return amount;
    }

    /**
     * returns the product of the partsale
     */
    public Product getProduct()
    {
        return p;
    }

    /**
     * returns the amount of the product
     */
    public int getAmount()
    {
        return amount;
    }

    /**
     * returns the cost of the part sale
     */
    public double getPartPrice()
    {
        if(specialPrice == false)
        {
            partPrice = p.getSalesPrice();
            return partPrice * amount;
        }else{
            return partPrice * amount;
        }
    }

    /**
     * adds the ability to give a maximum of 20% discount
     */
    public void setSpecialPrice(double d)
    {
        specialPrice = true;
        partPrice = (((100-d)/100)*p.getSalesPrice());
    }
}

