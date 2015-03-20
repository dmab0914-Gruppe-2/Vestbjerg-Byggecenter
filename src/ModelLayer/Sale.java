package ModelLayer;
import java.util.ArrayList;

/**
 * Write a description of class Sale here.
 * 
 * @author ARM & NW
 * @version 04/12-14
 */
public class Sale
{
    private ArrayList<PartSale> partSale;
    private int orderId;
    private double price;
    @SuppressWarnings("unused")
	private int workerId;
    @SuppressWarnings("unused")
	private String date;
    private boolean active = true;
    /**
     * Constructor for objects of class Sale
     * @param   i           the order id which is generated based on how many orders there are in sales controller
     * @param   workerId    the worker who made this sale
     */
    public Sale(int i, int workerId)
    {
        this.orderId = i;
        this.price = 0;
        this.date = "today";
        this.workerId = workerId;
        partSale = new ArrayList<PartSale>();
    }

    /**
     * looks for a Product in each excisting partSale, if none excists, create a new partSale with 
     * Product p as parameter.
     * @param p, Product which is the product allocated to a partsale.
     * @return 1, if a product excists in a partSale and were counted one up
     * @return 2, if a product does not excist and a partSale were created
     */
    public int addItem(Product p)
    {
    	if(getActive())
    	{
	        boolean excists = false;
	        boolean execute = true;
	        int i = 0;
	        
	        if(partSale.size() != 0)
	        {
	            while(execute || !excists && i < partSale.size())
	            {
	                if(partSale.size() == i)
	                {
	                    excists = false;
	                    execute = false;
	                }
	                else if(partSale.get(i).getProduct().equals(p))
	                {
	                    excists = true;
	                    execute = false;
	                }
	                else
	                {
	                    i++;
	                }
	            }
	        }
	        
	        if(excists)
	        {
	            partSale.get(i).amountCount();//adds the item to an already excisting partsale by counting the amount 1 up. 
	            return 1;
	        }
	        else
	        {
	            PartSale ps = new PartSale(p);//creates a new partsale.
	            partSale.add(ps);
	            return 2;
	        }//endIf
    	}
    	else
    	{
    		return 3;
    	}//endIf
    }//endMethod
    
    public boolean getActive()
    {
    	return active;
    }
    
    /**
     * looks for a Product in each excisting partSale, if none excists, create a new partSale with 
     * Product p as parameter.
     * @param p, Product which is the product allocated to a partsale.
     * @param discount, a double value which represents the discount value
     * @return 1, if a product excists in a partSale and were counted one up and a discount 
     *          applied to all products in this partsale
     * @return 2, if a product does not excist and a partSale were created and all further products will have
     *          this discount attached
     */
    public int addItemWithDiscount(Product p, double discount)
    {
        boolean excists = false;
        boolean execute = true;
        int i = 0;
        
        if(getActive())
        {
	        if(partSale.size() != 0)
	        {
	            while(execute || !excists && i < partSale.size())
	            {
	                if(partSale.size() == i)
	                {
	                    excists = false;
	                    execute = false;
	                }
	                else if(partSale.get(i).getProduct().equals(p))
	                {
	                    excists = true;
	                    execute = false;
	                }
	                else
	                {
	                    i++;
	                }//endIf
	            }//endWhile
	        }//endIf
	        
        

	        if(excists)
	        {
	            partSale.get(i).amountCount();//adds the item to an already excisting partsale by counting the amount 1 up. 
	            partSale.get(i).setSpecialPrice(discount);
	            return 1;
	        }
	        else
	        {
	            PartSale ps = new PartSale(p);//creates a new partsale.
	            partSale.add(ps);
	            ps.setSpecialPrice(discount);
	            return 2;
	        }//endIf
	    }
        else
        {
        	return 3;
        }//endIf
    }//endMethod

    /**
     * returns the total of the sale
     * @return price, the total price of all partSales if any partsale excists, else returns 0
     */
    public double getTotal()
    {
        double pp = 0;
        if(partSale.size() != 0)
        {
            for(PartSale p : partSale)
            {
                pp += p.getPartPrice();
            }
        }
        price = pp;
        return price;
    }

    /**
     * returns the order id
     */
    public int getOrderId()
    {
        return orderId;
    }

    /**
     * removes all items from the stock quantity
     */
    public void endSale()
    {
        for(PartSale p : partSale)
        {
             int i = p.getAmount();
            for(int index = 0; index < i; index++)
            {
                p.getProduct().removeItem();
            }//endFor
        }//endFor
        active = false;
    }
    
    /**
     * reassigns the worker to the current task
     * @param id, the id of the worker which will take over the sale
     */
    public void reassign(int id)
    {
        this.workerId = id;
    }//endMethod
    
    /**
     * returns if the sale is active or not, which is defined if a payment has been made
     * @return active
     */
    public boolean isActive()
    {
    	return active;
    }//endMethod
}//endClass
