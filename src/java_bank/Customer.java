
package java_bank;

/**
 * Class representing the user's name and also the user's pin and confirmation pin
 * Also consists of three constant variables for pin validation
 * 
 * 
 * @author tmadziwa
 */


public class Customer {
    private String username;
    private int createPin;
    private int confirmPin;
    public static final int DIFF = 1;
    public static final int RANGE = 2;
    public static final int GOOD = 3;
    
    

    /**
     * Default Constructor - sets username to empty string and both createPin and confirmPin to 0
     */
    
    public Customer(){
        username = "";
        createPin = 0;
        confirmPin = 0;
    }

    /**
     * Gets username 
     * 
     * @return - the username for customer
     */
    public String getUsername() {
        return username;
    }

    
    /**
     * sets the username for the customer
     * 
     * @param username - takes in the user's name and is set to username
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
   

   /**
    *user creates a pin
    * 
    * @param createPin - takes in created pin and sets in to createPin
    */

    public void setCreatePin(int createPin) {
        this.createPin = createPin;
    }

    
    /**
     * users re-enters pin to confirm
     * 
     * @param confirmPin - takes in re-entered pin and sets it to confirmPin
     */
    public void setConfirmPin(int confirmPin) {
        this.confirmPin = confirmPin;
    }

    /**
     * gets an integer for pin validation
     * @return the DIIFF constant
     */
    public static int getDIFF() {
        return DIFF;
    }

    /**
     * gets an integer for pin validation
     * @return the RANGE constant
     */
    public static int getRANGE() {
        return RANGE;
    }
    
    
    
    
    /**
     * Checks if user enters name
     * @return - true if user enters name and false if user leaves the input empty
     */
    public boolean validateName(){
        
        return !username.equals("");
    }
    
    
    /**
     * checks if initial pin matches with confirmation
     * 
     * @return 
     */
    public int authenticatePin(){
        
        if(createPin != confirmPin){
            return DIFF;
        } else if (!(createPin > 999 && createPin < 10000)){
            return RANGE;
        } else{
            return GOOD;
        }
    }

   /**
    * Converts object to string.
    * @return the username
    */
    @Override
    public String toString() {
        
        return  username;
    }
    
    
    
    
    
}
