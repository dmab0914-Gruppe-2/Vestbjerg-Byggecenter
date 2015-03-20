package ModelLayer;


/**
 * Write a description of class Worker here.
 * 
 * @author Jacob Pedersen
 * @version (09-12-2014) dd-mm-yyyy
 */
public class Worker extends Person
{
    // instance variables 
    private boolean isLeader; //If the person is a leader or not
    private String role; //The persons role in the company
    private String department; //The department which the persons works in

    /**
     * Constructor for objects of class Worker
     * @param   id      the workers id.
     * @param   name    the workers name.
     * @param   adress  the workes adress.
     * @param   phoneNumber the workes phone number.
     * @param   email   The workers e-mail.
     * @param   age     The workers age.
     * @param   isLeader    if the worker is a leader or not.
     * @param   role    The workes role in the company
     * @param   department  The department which the worker works in.
     */
    public Worker(int id, String name, String adress, String phoneNumber, String email, int age, boolean isLeader, String role, String department)
    {
        super(id, name, adress, phoneNumber, email, age);
        
        this.isLeader = isLeader;
        this.role = role;
        this.department = department;
    }
    
    /**
     * Get the persons leader status.
     * @return The persons leader status.
     */
    public boolean isLeader()
    {
        return isLeader;
    }
    
    /**
     * Get the persons role.
     * @return The persons role.
     */
    public String getRole()
    {
        return role;
    }
    
    /**
     * Get the persons working department.
     * @return The persons working department.
     */
    public String getDepartment()
    {
        return department;
    }

    /**
     * Set the persons leader status.
     * @param   isLeader    True if the person gets promoted to leader. false if not.
     */
    public void setIsLeader(boolean isLeader)
    {
        this.isLeader = isLeader;
    }

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
}
