
package java_bank;

/**
 * Class represents deposit that will be added to statement.
 * The deposit will be added to the ArrayList 
 * @author tmadziwa
 */

public class Deposit{
    
    private double deposit;
    
    
    
    /**
     *Constructor parameter - takes in user deposit as parameter
     * 
     * @param inDeposit takes is the users deposit and sets it to deposit data member
     */
    
     public Deposit(double inDeposit){
        deposit = inDeposit;
    }

   
     /**
      * Sets the deposit
      * @param deposit takes in users deposit and sets it to deposit data member
      */

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    
    /**
     * Appends the deposit data member with description for the bank statement
     * @return 
     */
    @Override
    public String toString() {
        return "Deposit:" + " -------------------- " + " + " + deposit;
    }
     
     
     
     
    
    
    
    
}
