


package java_bank;

/**
 * Class representing user's first deposit(initialDeposit), the account balance and account number
 * @author tmadziwa
 */

public class Account {

    private double initialDeposit;
    private double balance;
    private String accountNumber;
    
    
    /**
     * Default Constructor - sets accountNumber to empty string and both initialDeposit and balance to 0
     */

    public Account() {
        initialDeposit = 0;
        balance = 0;
        accountNumber = "";

    }

   
    /**
     * Gets the account's first deposit(initialDeposit)
     * 
     * @return the initial deposit of the account
     */

    public double getInitialDeposit() {
        return initialDeposit;
    }
    
    /**
     * Sets the initial deposit for the account
     * 
     * @param initialDeposit the user's first deposit for the account 
     */

    public void setInitialDeposit(double initialDeposit) {
        this.initialDeposit = initialDeposit;
    }

    
    /**
     * Gets the balance 
     * 
     * @return the first deposit is added to the balance when user opens an account. 
     */
    public double getBalance() {
        double firstBalance = balance + initialDeposit;
        return firstBalance;
    }

    
    /**
     * Gets the account number
     * 
     * @return the account number for the account
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    
    /**
     * Sets the account number
     * 
     * @param accountNumber - takes the randomly generate number and sets it to accountNumber
     */
    
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Validates if user is entering an amount more or eqaul to 25
     * 
     * @return true or false
     */
    public boolean validateInitialDeposit() {
        return initialDeposit >= 25;
    }
    
    
    /**
     * adds deposit to the balance
     * 
     * @param userDeposit - takes in user's deposits and adds it to the balance 
     */
    
    public void deposit(double userDeposit) {
         balance =+userDeposit;
    }

    /**
     * subtracts amount from the balance
     * 
     * @param userWithdraw - takes in users withdrawal amount and subtracts it from the balance
     */
    
    public void withdraw(double userWithdraw) {
        
        
             balance -= userWithdraw;
        }
    
    
       
    
/**
 * Appends all the data members with descriptions and returns it
 * 
 * @return data members with descriptions
 */
    @Override
    public String toString() {
        return "First Deposit: " + initialDeposit + " Balance: "  + balance + "Account Number: " + accountNumber;
    }

}
