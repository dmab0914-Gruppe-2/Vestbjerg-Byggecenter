package UILayer;

/**
 * Sales GUI and methods
 * 
 * @author Andreas Reng Mogensen
 * @version (01/02-2014) dd/mm-yyyy
 */

import CtrLayer.*;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLayeredPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ModelLayer.Product;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;

@SuppressWarnings("serial")
public class SalesGUI extends JPanel {
	private JTable table;
	private UIUtilities utilities;
	private ProductController productController;
	private SalesController scon;
	@SuppressWarnings("unused")
	private JLabel label_totalCost = new JLabel("");
	private JLabel label_saleStatus = new JLabel("");

	private JTextField textField_barcode;
	private JTextField textField_paymentAmount;
	DefaultTableModel model;
	private JTextField textField_workerId;
	private JButton button_newSale;
	private final ButtonGroup buttonGroup_paymentMethod = new ButtonGroup();
	private final ButtonGroup buttonGroup_accountSearchMethod = new ButtonGroup();
	private JRadioButton radioButton_cash;
	private JRadioButton radioButton_account;
	private JRadioButton radioButton_accountNumber;
	private JRadioButton radioButton_telephoneNumber;
	private JTextField textField_accountSearch;
	private JLabel label_totalPrice = new JLabel("");

	/**
	 * Create the panel.
	 */
	public SalesGUI() {
		utilities = new UIUtilities();
		productController = new ProductController();
		productController.createTestProducts();
		scon = new SalesController();
		setPreferredSize(new Dimension(750, 500));
		setMinimumSize(new Dimension(750, 500));
		setBackground(new Color(200, 221, 242));
		setLayout(new GridLayout(0, 1, 0, 0));

		JLayeredPane layeredPane = new JLayeredPane();

		JPanel panel = new JPanel();

		JLabel label_barcode = new JLabel("Barcode");

		textField_barcode = new JTextField();
		textField_barcode.setColumns(10);

		JButton button_add = new JButton("Add");
		button_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addItem();
			}
		});

		JLabel label_paymentAmount = new JLabel("Payment amount");

		textField_paymentAmount = new JTextField();
		textField_paymentAmount.setColumns(10);

		JButton button_payment = new JButton("Payment");
		button_payment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				makePayment();
			}
		});

		radioButton_cash = new JRadioButton("Cash");
		buttonGroup_paymentMethod.add(radioButton_cash);

		radioButton_account = new JRadioButton("Account");
		buttonGroup_paymentMethod.add(radioButton_account);

		radioButton_accountNumber = new JRadioButton("Account number");
		buttonGroup_accountSearchMethod.add(radioButton_accountNumber);

		radioButton_telephoneNumber = new JRadioButton("Telephone number");
		buttonGroup_accountSearchMethod.add(radioButton_telephoneNumber);

		button_newSale = new JButton("New Sale");
		button_newSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				makeNewSale();
			}
		});

		textField_workerId = new JTextField();
		textField_workerId.setColumns(10);

		label_saleStatus = new JLabel("Empty");

		textField_accountSearch = new JTextField();
		textField_accountSearch.setColumns(10);

		JLabel lblAccountSearch = new JLabel("Account Search");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGap(10)
																.addGroup(
																		gl_panel.createParallelGroup(
																				Alignment.LEADING)
																				.addComponent(
																						label_barcode,
																						GroupLayout.PREFERRED_SIZE,
																						200,
																						GroupLayout.PREFERRED_SIZE)
																				.addGroup(
																						gl_panel.createSequentialGroup()
																								.addComponent(
																										textField_barcode,
																										GroupLayout.PREFERRED_SIZE,
																										108,
																										GroupLayout.PREFERRED_SIZE)
																								.addGap(6)
																								.addComponent(
																										button_add,
																										GroupLayout.PREFERRED_SIZE,
																										89,
																										GroupLayout.PREFERRED_SIZE))
																				.addGroup(
																						gl_panel.createSequentialGroup()
																								.addComponent(
																										button_newSale,
																										GroupLayout.PREFERRED_SIZE,
																										89,
																										GroupLayout.PREFERRED_SIZE)
																								.addGap(18)
																								.addComponent(
																										textField_workerId,
																										GroupLayout.PREFERRED_SIZE,
																										GroupLayout.DEFAULT_SIZE,
																										GroupLayout.PREFERRED_SIZE))))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addContainerGap()
																.addComponent(
																		label_saleStatus))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addContainerGap()
																.addComponent(
																		lblAccountSearch)
																.addGap(18)
																.addComponent(
																		textField_accountSearch,
																		GroupLayout.DEFAULT_SIZE,
																		114,
																		Short.MAX_VALUE))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addContainerGap()
																.addGroup(
																		gl_panel.createParallelGroup(
																				Alignment.LEADING)
																				.addComponent(
																						label_paymentAmount,
																						GroupLayout.PREFERRED_SIZE,
																						200,
																						GroupLayout.PREFERRED_SIZE)
																				.addGroup(
																						gl_panel.createSequentialGroup()
																								.addComponent(
																										textField_paymentAmount,
																										GroupLayout.PREFERRED_SIZE,
																										GroupLayout.DEFAULT_SIZE,
																										GroupLayout.PREFERRED_SIZE)
																								.addGap(8)
																								.addComponent(
																										button_payment,
																										GroupLayout.PREFERRED_SIZE,
																										89,
																										GroupLayout.PREFERRED_SIZE))
																				.addComponent(
																						radioButton_cash,
																						GroupLayout.PREFERRED_SIZE,
																						109,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						radioButton_account,
																						GroupLayout.PREFERRED_SIZE,
																						109,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						radioButton_accountNumber,
																						GroupLayout.PREFERRED_SIZE,
																						141,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						radioButton_telephoneNumber,
																						GroupLayout.PREFERRED_SIZE,
																						141,
																						GroupLayout.PREFERRED_SIZE))))
								.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addGap(10)
								.addComponent(label_barcode)
								.addGap(10)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGap(1)
																.addComponent(
																		textField_barcode,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE))
												.addComponent(button_add))
								.addGap(6)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(button_newSale)
												.addComponent(
														textField_workerId,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(label_saleStatus)
								.addGap(187)
								.addComponent(label_paymentAmount)
								.addGap(6)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGap(1)
																.addComponent(
																		textField_paymentAmount,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE))
												.addComponent(button_payment))
								.addGap(7)
								.addComponent(radioButton_cash)
								.addGap(3)
								.addComponent(radioButton_account)
								.addGap(3)
								.addComponent(radioButton_accountNumber)
								.addGap(2)
								.addComponent(radioButton_telephoneNumber)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(
														textField_accountSearch,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblAccountSearch))
								.addContainerGap()));
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();

		JScrollPane scrollPane = new JScrollPane();

		JLabel label_total = new JLabel("Total:");

		label_totalPrice = new JLabel("0");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1
				.setHorizontalGroup(gl_panel_1
						.createParallelGroup(Alignment.LEADING)
						.addGap(0, 440, Short.MAX_VALUE)
						.addGroup(
								gl_panel_1
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																scrollPane,
																GroupLayout.DEFAULT_SIZE,
																420,
																Short.MAX_VALUE)
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addComponent(
																				label_total,
																				GroupLayout.PREFERRED_SIZE,
																				40,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				label_totalPrice,
																				GroupLayout.PREFERRED_SIZE,
																				95,
																				GroupLayout.PREFERRED_SIZE)))
										.addContainerGap()));
		gl_panel_1
				.setVerticalGroup(gl_panel_1
						.createParallelGroup(Alignment.TRAILING)
						.addGap(0, 481, Short.MAX_VALUE)
						.addGroup(
								gl_panel_1
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(scrollPane,
												GroupLayout.PREFERRED_SIZE,
												417, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																label_total,
																GroupLayout.PREFERRED_SIZE,
																24,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																label_totalPrice,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addContainerGap()));
		/*
		 * table.setModel(new DefaultTableModel(new Object[][] {}, new String[]
		 * { "Product Name", "Amount", "Price", "Barcode" }));
		 */

		model = new DefaultTableModel(new Object[][] {}, new String[] {
				"Product Name", "Amount", "Price", "Barcode" });
		table = new JTable(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(118);
		scrollPane.setViewportView(table);
		panel_1.setLayout(gl_panel_1);
		add(layeredPane);
		GroupLayout gl_layeredPane = new GroupLayout(layeredPane);
		gl_layeredPane.setHorizontalGroup(gl_layeredPane.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_layeredPane
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 227,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 492,
								Short.MAX_VALUE).addGap(11)));
		gl_layeredPane
				.setVerticalGroup(gl_layeredPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								Alignment.TRAILING,
								gl_layeredPane
										.createSequentialGroup()
										.addGap(11)
										.addGroup(
												gl_layeredPane
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																panel_1,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																panel,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addGap(8)));
		layeredPane.setLayout(gl_layeredPane);

	}

	/**
	 * adds an item to the current sale and updates the new total
	 */
	public void addItem() {
		if (scon.isActive()) {
			if (textField_barcode.getText().equals("")) {
				label_saleStatus.setForeground(Color.RED);
				label_saleStatus.setText("No Barcode!");
			} else {
				Product p = productController.findProduct(textField_barcode
						.getText());
				if (p != null) {
					switch (scon.addItem(textField_barcode.getText())) {
					// Item counted
					case 1:
						boolean found = false;
						int i = 0;

						// PRODUCT NAME AMOUNT PRICE BARCODE
						while (!found && i < model.getRowCount()) {
							Object o = model.getValueAt(i, 3);
							if (o.equals(p.getBarcode())) {
								found = true;
								Object ob = model.getValueAt(i, 1);
								String s = ob.toString();
								int amount = 0;
								if (utilities.isInt(s)) {
									amount = Integer.parseInt(s);
								}
								amount++;

								model.setValueAt(amount, i, 1);

								label_saleStatus.setForeground(Color.green);
								label_saleStatus
										.setText("Item counted Successfully");
								updateTotal();

							} else {
								i++;
							}// endIf

						}// endWhile

						if (!found) {
							label_saleStatus.setForeground(Color.RED);
							label_saleStatus
									.setText("Item not found in JTable!");
						}

						break;
					// Item added
					case 2:

						model.addRow(new Object[] { p.getProductName(), 1,
								p.getSalesPrice(), p.getBarcode() });
						label_saleStatus.setForeground(Color.green);
						label_saleStatus.setText("Item added ");
						updateTotal();
						break;
					// Item not found
					case 3:
						label_saleStatus.setForeground(Color.red);
						label_saleStatus.setText("Sale already closed!");
						break;
					case 0:
						label_saleStatus.setForeground(Color.red);
						label_saleStatus.setText("Item not found!");
						break;

					}// endSwitch
				}// endIf
			}// endIf
		} else {
			label_saleStatus.setForeground(Color.red);
			label_saleStatus.setText("Current sale not active!");
		}// endIf
	}// endMethod

	/**
	 * Method which sets the label total cost to the total cost of the current
	 * sale
	 */
	public void updateTotal() {
		String s = Double.toString(scon.getTotal());
		label_totalPrice.setText(s);
	}// endMethod

	/**
	 * Initializes a new sale with a worker id.
	 */
	public void makeNewSale() {
		if (utilities.isInt(textField_workerId.getText().trim())
				&& !textField_workerId.getText().trim().equals("")) {
			String s = textField_workerId.getText().trim();
			int i = Integer.parseInt(s);
			scon.makeNewSale(i);
			label_saleStatus.setForeground(Color.GREEN);
			label_saleStatus.setText("New sale Successfully made");
		} else {
			label_saleStatus.setForeground(Color.RED);
			label_saleStatus.setText("ERROR: No worker id OR not a number");
		}// endIf
	}// endMethod

	/**
	 * Checks if everything is in order and initializes the payment
	 */
	public void makePayment() {
		boolean success = false;
		if (radioButton_account.isSelected()) {
			if (radioButton_accountNumber.isSelected()) {
				int accountNumber = 0;
				String s = textField_accountSearch.getText();
				if (utilities.isInt(s)) {
					accountNumber = Integer.parseInt(s);
				} else {
					label_saleStatus.setForeground(Color.red);
					label_saleStatus.setText("Not a number!");
				}// endIf

				if (scon.makePaymentAccount(accountNumber)) {
					label_saleStatus.setForeground(Color.green);
					label_saleStatus
							.setText("Amount deducted from account funds");
					scon.closeSale();
					success = true;
				} else {
					label_saleStatus.setForeground(Color.RED);
					label_saleStatus.setText("Fund deduction failed!");
				}
			} else if (radioButton_telephoneNumber.isSelected()) {
				String s = textField_accountSearch.getText();
				if (scon.makePaymentPhone(s)) {
					label_saleStatus.setForeground(Color.GREEN);
					label_saleStatus.setText("Payment successful");
					scon.closeSale();
					success = true;
				} else {
					label_saleStatus.setForeground(Color.RED);
					label_saleStatus.setText("Payment unsuccessful!");
				}// endIf
			} else {
				label_saleStatus.setForeground(Color.RED);
				label_saleStatus.setText("No Search Selected!");
			}// endIf
		} else if (radioButton_cash.isSelected()) {
			double price = scon.getTotal();
			String s = textField_paymentAmount.getText();
			double total = Double.parseDouble(s);
			if (total >= price) {
				label_saleStatus.setForeground(Color.GREEN);
				label_saleStatus.setText("Payment successful!");
				scon.closeSale();
				success = true;
			} else {
				label_saleStatus.setForeground(Color.red);
				label_saleStatus.setText("Not enough money!");
			}// endIf
		} else {
			label_saleStatus.setForeground(Color.red);
			label_saleStatus.setText("No Payment Method!");
		}// endIf

		if (success) {
			textField_barcode.setText("");
			textField_workerId.setText("");
			label_totalPrice.setText("0");
			int rowCount = model.getRowCount();
			for (int i = rowCount - 1; i >= 0; i--)
				model.removeRow(i);
			double d = scon.getTotal();
			double cb = 0;
			String paymentAmount = textField_paymentAmount.getText();
			if (utilities.isInt(paymentAmount) || utilities.isDouble(paymentAmount)) {
				String s = textField_paymentAmount.getText().trim();
				double p = Double.parseDouble(s);
				cb = d - p;
			}
			String cback = Double.toString(cb);
			JOptionPane.showMessageDialog(null, "Cashback: " + cback);
			textField_paymentAmount.setText("");
		}// endIf
	}// endMethod
}// endClass
