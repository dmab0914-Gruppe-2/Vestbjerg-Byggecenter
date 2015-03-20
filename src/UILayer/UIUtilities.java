package UILayer;

/**
 * Utility class for user input and input validation for som e of the other UI classes.
 * 
 * @author Jacob Pedersen
 * @version (14-12-2014) dd-mm-yyyy
 */
public class UIUtilities
{
    /**
     * Constructor for objects of class UIUtilities
     */
    public UIUtilities()
    {
        //Not much to do here.
    }
    
    /**
     * Retrives user input from the keyboard.
     * @return  the user input from the keyboard.
     */
    public String stringInput()
    {
        return null;
    }
    
    /**
     * Waits for user input and makes sure it's valid as an integer. 
     * @return  The input if it can be parsed to an integer. 0 if not.
     */
    public int menuInput()
    {
        return 0;
    }
    
    /**
     * checks if the menuinput is an integer
     * @param   input   The input to validate.
     * @return  true if input can be parsed to an integer. false if not.
     */
    public boolean isInt(String input)
    {
        try
        {
            @SuppressWarnings("unused")
			int number = Integer.parseInt(input);
            return true;
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        //return true;
    }
    
    /**
     * checks if the menuinput is a double
     * @param   input   The input to validate.
     * @return  true if input can be parsed to a double. false if not.
     */
    public boolean isDouble(String input)
    {
        try
        {
            @SuppressWarnings("unused")
			double number = Double.parseDouble(input);
            return true;
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        //return true;
    }
}
