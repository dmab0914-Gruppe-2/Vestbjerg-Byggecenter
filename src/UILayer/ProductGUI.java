package UILayer;

/**
 * Product GUI and methods
 * 
 * @author Jacob Pedersen
 * @version (01/02-2014) dd/mm-yyyy
 */
import CtrLayer.ProductController;
import ModelLayer.ObjectNotFoundException;
import ModelLayer.Product;
import ModelLayer.ProductItem;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Dimension;

import javax.swing.JLayeredPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class ProductGUI extends JPanel {
	private ProductController productController;
	private UIUtilities uiUtilities;
	private Product productEdit;

	private JTextField textFieldSearchBarcode;
	private JTextField textFieldBarcode;
	private JTextField textFieldProductName;
	private JTextField textFieldDescription;
	private JTextField textFieldMinimumPrice;
	private JTextField textFieldSalesPrice;
	private JTextField textFieldSupplierPrice;
	private JLabel lblSuccesOrNot;
	private JLabel lblTheresXItems;
	private JButton btnEditProduct;
	private JButton btnAddItemTo;
	private JButton btnRemoveItemFrom;
	private JButton btnRemoveProduct;
	private JButton btnSearchBarcode;
	private JButton btnListAllProducts;
	private JLabel lblAddEdit;
	private JButton btnSaveCreate;
	private JButton btnClear;

	/**
	 * Create the panel.
	 */
	public ProductGUI() {
		productController = new ProductController(); //Creates a new ProductController object.
		uiUtilities = new UIUtilities(); //Creates a new Uiutilities object.
		productController.createTestProducts(); //For testing purposes only. Uncomment it when not testing.
		initialize(); //Load all GUI elements
		resetButtons();
		resetProductTextFields();
		actionListeners(); //Load all action Listeners.
	}

	private void initialize()
	{
		setPreferredSize(new Dimension(750, 500));
		setMinimumSize(new Dimension(750, 500));
		setLayout(new GridLayout(1, 0, 0, 0));
		setBackground(new Color(200, 221, 242));

		JLayeredPane layeredPane = new JLayeredPane();
		add(layeredPane);

		JPanel panel_ProductManagement = new JPanel();

		JLabel lblProductManagement = new JLabel("Product management");

		btnListAllProducts = new JButton("List all products");

		JLabel lblProductsBarcode = new JLabel("Products barcode:");

		textFieldSearchBarcode = new JTextField();

		textFieldSearchBarcode.setToolTipText("Barcode of the product you want to find");
		textFieldSearchBarcode.setColumns(10);

		lblSuccesOrNot = new JLabel("Succes or not");
		lblSuccesOrNot.setVisible(false);
		lblSuccesOrNot.setEnabled(false);

		btnSearchBarcode = new JButton("Search");

		btnEditProduct = new JButton("Edit Product");
		btnEditProduct.setEnabled(false);

		btnAddItemTo = new JButton("Add item(s) to product");
		btnAddItemTo.setEnabled(false);

		btnRemoveItemFrom = new JButton("Remove item(s) from product");
		btnRemoveItemFrom.setEnabled(false);

		btnRemoveProduct = new JButton("Remove product");
		btnRemoveProduct.setEnabled(false);

		GroupLayout gl_panel_ProductManagement = new GroupLayout(panel_ProductManagement);
		gl_panel_ProductManagement.setHorizontalGroup(
			gl_panel_ProductManagement.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_ProductManagement.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_ProductManagement.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnListAllProducts, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
						.addComponent(lblProductManagement)
						.addComponent(lblProductsBarcode)
						.addComponent(textFieldSearchBarcode, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
						.addComponent(btnSearchBarcode, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
						.addComponent(lblSuccesOrNot, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
						.addComponent(btnEditProduct, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
						.addComponent(btnAddItemTo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnRemoveItemFrom, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnRemoveProduct, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_ProductManagement.setVerticalGroup(
			gl_panel_ProductManagement.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_ProductManagement.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblProductManagement)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnListAllProducts)
					.addGap(18)
					.addComponent(lblProductsBarcode)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldSearchBarcode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSearchBarcode)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSuccesOrNot)
					.addGap(18)
					.addComponent(btnEditProduct)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAddItemTo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRemoveItemFrom)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRemoveProduct)
					.addContainerGap(189, Short.MAX_VALUE))
		);
		panel_ProductManagement.setLayout(gl_panel_ProductManagement);

		JPanel panel_AddEditProduct = new JPanel();

		lblAddEdit = new JLabel("Add / Edit product");

		JLabel lblBarcode = new JLabel("Barcode:");

		JLabel lblProductName = new JLabel("Product Name:");

		JLabel lblDescription = new JLabel("Description:");

		JLabel lblMinimumPrice = new JLabel("Minimum Price:");

		JLabel lblSalesPrice = new JLabel("Sales Price:");

		JLabel lblSupplierPrice = new JLabel("Supplier Price:");

		lblTheresXItems = new JLabel("There's x items registred to this product");
		lblTheresXItems.setVisible(false);

		textFieldBarcode = new JTextField();
		textFieldBarcode.setColumns(10);

		textFieldProductName = new JTextField();
		textFieldProductName.setColumns(10);

		textFieldDescription = new JTextField();
		textFieldDescription.setColumns(10);

		textFieldMinimumPrice = new JTextField();
		textFieldMinimumPrice.setColumns(10);

		textFieldSalesPrice = new JTextField();
		textFieldSalesPrice.setColumns(10);

		textFieldSupplierPrice = new JTextField();
		textFieldSupplierPrice.setColumns(10);

		btnSaveCreate = new JButton("Save / Create");

		btnClear = new JButton("Clear");

		GroupLayout gl_panel_AddEditProduct = new GroupLayout(panel_AddEditProduct);
		gl_panel_AddEditProduct.setHorizontalGroup(
			gl_panel_AddEditProduct.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_AddEditProduct.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_AddEditProduct.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_AddEditProduct.createSequentialGroup()
							.addGroup(gl_panel_AddEditProduct.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAddEdit)
								.addGroup(gl_panel_AddEditProduct.createSequentialGroup()
									.addGroup(gl_panel_AddEditProduct.createParallelGroup(Alignment.LEADING)
										.addComponent(lblSupplierPrice)
										.addComponent(lblMinimumPrice)
										.addComponent(lblProductName)
										.addComponent(lblBarcode)
										.addComponent(lblDescription)
										.addComponent(lblSalesPrice))
									.addGap(18)
									.addGroup(gl_panel_AddEditProduct.createParallelGroup(Alignment.LEADING)
										.addComponent(textFieldProductName, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
										.addComponent(textFieldDescription, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
										.addComponent(textFieldMinimumPrice, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
										.addComponent(textFieldSalesPrice, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
										.addComponent(textFieldSupplierPrice, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
										.addComponent(textFieldBarcode, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)))
								.addComponent(lblTheresXItems, GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE))
							.addGap(194))
						.addGroup(Alignment.TRAILING, gl_panel_AddEditProduct.createSequentialGroup()
							.addComponent(btnClear)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnSaveCreate)
							.addGap(28))))
		);
		gl_panel_AddEditProduct.setVerticalGroup(
			gl_panel_AddEditProduct.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_AddEditProduct.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAddEdit)
					.addGap(48)
					.addGroup(gl_panel_AddEditProduct.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBarcode)
						.addComponent(textFieldBarcode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_AddEditProduct.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProductName)
						.addComponent(textFieldProductName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_AddEditProduct.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDescription)
						.addComponent(textFieldDescription, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_AddEditProduct.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMinimumPrice)
						.addComponent(textFieldMinimumPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_AddEditProduct.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSalesPrice)
						.addComponent(textFieldSalesPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_AddEditProduct.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSupplierPrice)
						.addComponent(textFieldSupplierPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblTheresXItems)
					.addPreferredGap(ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
					.addGroup(gl_panel_AddEditProduct.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSaveCreate)
						.addComponent(btnClear))
					.addContainerGap())
		);
		panel_AddEditProduct.setLayout(gl_panel_AddEditProduct);
		GroupLayout gl_layeredPane = new GroupLayout(layeredPane);
		gl_layeredPane.setHorizontalGroup(
			gl_layeredPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_layeredPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_ProductManagement, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_AddEditProduct, GroupLayout.PREFERRED_SIZE, 508, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_layeredPane.setVerticalGroup(
			gl_layeredPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_layeredPane.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_layeredPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_ProductManagement, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_AddEditProduct, Alignment.LEADING, 0, 0, Short.MAX_VALUE))
					.addGap(11))
		);
		layeredPane.setLayout(gl_layeredPane);
	}

	private void actionListeners()
	{
		btnListAllProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProductsListGUI.main(null); //Open ProductListGUI in new window.
			}
		});

		textFieldSearchBarcode.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					searchProduct();
				}
			}
		});

		btnSearchBarcode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchProduct();
			}
		});

		/**
		 * Edit the product.
		 */
		btnEditProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(productEdit == null)
				{
					throw new ObjectNotFoundException();
				}
				else
				{
					editProduct();
				}
			}
		});

		/**
		 * Add item(s) to the product.
		 */
		btnAddItemTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(productEdit == null)
				{
					throw new ObjectNotFoundException();
				}
				else
				{
					productEdit.addItem(new ProductItem()); //Possible improvement with a popup, that asks you how many items you want to add.
					editProduct();
					enableProductButtons();
				}
			}
		});

		/**
		 * Remove item(s) from the product.
		 */
		btnRemoveItemFrom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				productEdit.removeItem();
				editProduct();
				enableProductButtons();
			}
		});

		btnRemoveProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				productController.deleteProduct(productEdit.getBarcode());
				resetButtons();
				resetProductTextFields();
				JOptionPane.showMessageDialog(null, "The product have been removed.");
			}
		});

		/**
		 * Clear everything.
		 */
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetButtons();
				resetProductTextFields();
			}
		});

		btnSaveCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(productEdit != null)
				{
					updateProduct();
				}
				else if(productEdit == null)
				{
					createProduct();
				}
			}
		});
	}

	/**
	 * Search for a product by the given barcode, and present possible options.
	 */
	private void searchProduct()
	{
		String barcodeInput = textFieldSearchBarcode.getText(); //Get the barcode from the barcode text field.
		resetButtons();
		resetProductTextFields();
		textFieldSearchBarcode.setText(barcodeInput);
		if(barcodeInput.equals("")) //In case user hits the search button without typing anything in the text field.
		{
			lblSuccesOrNot.setText("You haven't typed anything.");
			lblSuccesOrNot.setVisible(true);
		}
		else
		{
			Product product = productController.findProduct(barcodeInput);
			if(product != null)
			{
				lblSuccesOrNot.setText("What do you want to do?");
				lblSuccesOrNot.setVisible(true);
				productEdit = product;
				enableProductButtons();
			}
			else if(product == null)
			{
				lblSuccesOrNot.setText("Product doesn't exist.");
				lblSuccesOrNot.setVisible(true);
			}
		}
	}

	/**
	 * Loads everything related to editing the found product.
	 */
	private void editProduct()
	{
		lblAddEdit.setText("Edit product:");
		textFieldBarcode.setText(productEdit.getBarcode());
		textFieldDescription.setText(productEdit.getDescription());
		textFieldMinimumPrice.setText(Double.toString(productEdit.getMinimumPrice()));
		textFieldProductName.setText(productEdit.getProductName());
		textFieldSalesPrice.setText(Double.toString(productEdit.getSalesPrice()));
		textFieldSupplierPrice.setText(Double.toString(productEdit.getSupplierPrice()));
		lblTheresXItems.setVisible(true);
		int itemQuantity = productEdit.getQuantity();
		String amountText = " items";
		if(itemQuantity == 1)
		{
			amountText = " item";
		}
		lblTheresXItems.setText("There's " + itemQuantity  +  amountText + " registred to this product.");
		btnSaveCreate.setText("Save");
	}

	private void enableProductButtons()
	{
		if(productEdit != null)
		{
			btnEditProduct.setEnabled(true);
			btnAddItemTo.setEnabled(true);
			btnRemoveProduct.setEnabled(true);
			if(productEdit.getQuantity() > 0)
			{
				btnRemoveItemFrom.setText("Remove item from product");
				btnRemoveItemFrom.setEnabled(true);
			}
			else
			{
				btnRemoveItemFrom.setText("No items to remove.");
				btnRemoveItemFrom.setEnabled(false);
			}
		}
	}

	private void createProduct()
	{
		String message;
		final String barcode = textFieldBarcode.getText();
		final String productName = textFieldProductName.getText();
		final String description = textFieldDescription.getText();
		final String minimumPriceString = textFieldMinimumPrice.getText();
		final String salesPriceString = textFieldSalesPrice.getText();
		final String supplierPriceString = textFieldSupplierPrice.getText();
		Double minimumPrice;
		Double salesPrice;
		Double supplierPrice;
		if(uiUtilities.isDouble(minimumPriceString) && uiUtilities.isDouble(salesPriceString) && uiUtilities.isDouble(supplierPriceString))
		{
			minimumPrice = Double.parseDouble(minimumPriceString);
			salesPrice = Double.parseDouble(salesPriceString);
			supplierPrice = Double.parseDouble(supplierPriceString);

			if(barcode.isEmpty() || productName.isEmpty() || description.isEmpty())
			{
				message = "You need to fill in all the text fields";
			}
			else if(productController.addProduct(barcode, productName, description, minimumPrice, salesPrice, supplierPrice))
			{
				message = "product have been added with barcode: " + barcode;
			}
			else
			{
				message = "Product with given barcode already exist.";
			}

		}
		else
		{
			message = "The prices can't include letters or other special characters.";
		}
		JOptionPane.showMessageDialog(null, message);
	}

	private void updateProduct()
	{
		String message;
		final String oldBarcode = productEdit.getBarcode();
		final String newBarcode = textFieldBarcode.getText();
		final String newProductName = textFieldProductName.getText();
		final String newDescription = textFieldDescription.getText();
		final String newMinimumPriceString = textFieldMinimumPrice.getText();
		final String newSalesPriceString = textFieldSalesPrice.getText();
		final String newSupplierPriceString = textFieldSupplierPrice.getText();
		Double newMinimumPrice;
		Double newSalesPrice;
		Double newSupplierPrice;
		if(uiUtilities.isDouble(newMinimumPriceString) && uiUtilities.isDouble(newSalesPriceString) && uiUtilities.isDouble(newSupplierPriceString))
		{
			newMinimumPrice = Double.parseDouble(newMinimumPriceString);
			newSalesPrice = Double.parseDouble(newSalesPriceString);
			newSupplierPrice = Double.parseDouble(newSupplierPriceString);

			if(newBarcode.isEmpty() || newProductName.isEmpty() || newDescription.isEmpty())
			{
				message = "You need to fill in all the text fields";
			}
			else if(productController.changeProduct(oldBarcode, newBarcode, newProductName, newDescription, newMinimumPrice, newSalesPrice, newSupplierPrice))
			{
				//Product update completed successfully.
				message = "product changes completed sucessfully.";
			}
			else
			{
				message = "Something went wrong.";
			}
		}
		else
		{
			message = "The prices can't include letters or other special characters.";
		}
		JOptionPane.showMessageDialog(null, message);
	}

	private void resetButtons()
	{
		btnEditProduct.setEnabled(false);
		btnAddItemTo.setEnabled(false);
		btnRemoveItemFrom.setEnabled(false);
		btnRemoveProduct.setEnabled(false);
		btnEditProduct.setText("Edit Product");
		btnAddItemTo.setText("Add item to product");
		btnRemoveItemFrom.setText("Remove item from product");
		btnRemoveProduct.setText("Remove product");
		btnSaveCreate.setText("Create");
	}

	private void resetProductTextFields()
	{
		productEdit = null;
		textFieldSearchBarcode.setText("");
		textFieldBarcode.setText("");
		textFieldProductName.setText("");
		textFieldDescription.setText("");
		textFieldMinimumPrice.setText("");
		textFieldSalesPrice.setText("");
		textFieldSupplierPrice.setText("");
		lblTheresXItems.setVisible(false);
		lblTheresXItems.setText("");
		lblSuccesOrNot.setVisible(false);
		lblAddEdit.setText("Create product:");
	}
}
