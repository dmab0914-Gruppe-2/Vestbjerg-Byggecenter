package ModelLayer;
import java.util.ArrayList;
import java.io.*;

/**
 * Write a description of class PersonContainer here.
 * 
 * @author Jacob Pedersen
 * @version (09-12-2014) dd-mm-yyyy
 */
@SuppressWarnings("serial")
public class PersonContainer implements Serializable
{
    private ArrayList<Person> persons;
    private static PersonContainer personContainer;
    
    /**
     * Constructor for objects of class PersonContainer
     */
    private PersonContainer()
    {
        persons = new ArrayList<Person>();
    }

    /**
     * Returns the PersonContainer singleton object.
     * @return The PersonContainer object.
     */
    public static synchronized PersonContainer getPersonContainer()
    {
        if(personContainer == null)
        {
            personContainer = new PersonContainer();
        }
        return personContainer;
    }

    /**
     * Adds the given worker to the container.
     * @param   worker  The worker object to be added.
     * @return  true if the worker was added. false if not.
     */
    public boolean addWorker(Worker worker)
    {
        persons.add(worker);
        if(persons.get(persons.size() - 1) == worker)
        {
            return true;
        }
        return false;
    }

    /**
     * Adds the given customer to the container.
     * @param   customer  The customer object to be added.
     * @return  true if the customer was added. false if not.
     */
    public boolean addCustomer(Customer customer)
    {
        persons.add(customer);
        if(persons.get(persons.size() - 1) == customer)
        {
            return true;
        }
        return false;
    }

    /**
     * Find the index position in the arraylist of the person witht the given id or phoneNumber if it exsist.
     * @param   id  Persons id.
     * @param   phoneNumber Persosns phone number.
     * @return  array index number if the person exists. Throws an ObjectNotFoundException() if not.
     */
    private int findPersonIndex(int id, String phoneNumber)
    {
        for(int i = 0; i < persons.size(); i++)
        {
            if(phoneNumber != null && phoneNumber.equals(persons.get(i).getPhoneNumber()))
            {
                return i;
            }
            else if(id != 0 && id == persons.get(i).getId())
            {
                return i;
            }
        }
        throw new ObjectNotFoundException();
    }

    /**
     * Finds the person with the specified id.
     * @param   id    The persons id.
     */
    public Person findPersonById(int id)
    {
        try
        {
            int i = findPersonIndex(id, null);
            return persons.get(i);
        }
        catch(ObjectNotFoundException e)
        {
            return null;
        }
    }

    /**
     * Finds the person with the specified phone number.
     * @param   phoneNumber    The persons phone number.
     */
    public Person findPersonByPhoneNumber(String phoneNumber)
    {
        try
        {
            int i = findPersonIndex(0, phoneNumber);
            return persons.get(i);
        }
        catch(ObjectNotFoundException e)
        {
            return null;
        }
    }

    /**
     * Removes the person with the specified id if the person exist.
     * @param   id  Persons id.
     * @return  true if person existed and is now removes. false if not.
     */
    public boolean removePerson(int id)
    {
        try
        {
            int i = findPersonIndex(id, null);
            persons.remove(i);
            return true;
        }
        catch(ObjectNotFoundException e)
        {
            return false;
        }
    }

    /**
     * Returns last persons id.
     * @return  last persons id in the container.
     */
    public int getLastId()
    {
        if(persons.size() > 0)
        {
            return persons.get(persons.size() - 1).getId();
        }
        return 0;
    }
}
