package CtrLayer;
import ModelLayer.*;

/**
 * Controller for anythign related to Person management.
 * 
 * @author Jacob Pedersen
 * @version (11-12-2014) dd-mm-yyyy
 */
public class PersonController
{
    private PersonContainer personContainer;
    /**
     * Constructor for objects of class PersonController
     */
    public PersonController()
    {
        personContainer = PersonContainer.getPersonContainer();
        addTestPeople();
    }

    /**
     * Create a new worker and add it to the person container.
     * @param   name    the workers name.
     * @param   adress  the workes adress.
     * @param   phoneNumber the workes phone number.
     * @param   email   The workers e-mail.
     * @param   age     The workers age.
     * @param   isLeader    if the worker is a leader or not.
     * @param   role    The workes role in the company
     * @param   department  The department which the worker works in.
     * @return  true if the worker was added successfully. false if not.
     */
    public boolean addWorker(String name, String adress, String phoneNumber, String email, int age, boolean isLeader, String role, String department)
    {
        if(personContainer.findPersonByPhoneNumber(phoneNumber) == null)
        {
            int id = personContainer.getLastId() + 1;
            Worker worker = new Worker(id, name, adress, phoneNumber, email, age, isLeader, role, department);
            personContainer.addWorker(worker);
            return true;
        }
        return false;
    }

    /**
     * Create a new customer and add it to the person container.
     * @param   name    the customers name.
     * @param   adress  the customers adress.
     * @param   phoneNumber the customers phone number.
     * @param   email   The customers e-mail.
     * @param   age     The customers age.
     * @return  true if the worker was added successfully. false if not.
     */
    public boolean addCustomer(String name, String adress, String phoneNumber, String email, int age)
    {
        if(personContainer.findPersonByPhoneNumber(phoneNumber) == null)
        {
            int id = personContainer.getLastId() + 1;
            Customer customer = new Customer(id, name, adress, phoneNumber, email, age);
            personContainer.addCustomer(customer);
            return true;
        }
        return false;
    }

    /**
     * Remove a specific person given by it's id.
     * @param   id  The persons id.
     * @return  true if the person was removed successfully. false if not.
     */
    public boolean removePersonById(int id)
    {
        return personContainer.removePerson(id);
    }

    /**
     * Remove a specific person given by it's phone number.
     * @param   phoneNumber  The persons phone number.
     * @return  true if the person was found successfully. false if not.
     */
    public boolean removePersonByPhoneNumber(String phoneNumber)
    {
        Person person = personContainer.findPersonByPhoneNumber(phoneNumber);
        if(person != null)
        {
            int id = person.getId();
            return personContainer.removePerson(id);
        }
        return false;
    }

    /**
     * Find a specific person by the given id.
     * @param   id  The persons id.
     * @return  The person if the person was found successfully. null if not.
     */
    public Person findPerson(int id)
    {
        return personContainer.findPersonById(id);
    }

    /**
     * Find a specific person by the given phone number.
     * @param   id  The persons phone number.
     * @return  The person if the person was found successfully. null if not.
     */
    public Person findPersonByPhoneNumber(String phoneNumber)
    {
        return personContainer.findPersonByPhoneNumber(phoneNumber);
    }
    
    /**
     * Checks if the person is of the type Customer or not
     * @param   person  The person to check.
     * @return  true if the person is of the type Customer. false if not.
     */
    public boolean isCustomer(Person person)
    {
        if(person instanceof Customer)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Add money to a customers balance.
     * @param   person  The customer to add the money to of the type person.
     * @param   amount  The amount to add to the custoemr.
     */
    public boolean addToCustomerBalanceById(Person person, double amount)
    {
        if(isCustomer(person))
        {
            Customer customer = (Customer)person;
            customer.addToBalance(amount);
            return true;
        }
        return false;
    }
    
    public void addTestPeople()
    {
    	addWorker("Hans", "Hansevej", "27834173", "gud@gudenet.dk", 20, true, "boss", "all");
    	addWorker("Jens", "Hansevej", "27834174", "guden@gudenet.dk", 20, true, "boss", "all");
    	addCustomer("Sofie", "Sofievej", "88888888", "sofie@sofienet.dk", 20);
    	
    }
}
