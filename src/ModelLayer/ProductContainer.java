package ModelLayer;
import java.util.ArrayList;
import java.io.*;

/**
 * Write a description of class ProductContainer here.
 * 
 * @author (Jacob Pedersen & Ronnie Knudsen) 
 * @version (07-12-2014) dd-mm-yyyy
 */
@SuppressWarnings("serial")
public class ProductContainer implements Serializable
{
    // instance variables
    private static ProductContainer productContainer;
    private ArrayList<Product> products;

    /**
     * Constructor for objects of class ProductContainer
     */
    private ProductContainer()
    {
        products = new ArrayList<Product>();
    }

    /**
     * Returns the ProductContainer singleton object.
     * @return The ProductContainer object.
     */
    public static synchronized ProductContainer getInstance()
    {
        if(productContainer == null)
        {
            productContainer = new ProductContainer();
        }
        return productContainer;
    }

    /**
     * Adds an object of the type Product to the container.
     * @param   product Object of type Product
     */
    public void addProduct(Product product)
    {
        products.add(product);
    }

    /**
     * Find the index position in the arraylist of the given product with the given barcode if it exsist.
     * @param   barcode products barcode.
     * @return  array index number if the product exists. Throws an ObjectNotFoundException() if not.
     */
    private int findProductIndex(String barcode)
    {
        for(int i = 0; i < products.size(); i++)
        {
            if(products.get(i).getBarcode().equals(barcode))
            {
                return i;
            }
        }
        throw new ObjectNotFoundException();
    }

    /**
     * Remove the product by the barcode from the container.
     * @param   barcode The products barcode.
     * @return  true if the product existed and is now removed. false if not.
     */
    public boolean removeProduct(String barcode)
    {
        try
        {
            int i = findProductIndex(barcode);
            products.remove(i);
            return true;
        }
        catch(ObjectNotFoundException e)
        {
            return false;
        }
    }

    /**
     * Finds the product with the given barcode. If none exist, it returns null.
     * @param   barcode The products indentifying barcode.
     */
    public Product findProduct(String barcode)
    {
        try
        {
            int i = findProductIndex(barcode);
            return products.get(i);
        }
        catch(ObjectNotFoundException e)
        {
            return null;
        }
    }

    /**
     * Returns last products id.
     * @return  last products id in the container.
     */
    public int getLastId()
    {
        if(products.size() > 0)
        {
            return products.get(products.size() - 1).getId();
        }
        return 0;
    }

    /**
     * Method listProducts
     * this methods is listing all products in the system
     */
    public void listProducts()
    {
        int i = 0;
        System.out.println("### Listing all products ###");
        if(products != null)
        {
            for(Product p : products)
            {
                System.out.println("##Product name: " + p.getProductName());
                System.out.println("Description: " + p.getDescription());
                System.out.println("Sales price: " + p.getSalesPrice());
                System.out.println("Barcode: " + p.getBarcode());
                System.out.println("");
                i++;
            }
        }
         System.out.println("### The system contains "+ i + " products \n");
         
    }
    
    public ArrayList<Product> getProducts()
    {
		return products;
    }
}