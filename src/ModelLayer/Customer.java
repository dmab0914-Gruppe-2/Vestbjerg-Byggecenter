package ModelLayer;

/**
 * Write a description of class Customer here.
 * 
 * @author Jacob Pedersen
 * @version (09-12-2014) dd-mm-yyyy
 */
public class Customer extends Person
{
    private double balance; //Is allowed to be a negative number, as it's a way to wait with the payment until the next month.

    /**
     * Constructor for objects of class Customer
     * @param   id  persons id.
     * @param   name    Perosns name.
     * @param   adress  Persons adress.
     * @param   phoneNumber Persons phonenumber.
     * @param   email   Perons email.
     * @param   age persons age.
     */
    public Customer(int id, String name, String adress, String phoneNumber, String email, int age)
    {
        super(id, name, adress, phoneNumber, email, age);
        balance = 0;
    }

    /**
     * Increase the customers balance.
     * @param the ammoun to increase the balance with.
     */
    public void addToBalance(double balance)
    {
        this.balance += balance;
    }

    /**
     * Withdraw a certain amount from the customers balance.
     * @param   balance The ammount to be withdrawn.
     */
    public void withdrawFromBalance(double balance)
    {
            this.balance += balance;
    }

    /**
     * Get the custoemrs balance.
     * @return  The balance.
     */
    public double getBalance()
    {
        return balance;
    }
}
