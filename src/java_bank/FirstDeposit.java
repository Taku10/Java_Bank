
package java_bank;

/**
 * Class represents first deposit that will be added to statement.
 * The first deposit will be added to an ArrayList 
 * @author tmadziwa
 */
public class FirstDeposit{
private double firstDeposit;



/**
     *Constructor parameter - takes in user first deposit as parameter
     * 
     * @param inFirstDeposit takes is the users deposit and sets it to first deposit data member
     */

    public FirstDeposit(double inFirstDeposit){
        firstDeposit = inFirstDeposit;
    }

  
    /**
      * Sets the deposit
      * @param firstDeposit takes in users deposit and sets it to deposit data member
      */
    public void setFirstDeposit(double firstDeposit) {
        this.firstDeposit = firstDeposit;
    }


    /**
     * Appends the first deposit data member with description for the bank statement
     * @return 
     */
    @Override
    public String toString() {
        
        
        return "First Deposit:" + " -------------------- " + " + " + firstDeposit;
    }
    
    
    
}
