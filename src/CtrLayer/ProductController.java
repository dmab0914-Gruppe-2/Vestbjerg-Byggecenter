package CtrLayer;
import java.util.ArrayList;

import ModelLayer.*;


/**
 * Write a description of class ProductController here.
 * 
 * @author (Jacob Pedersen & Ronnie Knudsen) 
 * @version (04-12-2014) dd-mm-yyyy
 */
public class ProductController
{
	private ProductContainer productContainer;

	/**
	 * Constructor for objects of class ProductController
	 */
	public ProductController()
	{
		productContainer = ProductContainer.getInstance();
	}

	/**
	 * Add a new product to the poduct container.
	 * @param   barcode       the products barcode.
	 * @param   productName   The products name.
	 * @param   description   product description.
	 * @param   minimumPrice  minimum price that the product may be sold for.
	 * @param   salesPrice    Actual price the product should be sold for.
	 * @param   supplierPrice The price the product costed to buy from the supplier.
	 * @param   discountPrice if there's a discount, the sales price will be defined here while the discount lasts.  When not 0, this will be the given sales price.
	 * @return	false if a product with the barcode already exist. True if not, after product have been created.
	 */
	public boolean addProduct(String barcode, String productName, String description, double minimumPrice, double salesPrice, double supplierPrice)
	{
		if(productContainer.findProduct(barcode) == null)
		{
			int id = productContainer.getLastId() + 1;
			Product newProduct = new Product(id, barcode, productName, description, minimumPrice, salesPrice, supplierPrice);
			productContainer.addProduct(newProduct);
			return true;
		}
		return false;
	}

	/**
	 * Finds the product with the given barcode in ProductContainer. If none exist, it returns null.
	 * @param   barcode The products indentifying barcode.
	 */
	public Product findProduct(String barcode)
	{
		try
		{
			return productContainer.findProduct(barcode);
		}
		catch(ObjectNotFoundException e)
		{
			return null;
		}
	}

	/**
	 * Method deleteProduct
	 *  deletes 
	 *
	 * @param barcode A parameter
	 * @return The return value
	 */
	public boolean deleteProduct(String barcode)
	{
		Product fp = findProduct(barcode);
		boolean d = false;
		if(fp != null)
		{
			productContainer.removeProduct(barcode);
			d = true;
		}
		else
		{
			d = false;
		}

		if(d)
		{
			return d;
		}
		else
		{ 
			return d;
		}
	}
	
	/**
	 * Adds a single item to a given product.
	 * @param barcode	Barcode of the product
	 * @return	true if product exists. false if not.
	 */
	public boolean addItem(String barcode) {
		return addItems(barcode, 1);
	}
	
	/**
	 * Adds a given amount of items to a given product.
	 * @param barcode	Barcode of the product
	 * @param amount	The amount of products to add.
	 * @return	true if product exists. false if not.
	 */
	public boolean addItems(String barcode, int amount) {
		Product p = findProduct(barcode);
		if(p != null) {
			for(int i = 0; i < amount; i++) {
				p.addItem(new ProductItem());
			}
			return true;
		}
		
		return false;
	}

	/**
	 * Method changeProduct, this method finds a product by its currently/old barcode and then remember its ID to keep same id 
	 * on the product
	 * Then its deletes the old product and create a new find same ID
	 *
	 * @param oldBarcode A parameter currently/old barcode
	 * @param barcode A parameter new barcode
	 * @param productName A parameter new name
	 * @param description A parameter new description
	 * @param minimumPrice A parameter new minimumsprice
	 * @param salesPrice A parameter new sales price
	 * @param supplierPrice A parameter new supplierprice
	 * @return The return value true/false if it can find a product to match old barcode
	 */
	public boolean changeProduct(String oldBarcode, String barcode, String productName, String description, double minimumPrice, double salesPrice, double supplierPrice)
	{
		boolean changed = false;
		Product product = findProduct(oldBarcode);
		if(findProduct(barcode) == null && product != null)
		{
			product.setBarcode(barcode);
			product.setProductName(productName);
			product.setDescription(description);
			product.setMinimumPrice(minimumPrice);
			product.setSalesPrice(salesPrice);
			product.setSupplierPrice(supplierPrice);
			changed = true;
		}

		return changed;
	}

	/**
	 * Method listProduts
	 *  Listing all the products in the productContainer
	 */
	public void listProduts()
	{
		productContainer.listProducts();
	}

	public ArrayList<Product> getProducts()
	{
		return productContainer.getProducts();
	}

	public void createTestProducts()
	{
		if(productContainer.getLastId() == 0)
		{
			addProduct("1234", "Pink Shoes", "Really nice pink shows for the lady", 25, 30, 15);
			addProduct("1235", "Green Shoes", "Really nice green shows for the lady", 205, 300, 55);
			addProduct("fh4ds", "Pink Hat", "Really nice pink hat for the lady", 80, 200, 30);
			findProduct("1234").addItem(new ProductItem());
			findProduct("fh4ds").addItem(new ProductItem());
			findProduct("fh4ds").addItem(new ProductItem());
		}
	}
}