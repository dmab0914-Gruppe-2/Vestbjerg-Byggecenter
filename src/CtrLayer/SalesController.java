package CtrLayer;
import ModelLayer.*;


/**
 * Write a description of class SalesController here.
 * 
 * @author ARM & NW
 * @version 04/12-14
 */
public class SalesController
{
    private SaleContainer saleContainer;
    private ProductController productController;
    private PersonController personController;
    private Sale sale;//Sale class in general
    private Sale csale;//Current sale
    /**
     * Constructor for objects of class ProductController
     */
    public SalesController()
    {
        saleContainer = SaleContainer.getSaleContainer();
        personController = new PersonController();
        productController = new ProductController();
    }

    /**
     * initializes a new sale with a new sales id
     * @param workerId, the id of the worker who will be assigned to the current sale.
     * @return true if a sale were created with an excisting worker
     * @return false if the worker does not excist
     */
    public boolean makeNewSale(int workerId)
    {
        Person p = personController.findPerson(workerId);
        if(p != null)
        {
            if(p instanceof Worker)
            {
                Worker w = (Worker)p;
                sale = saleContainer.makeNewSale(w.getId());
                csale = sale;
                return true; //order created
            }
        }else{
            return false;//worker id not found            
        }
        return false;
    }

    /**
     * adds an item to the current sale
     * @param barcode, the barcode of the product which will be added to the current sale
     * @return 1, if an item were counted +1
     * @return 2, if a patsale were created and item is now = 1
     * @return 0, if no product with matching barcode were found
     */
    public int addItem(String barcode)
    {
        Product product = productController.findProduct(barcode);
        if(product != null)
        {
            switch(csale.addItem(product))
            {
                case 1://Item excists and counted 1 up
                	return 1;

                case 2://Item is not in cart and new partsale is created
                	return 2;
                	
                case 3:
                	return 3;
            }
        }
        return 0;
    }

    /**
     * adds an item with a discount, applies the discount to all items of this product
     * @param barcode, the barcode of the product which will be added to the current sale
     * @param discount, which is a % of the discount which will be applied to the products partsale (Max 20)
     * @return 1, if an item were counted +1
     * @return 2, if a patsale were created and item is now = 1
     * @return 3, if no product with matching barcode were found 
     * @return 0, if discount is bigger than 20(%)
     */
    public int addItemWithDiscount(String barcode, double discount)
    {
        Product product = productController.findProduct(barcode);
        if(discount <= 20.0)
        {
            if(product != null)
            {
                switch(csale.addItemWithDiscount(product, discount))
                {
                    case 1://item is counted
                    	return 1;

                    case 2: //item is added
                    	return 2;
                    
                    case 3:
                    	return 3;
                    
                }
            }
            return 3;//product does not excist
        }
        return 0;//discount is bigger than allowed
    }

    /**
     * returns the total amount of the whole order
     */
    public double getTotal()
    {
        return csale.getTotal();
    }

    /**
     * returns the current working order id.
     * @return the order id
     * @return 0, if theres no current sale
     */
    public int getCurrentOrderId()
    {
        if(csale != null)
        {
            return csale.getOrderId();
        }
        else
        {
            return 0;
        }
    }

    /**
     * sends the command to current sale to reassign the worker in this to a valid worker
     * @param id, the id of the worker which will be reassigned to the current sale.
     */
    public void reassign(int id)
    {
        personController.findPerson(id);
        csale.reassign(id);
    }

    /**
     * sends a signal to the current sale to deduct the amount of items from the product quantity
     */
    public void closeSale()
    {
        csale.endSale();
    }//endMethod

    /**
     * deducts the price of the current sale from the account holders account
     * @param account, account number
     * @return true, if withdraw were successful, else false.
     */
    public boolean makePaymentAccount(int account)
    {
        Person p = personController.findPerson(account);
        if(p != null)
        {
            if(p instanceof Customer)
            {
                Customer c = (Customer)p;
                c.withdrawFromBalance(getTotal());
                return true;
            }//endIf
        }//endIf
        return false;
    }//endMethod

    /**
     * deducts the price of the current sale from the account holders account
     * @param pnbr, phone number of the account holder
     * @return true, if withdraw were successful, else false.
     */
    public boolean makePaymentPhone(String pnbr)
    {
        Person p = personController.findPersonByPhoneNumber(pnbr);
        if(p != null)
        {
            if(p instanceof Customer)
            {
                Customer c = (Customer)p;
                c.withdrawFromBalance(getTotal());
                closeSale();
                return true;
            }//endIf
        }//endIf
        return false;
    }//endMethod
    
    public boolean isActive()
    {
    	if(csale != null)
    		return csale.isActive();
    	else
    		return false;
    }
}//endClass
