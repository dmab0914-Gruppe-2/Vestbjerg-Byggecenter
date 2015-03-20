package ModelLayer;

/**
 * Abstract class Person - write a description of the class here
 * 
 * @author Jacob Pedersen
 * @version (09-12-2014) dd-mm-yyyy
 */
public abstract class Person {
	// instance variables
	private int id; // The persons id
	private String name; // The persons name
	private String address; // The persons address
	private String phoneNumber; // THe persons phone number
	private String email; // The persons e-mail
	private int age; // The persons age

	/**
	 * Constructor for objects of class Person
	 */
	public Person(int id, String name, String address, String phoneNumber,
			String email, int age) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.age = age;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Get the persons id.
	 * 
	 * @return The persons id.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Get the persons named.
	 * 
	 * @return The persons name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get the persons adress.
	 * 
	 * @return The persons adress.
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Get the persons phone number.
	 * 
	 * @return The persons phone number.
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Get the persons e-mail.
	 * 
	 * @return The persons e-amil.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Get the persons age.
	 * 
	 * @return The persons age.
	 */
	public int getAge() {
		return age;
	}

	/**
	 * DUMMY METHOD
	 * Method used to call getRole from subClass "worker"
	 * 
	 * @return the role/title of an employee/worker
	 */
	public String getRole() {
		return null;
	}

	/**
	 * DUMMY METHOD
	 * Method used to call getDepartmen from subClass "worker"
	 * 
	 * @return The persons working department.
	 */
	public String getDepartment() {
		return null;
	}

	/**
	 * DUMMY METHOD
	 * Method used to call getDepartmen from subClass "worker"
	 * 
	 * @return true if person is a leader / false if noget
	 */
	public boolean isLeader() {
		return false;
	}

	/**
	 * DUMMY METHOD
	 * Method used to set leader to subClass "worker"
	 * @param isLeader
	 */
	public void setIsLeader(boolean isLeader) {

	}

	/**
	 * DUMMY METHOD
	 * Method used to set role to subClass "worker"
	 * @param role
	 *            the role to set
	 */
	public void setRole(String role) {

	}

	/**
	 * DUMMY METHOD
	 * Method used to set Department to subClass "worker"
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
	}
}
