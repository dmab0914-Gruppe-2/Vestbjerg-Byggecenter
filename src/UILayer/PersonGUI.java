package UILayer;

/**
 * Person GUI and methods
 * 
 * @author Nicklas Welle
 * @version (01/02-2014) dd/mm-yyyy
 */
import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import CtrLayer.PersonController;
import ModelLayer.Person;

import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;

import javax.swing.JTabbedPane;
import javax.swing.JCheckBox;

@SuppressWarnings("serial")
public class PersonGUI extends JPanel {
	private JTextField textField_searchString;
	private JTextField textField_age;
	private JTextField textField_accountNumber;
	private JTextField textField_email;
	private JTextField textField_address;
	private JTextField textField_name;
	private JTextField textField_phone;
	private PersonController personController;
	private JRadioButton rdbtnTelephone;
	private JRadioButton rdbtnAccount;
	private JLabel label_status;
	private JLabel lblSave;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField_employeeName;
	private JTextField textField_employeeAddress;
	private JTextField textField_employeeEmail;
	private JTextField textField_employeePhone;
	private JTextField textField_employeeAge;
	private JTextField textField_employeeAccount;
	private JTextField textField_employeeTitle;
	private JTextField textField_employeeDepartment;
	private JCheckBox chckbxLeader;
	private JLabel lblEmployeeStatus;
	private JTabbedPane tabbedPaneCusEmp;
	private JPanel panel_editPerson;
	private JPanel panel_editEmployee;

	/**
	 * Create the panel.
	 */
	public PersonGUI() {
		personController = new PersonController();
		setPreferredSize(new Dimension(750, 500));
		setMinimumSize(new Dimension(750, 500));
		setLayout(new GridLayout(0, 1, 0, 0));
		setBackground(new Color(200, 221, 242));

		JLayeredPane layeredPane = new JLayeredPane();

		JPanel panel_findPerson = new JPanel();
		panel_findPerson.setBounds(10, 11, 190, 478);

		label_status = new JLabel("");

		JLabel label_1 = new JLabel("Find Person");

		rdbtnTelephone = new JRadioButton("Telephone");
		buttonGroup.add(rdbtnTelephone);
		rdbtnTelephone.setSelected(true);

		rdbtnAccount = new JRadioButton("Account");
		buttonGroup.add(rdbtnAccount);

		textField_searchString = new JTextField();
		textField_searchString.setColumns(10);

		JButton button_findPerson = new JButton("Find Person");
		button_findPerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String search = textField_searchString.getText().trim();

				@SuppressWarnings("unused")
				int a = 0;
				try {
					a = Integer.parseInt(search);

					if (search == null) {
						label_status.setText("Nothing entered!");
					} else if (rdbtnAccount.isSelected()) {
						Person myPerson = personController.findPerson(Integer
								.parseInt(search));
						if (myPerson != null) {
							if (personController.isCustomer(myPerson)) {
								resetPersonFields();
								textField_name.setText(myPerson.getName());
								textField_address.setText(myPerson.getAddress());
								textField_email.setText(myPerson.getEmail());
								textField_phone.setText(myPerson
										.getPhoneNumber());
								textField_age.setText(Integer.toString(myPerson
										.getAge()));
								textField_accountNumber.setText(Integer
										.toString(myPerson.getId()));
								label_status.setText("Customer found");
							} else {
								resetEmployeeFields();
								textField_employeeName.setText(myPerson
										.getName());
								textField_employeeAddress.setText(myPerson
										.getAddress());
								textField_employeeEmail.setText(myPerson
										.getEmail());
								textField_employeePhone.setText(myPerson
										.getPhoneNumber());
								textField_employeeAge.setText(Integer
										.toString(myPerson.getAge()));
								textField_employeeAccount.setText(Integer
										.toString(myPerson.getId()));
								textField_employeeTitle.setText(myPerson
										.getRole());
								textField_employeeDepartment.setText(myPerson
										.getDepartment());
								chckbxLeader.setSelected(myPerson.isLeader());
								label_status.setText("Employee found");
							}

						} else {
							label_status.setText("Nothing found");
						}
					}// elseIf
					else if (rdbtnTelephone.isSelected()) {
						Person myPerson = personController
								.findPersonByPhoneNumber(search);
						if (myPerson != null) {
							if (personController.isCustomer(myPerson)) {
								// TODO set active panels
								resetPersonFields();
								textField_name.setText(myPerson.getName());
								textField_address.setText(myPerson.getAddress());
								textField_email.setText(myPerson.getEmail());
								textField_phone.setText(myPerson
										.getPhoneNumber());
								textField_age.setText(Integer.toString(myPerson
										.getAge()));
								textField_accountNumber.setText(Integer
										.toString(myPerson.getId()));
								label_status.setText("Customer found");
							} else {
								resetEmployeeFields();
								textField_employeeName.setText(myPerson
										.getName());
								textField_employeeAddress.setText(myPerson
										.getAddress());
								textField_employeeEmail.setText(myPerson
										.getEmail());
								textField_employeePhone.setText(myPerson
										.getPhoneNumber());
								textField_employeeAge.setText(Integer
										.toString(myPerson.getAge()));
								textField_employeeAccount.setText(Integer
										.toString(myPerson.getId()));
								textField_employeeTitle.setText(myPerson
										.getRole());
								textField_employeeDepartment.setText(myPerson
										.getDepartment());
								chckbxLeader.setSelected(myPerson.isLeader());
								label_status.setText("Employee found");
							}

						} else {
							label_status.setText("Nothing found");
						}
					}// endIf
				} catch (NumberFormatException e) {
					label_status.setText("Invalid SearchString!");
				}
			}
		});
		GroupLayout gl_panel_findPerson = new GroupLayout(panel_findPerson);
		gl_panel_findPerson
				.setHorizontalGroup(gl_panel_findPerson
						.createParallelGroup(Alignment.LEADING)
						.addGap(0, 190, Short.MAX_VALUE)
						.addGroup(
								gl_panel_findPerson
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_panel_findPerson
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_findPerson
																		.createSequentialGroup()
																		.addComponent(
																				label_status,
																				GroupLayout.DEFAULT_SIZE,
																				362,
																				Short.MAX_VALUE)
																		.addContainerGap())
														.addGroup(
																gl_panel_findPerson
																		.createSequentialGroup()
																		.addGroup(
																				gl_panel_findPerson
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								gl_panel_findPerson
																										.createSequentialGroup()
																										.addComponent(
																												label_1,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE)
																										.addGap(33))
																						.addGroup(
																								gl_panel_findPerson
																										.createSequentialGroup()
																										.addComponent(
																												rdbtnTelephone,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE)
																										.addGap(14))
																						.addGroup(
																								gl_panel_findPerson
																										.createSequentialGroup()
																										.addComponent(
																												rdbtnAccount,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE)
																										.addGap(24))
																						.addGroup(
																								gl_panel_findPerson
																										.createSequentialGroup()
																										.addComponent(
																												textField_searchString,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												ComponentPlacement.RELATED,
																												3,
																												GroupLayout.PREFERRED_SIZE))
																						.addComponent(
																								button_findPerson,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE))
																		.addGap(283)))));
		gl_panel_findPerson.setVerticalGroup(gl_panel_findPerson
				.createParallelGroup(Alignment.LEADING)
				.addGap(0, 501, Short.MAX_VALUE)
				.addGroup(
						gl_panel_findPerson
								.createSequentialGroup()
								.addContainerGap()
								.addComponent(label_1,
										GroupLayout.PREFERRED_SIZE, 14,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(rdbtnTelephone,
										GroupLayout.PREFERRED_SIZE, 23,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(rdbtnAccount,
										GroupLayout.PREFERRED_SIZE, 23,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textField_searchString,
										GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(button_findPerson)
								.addGap(18)
								.addComponent(label_status,
										GroupLayout.PREFERRED_SIZE, 22,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(327, Short.MAX_VALUE)));
		panel_findPerson.setLayout(gl_panel_findPerson);
		add(layeredPane);
		layeredPane.setLayout(null);

		tabbedPaneCusEmp = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneCusEmp.setBounds(210, 11, 530, 478);
		layeredPane.add(tabbedPaneCusEmp);

		panel_editPerson = new JPanel();
		tabbedPaneCusEmp.addTab("Customer", null, panel_editPerson, null);

		JLabel lblAccountNumber = new JLabel("Account no.");

		JLabel lblPhoneNo = new JLabel("Phone no.");

		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textField_phone.getText().trim().length() == 8
						&& textField_age.getText().trim().length() <= 3) {
					String n = textField_name.getText();
					String a = textField_address.getText();
					String p = textField_phone.getText();
					String e = textField_email.getText();
					int i = Integer.parseInt(textField_age.getText());

					// personController.addCustomer(n, a, p, e, i);
					personController.addCustomer(n, a, p, e, i);

					resetPersonFields();
					lblSave.setText("Customer added!");
				} else {
					lblSave.setText("Phone no. or age is incorrect!");
				}
			}
		});

		JLabel lblName = new JLabel("Name");

		JLabel lblAddress = new JLabel("Address");

		JLabel lblEmail = new JLabel("Email");

		JLabel lblAge = new JLabel("Age");

		textField_age = new JTextField();
		textField_age.setColumns(10);

		textField_accountNumber = new JTextField();
		textField_accountNumber.setEditable(false);
		textField_accountNumber.setColumns(10);

		lblSave = new JLabel("");

		textField_email = new JTextField();
		textField_email.setColumns(10);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetPersonFields();
			}
		});

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletePerson();
			}
		});

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField_accountNumber.getText().trim();

				@SuppressWarnings("unused")
				int a = 0;
				try {
					a = Integer.parseInt(id);

					if (id == null) {
						lblSave.setText("No Person Opened");
					} else {
						Person myPerson = personController.findPerson(Integer
								.parseInt(id));
						if (myPerson != null) {
							myPerson.setName(textField_name.getText());
							myPerson.setAddress(textField_address.getText());
							myPerson.setEmail(textField_email.getText());
							myPerson.setPhoneNumber(textField_phone.getText());
							myPerson.setAge(Integer.parseInt(textField_age
									.getText()));
							lblSave.setText("Saved");
						}
					}
				} catch (NumberFormatException ne) {
					lblSave.setText("Invalid Person!");
				}
			}
		});

		textField_address = new JTextField();
		textField_address.setColumns(10);

		textField_name = new JTextField();
		textField_name.setColumns(10);

		textField_phone = new JTextField();
		textField_phone.setColumns(10);

		JLabel lblEditPerson = new JLabel("Create / Edit Customer");
		GroupLayout gl_panel_editPerson = new GroupLayout(panel_editPerson);
		gl_panel_editPerson
				.setHorizontalGroup(gl_panel_editPerson
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_editPerson
										.createSequentialGroup()
										.addGap(111)
										.addComponent(lblSave,
												GroupLayout.DEFAULT_SIZE, 357,
												Short.MAX_VALUE).addGap(57))
						.addGroup(
								gl_panel_editPerson
										.createSequentialGroup()
										.addGap(93)
										.addComponent(btnReset)
										.addGap(18)
										.addComponent(btnDelete)
										.addPreferredGap(
												ComponentPlacement.RELATED,
												176, Short.MAX_VALUE)
										.addComponent(btnSave).addGap(57))
						.addGroup(
								gl_panel_editPerson
										.createSequentialGroup()
										.addGap(10)
										.addComponent(lblEditPerson,
												GroupLayout.PREFERRED_SIZE,
												145, GroupLayout.PREFERRED_SIZE)
										.addGap(370))
						.addGroup(
								gl_panel_editPerson.createSequentialGroup()
										.addGap(10).addComponent(lblPhoneNo)
										.addGap(466))
						.addGroup(
								gl_panel_editPerson
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_panel_editPerson
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(btnCreate)
														.addComponent(lblName)
														.addComponent(
																lblAddress)
														.addComponent(lblEmail)
														.addComponent(lblAge)
														.addComponent(
																lblAccountNumber))
										.addGroup(
												gl_panel_editPerson
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_editPerson
																		.createSequentialGroup()
																		.addGap(18)
																		.addGroup(
																				gl_panel_editPerson
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								textField_name,
																								GroupLayout.PREFERRED_SIZE,
																								375,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								textField_address,
																								375,
																								375,
																								375)
																						.addComponent(
																								textField_email,
																								375,
																								375,
																								375)
																						.addComponent(
																								textField_phone,
																								375,
																								375,
																								375)
																						.addComponent(
																								textField_age,
																								111,
																								111,
																								111)))
														.addGroup(
																gl_panel_editPerson
																		.createSequentialGroup()
																		.addGap(18)
																		.addComponent(
																				textField_accountNumber,
																				GroupLayout.PREFERRED_SIZE,
																				111,
																				GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(57, Short.MAX_VALUE)));
		gl_panel_editPerson
				.setVerticalGroup(gl_panel_editPerson
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_editPerson
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(lblEditPerson)
										.addGap(33)
										.addGroup(
												gl_panel_editPerson
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(lblName)
														.addComponent(
																textField_name,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_panel_editPerson
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblAddress)
														.addComponent(
																textField_address,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_panel_editPerson
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(lblEmail)
														.addComponent(
																textField_email,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_panel_editPerson
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblPhoneNo)
														.addComponent(
																textField_phone,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_panel_editPerson
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(lblAge)
														.addComponent(
																textField_age,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_panel_editPerson
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblAccountNumber)
														.addComponent(
																textField_accountNumber,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(48)
										.addComponent(lblSave)
										.addPreferredGap(
												ComponentPlacement.RELATED,
												166, Short.MAX_VALUE)
										.addGroup(
												gl_panel_editPerson
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(btnCreate)
														.addComponent(btnReset)
														.addComponent(btnDelete)
														.addComponent(btnSave))
										.addContainerGap()));
		panel_editPerson.setLayout(gl_panel_editPerson);

		panel_editEmployee = new JPanel();
		tabbedPaneCusEmp.addTab("Employee", null, panel_editEmployee, null);

		JLabel lblCreateEdit = new JLabel("Create / Edit Employee");

		JLabel lbl_emp_name = new JLabel("Name");

		textField_employeeName = new JTextField();
		textField_employeeName.setColumns(10);

		textField_employeeAddress = new JTextField();
		textField_employeeAddress.setColumns(10);

		JLabel lbl_emp_address = new JLabel("Address");

		JLabel lbl_emp_email = new JLabel("Email");

		textField_employeeEmail = new JTextField();
		textField_employeeEmail.setColumns(10);

		JLabel lbl_emp_phoneno = new JLabel("Phone no.");

		textField_employeePhone = new JTextField();
		textField_employeePhone.setColumns(10);

		JLabel lbl_emp_age = new JLabel("Age");

		textField_employeeAge = new JTextField();
		textField_employeeAge.setColumns(10);

		JLabel lbl_emp_accountno = new JLabel("Account no.");

		textField_employeeAccount = new JTextField();
		textField_employeeAccount.setEditable(false);
		textField_employeeAccount.setColumns(10);

		JButton button_employeeCreate = new JButton("Create");
		button_employeeCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textField_employeePhone.getText().trim().length() == 8
						&& textField_employeeAge.getText().trim().length() <= 3) {
					String n = textField_employeeName.getText();
					String a = textField_employeeAddress.getText();
					String p = textField_employeePhone.getText();
					String e = textField_employeeEmail.getText();
					boolean l = chckbxLeader.isSelected();
					int i = Integer.parseInt(textField_employeeAge.getText());
					String r = textField_employeeTitle.getText();
					String d = textField_employeeDepartment.getText();

					personController.addWorker(n, a, p, e, i, l, r, d);

					resetEmployeeFields();

					lblEmployeeStatus.setText("Employee added!");
				} else {
					lblEmployeeStatus.setText("Phone no. or age is incorrect!");
				}
			}
		});

		JButton button_employeeReset = new JButton("Reset");
		button_employeeReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetEmployeeFields();
			}
		});

		JButton button_employeeDelete = new JButton("Delete");
		button_employeeDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteEmployee();
			}
		});

		JButton button_employeeSave = new JButton("Save");
		button_employeeSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField_employeeAccount.getText().trim();

				@SuppressWarnings("unused")
				int a = 0;
				try {
					a = Integer.parseInt(id);

					if (id == null) {
						lblEmployeeStatus.setText("No Person Opened");
					} else {
						Person myPerson = personController.findPerson(Integer
								.parseInt(id));
						if (myPerson != null) {
							myPerson.setName(textField_employeeName.getText());
							myPerson.setAddress(textField_employeeAddress.getText());
							myPerson.setEmail(textField_employeeEmail.getText());
							myPerson.setPhoneNumber(textField_employeePhone.getText());
							myPerson.setAge(Integer.parseInt(textField_employeeAge.getText()));
							myPerson.setRole(textField_employeeTitle.getText());
							myPerson.setDepartment(textField_employeeDepartment.getText());
							myPerson.setIsLeader(chckbxLeader.isSelected());
							// TODO
							
							
							lblEmployeeStatus.setText("Saved");
						}
					}
				} catch (NumberFormatException ne) {
					lblEmployeeStatus.setText("Invalid Person!");
				}

			}
		});

		chckbxLeader = new JCheckBox("Management rights");

		JLabel lbl_emp_title = new JLabel("Title/Role");

		JLabel lbl_emp_Department = new JLabel("Department");

		textField_employeeTitle = new JTextField();
		textField_employeeTitle.setColumns(10);

		textField_employeeDepartment = new JTextField();
		textField_employeeDepartment.setColumns(10);

		lblEmployeeStatus = new JLabel("");
		GroupLayout gl_panel_editEmployee = new GroupLayout(panel_editEmployee);
		gl_panel_editEmployee
				.setHorizontalGroup(gl_panel_editEmployee
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_editEmployee
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_panel_editEmployee
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																lbl_emp_name)
														.addComponent(
																lbl_emp_address)
														.addComponent(
																lbl_emp_email)
														.addComponent(
																lbl_emp_phoneno)
														.addComponent(
																lbl_emp_age)
														.addComponent(
																lbl_emp_Department)
														.addComponent(
																lbl_emp_accountno))
										.addGap(25)
										.addGroup(
												gl_panel_editEmployee
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																textField_employeeAccount,
																GroupLayout.PREFERRED_SIZE,
																111,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																textField_employeeDepartment,
																GroupLayout.DEFAULT_SIZE,
																375,
																Short.MAX_VALUE)
														.addComponent(
																textField_employeeTitle,
																GroupLayout.DEFAULT_SIZE,
																375,
																Short.MAX_VALUE)
														.addComponent(
																textField_employeePhone,
																GroupLayout.DEFAULT_SIZE,
																375,
																Short.MAX_VALUE)
														.addComponent(
																textField_employeeAge,
																GroupLayout.PREFERRED_SIZE,
																111,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																textField_employeeEmail,
																GroupLayout.PREFERRED_SIZE,
																375,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																textField_employeeAddress,
																GroupLayout.PREFERRED_SIZE,
																375,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																textField_employeeName,
																GroupLayout.PREFERRED_SIZE,
																375,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap(57, Short.MAX_VALUE))
						.addGroup(
								gl_panel_editEmployee.createSequentialGroup()
										.addGap(10).addComponent(chckbxLeader)
										.addGap(398))
						.addGroup(
								gl_panel_editEmployee.createSequentialGroup()
										.addContainerGap()
										.addComponent(lbl_emp_title)
										.addGap(470))
						.addGroup(
								gl_panel_editEmployee.createSequentialGroup()
										.addGap(10).addComponent(lblCreateEdit)
										.addGap(405))
						.addGroup(
								gl_panel_editEmployee
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(button_employeeCreate)
										.addGap(32)
										.addComponent(button_employeeReset,
												GroupLayout.PREFERRED_SIZE, 69,
												GroupLayout.PREFERRED_SIZE)
										.addGap(26)
										.addComponent(button_employeeDelete)
										.addPreferredGap(
												ComponentPlacement.RELATED,
												137, Short.MAX_VALUE)
										.addComponent(button_employeeSave,
												GroupLayout.PREFERRED_SIZE, 66,
												GroupLayout.PREFERRED_SIZE)
										.addGap(57))
						.addGroup(
								gl_panel_editEmployee.createSequentialGroup()
										.addContainerGap()
										.addComponent(lblEmployeeStatus)
										.addContainerGap(469, Short.MAX_VALUE)));
		gl_panel_editEmployee
				.setVerticalGroup(gl_panel_editEmployee
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_editEmployee
										.createSequentialGroup()
										.addGap(11)
										.addComponent(lblCreateEdit)
										.addGap(27)
										.addGroup(
												gl_panel_editEmployee
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_editEmployee
																		.createSequentialGroup()
																		.addGap(3)
																		.addComponent(
																				lbl_emp_name))
														.addComponent(
																textField_employeeName,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(6)
										.addGroup(
												gl_panel_editEmployee
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_editEmployee
																		.createSequentialGroup()
																		.addGap(3)
																		.addComponent(
																				lbl_emp_address))
														.addComponent(
																textField_employeeAddress,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(6)
										.addGroup(
												gl_panel_editEmployee
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_editEmployee
																		.createSequentialGroup()
																		.addGap(3)
																		.addComponent(
																				lbl_emp_email))
														.addComponent(
																textField_employeeEmail,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(6)
										.addGroup(
												gl_panel_editEmployee
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_editEmployee
																		.createSequentialGroup()
																		.addGap(3)
																		.addComponent(
																				lbl_emp_phoneno))
														.addComponent(
																textField_employeePhone,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(6)
										.addGroup(
												gl_panel_editEmployee
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																lbl_emp_age)
														.addComponent(
																textField_employeeAge,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_panel_editEmployee
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																lbl_emp_title)
														.addComponent(
																textField_employeeTitle,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(
												gl_panel_editEmployee
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																lbl_emp_Department)
														.addComponent(
																textField_employeeDepartment,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGroup(
												gl_panel_editEmployee
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_editEmployee
																		.createSequentialGroup()
																		.addGap(11)
																		.addComponent(
																				chckbxLeader)
																		.addGap(10)
																		.addComponent(
																				lbl_emp_accountno))
														.addGroup(
																gl_panel_editEmployee
																		.createSequentialGroup()
																		.addGap(41)
																		.addComponent(
																				textField_employeeAccount,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)))
										.addGap(18)
										.addComponent(lblEmployeeStatus)
										.addGap(79)
										.addGroup(
												gl_panel_editEmployee
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																button_employeeDelete)
														.addComponent(
																button_employeeSave)
														.addComponent(
																button_employeeReset)
														.addComponent(
																button_employeeCreate))
										.addGap(28)));
		panel_editEmployee.setLayout(gl_panel_editEmployee);
		layeredPane.add(panel_findPerson);

	}

	public void resetPersonFields() {
		textField_name.setText("");
		textField_address.setText("");
		textField_email.setText("");
		textField_phone.setText("");
		textField_age.setText("");
		textField_accountNumber.setText("");

	}

	public void resetEmployeeFields() {
		textField_employeeName.setText("");
		textField_employeeAddress.setText("");
		textField_employeeEmail.setText("");
		textField_employeePhone.setText("");
		textField_employeeAge.setText("");
		textField_employeeAccount.setText("");
		textField_employeeTitle.setText("");
		textField_employeeDepartment.setText("");
		chckbxLeader.setSelected(false);
	}

	public void deletePerson() {
		if (JOptionPane.showConfirmDialog(null,
				"Are you sure you want to delete this person?", "WARNING",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			if (textField_accountNumber.getText().trim().length() >= 1) {
				personController.removePersonById(Integer
						.parseInt(textField_accountNumber.getText().trim()));
				lblSave.setText("Account " + textField_accountNumber.getText()
						+ " has been deleted");
				resetPersonFields();
			} else {
				lblSave.setText("You must have a Customer open!");
			}

		} else {
			lblSave.setText("Delete cancelled");
		}
	}

	public void deleteEmployee() {
		if (JOptionPane.showConfirmDialog(null,
				"Are you sure you want to delete this person?", "WARNING",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			if (textField_employeeAccount.getText().trim().length() >= 1) {
				personController.removePersonById(Integer
						.parseInt(textField_employeeAccount.getText().trim()));
				lblEmployeeStatus.setText("Employee "
						+ textField_employeeAccount.getText()
						+ " has been deleted");
				resetEmployeeFields();
			} else {
				lblEmployeeStatus.setText("You must have a Employee open!");
			}

		} else {
			lblEmployeeStatus.setText("Delete cancelled");
		}
	}
}
