package ModelLayer;
import java.util.ArrayList;

/**
 * Write a description of class Product here.
 * 
 * @author (Jacob Pedersen & Ronnie Knudsen) 
 * @version (04-12-2014) dd-mm-yyyy
 */
public class Product
{
    // instance variables
    private ArrayList<ProductItem> items;
    private int id;
    private String barcode;
    private String productName;
    private String description;
    private double minimumPrice; //Absolute minimum price, that the product may be sold for.
    private double salesPrice; //Actual price the product should be sold for.
    private double supplierPrice; //The price the product costed to buy from the supplier
    private double discountPrice; //if there's a discount, the sales price will be defined here while the discount lasts.  When not null, this will be the given sales price.
    private int quantity; //The ammount of items
    private String location; //location the products items is located in the warehouse.

    /**
     * Constructor for objects of class Product
     * 
     * @param   id    the products unique id.
     * @param   barcode       the products barcode.
     * @param   productName   The products name.
     * @param   description   product description.
     * @param   minimumPrice  minimum price that the product may be sold for.
     * @param   salesPrice    Actual price the product should be sold for.
     * @param   supplierPrice The price the product costed to buy from the supplier.
     * @param   discountPrice if there's a discount, the sales price will be defined here while the discount lasts.  When not 0, this will be the given sales price.
     */
    public Product(int id, String barcode, String productName, String description, double minimumPrice, double salesPrice, double supplierPrice)
    {
        items = new ArrayList<ProductItem>();
        this.id = id;
        this.barcode = barcode;
        this.productName = productName;
        this.description = description;
        this.minimumPrice = minimumPrice;
        this.salesPrice = salesPrice;
        this.supplierPrice = supplierPrice;
        this.quantity = 0;
        this.location = "Undefined";
    }

    /**
     * Adds an item to the container with availbale items for this product.
     *
     * @param productItem A parameter
     */
    public void addItem(ProductItem productItem)
    {
        items.add(productItem);
        quantity++;
    }

    /**
     * If an item is avalible, the first on the list is returned.
     * 
     * @return is an item of the given itemtype.
     */
    public ProductItem getItem()
    {
        if(items.size() > 0)
        {
            return items.get(0);
        }
        return null;
    }

    /**
     * Returns the item with the given SerialNumber if it exists.
     * 
     * @param SerialNumber  The items serialnumber.
     * @Return  The item with the given serialnumber if it exists. Else it returns null.
     */
    public ProductItem getItemBySerial(String serialNumber)
    {
        //Find item with given serialNumber.
        return null;
    }

    /**
     * returns true if remove is available.
     *
     * @true if remove is available, else false
     */
    public boolean removeItem()
    {
        if(getAvailable() == true)
        {
            items.remove(0);
            quantity--;
            return true;
        }
        return false;
    }

    /**
     * @return  true if there's items available for the product and false if not.
     */
    public boolean getAvailable()
    {
        if(quantity > 0)
        {
            return true;
        }
        return false;
    }

    /**
     * Get the products id.
     * @return  Get the products id.
     */
    public int getId()
    {
        return id;
    }

    /**
     * Get the products barcode.
     * @return  The products Barcode.
     */
    public String getBarcode()
    {
        return barcode;
    }

    /**
     * Get the products name.
     * @return  The products name.
     */
    public String getProductName()
    {
        return productName;
    }

    /**
     * Get the products description.
     * @return  The products description.
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Get the products minimum price.
     * @return  The products minimum price.
     */
    public double getMinimumPrice()
    {
        return minimumPrice;
    }

    /**
     * Get the products sales price.
     * @return  The products sales price.
     */
    public double getSalesPrice()
    {
        return salesPrice;
    }

    /**
     * Get the products discount price.
     * @return  The products discount price.
     */
    public double getDiscountPrice()
    {
        return discountPrice;
    }

    /**
     * Get the products supplier price.
     * @return  The products supplier price.
     */
    public double getSupplierPrice()
    {
        return supplierPrice;
    }

    /**
     * Get the products quantity of available items.
     * @return  The products quantity.
     */
    public int getQuantity()
    {
        return quantity;
    }

    /**
     * Get the products location in the warehouse.
     * @return  The products location in the warehouse.
     */
    public String getLocation()
    {
        return location;
    }

	/**
	 * @param barcode the barcode to set
	 */
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param minimumPrice the minimumPrice to set
	 */
	public void setMinimumPrice(double minimumPrice) {
		this.minimumPrice = minimumPrice;
	}

	/**
	 * @param salesPrice the salesPrice to set
	 */
	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}

	/**
	 * @param supplierPrice the supplierPrice to set
	 */
	public void setSupplierPrice(double supplierPrice) {
		this.supplierPrice = supplierPrice;
	}

	/**
	 * @param discountPrice the discountPrice to set
	 */
	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
}
