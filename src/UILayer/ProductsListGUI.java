package UILayer;

/**
 * Sales GUI and methods
 * 
 * @author Ronnie Knudsen
 * @version (01/02-2014) dd/mm-yyyy
 */

import CtrLayer.ProductController;
import ModelLayer.Product;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Dimension;
import java.util.ArrayList;
import java.awt.Window.Type;

public class ProductsListGUI {

	JFrame frmRegisteredProducts;
	private JTable table;
	DefaultTableModel productsTable;
	ProductController productController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductsListGUI window = new ProductsListGUI();
					window.frmRegisteredProducts.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProductsListGUI() {
		productController = new ProductController();
		productController.createTestProducts(); //For testing purposes only. Uncomment it when not testing.
		initialize();
		loadProductsTable();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegisteredProducts = new JFrame();
		frmRegisteredProducts.setType(Type.POPUP);
		frmRegisteredProducts.setTitle("Registered products");
		frmRegisteredProducts.setMinimumSize(new Dimension(650, 0));
		frmRegisteredProducts.setBounds(100, 100, 450, 300);
		frmRegisteredProducts.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		frmRegisteredProducts.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		productsTable = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Name", "Description", "Sales price", "Minimums price", "Supplier price", "No. of Items", "Barcode"
				}
				); /*{
			Class[] columnTypes = new Class[] {
				String.class, String.class, Double.class, Double.class, Double.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});*/
		table = new JTable(productsTable);
		scrollPane.setViewportView(table);
	}

	/**
	 * Load all products into a row each in the table.
	 */
	private void loadProductsTable()
	{
		ArrayList<Product> products = productController.getProducts();
		for(Product product : products)
		{
			productsTable.addRow(new Object []{
					product.getProductName(),
					product.getDescription(),
					product.getSalesPrice(),
					product.getMinimumPrice(),
					product.getSupplierPrice(),
					product.getQuantity(),
					product.getBarcode()
			});
		}
		productsTable.newDataAvailable(null);
	}
}
