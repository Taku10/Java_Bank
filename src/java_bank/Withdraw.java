package java_bank;

/**
 * Class represents first deposit that will be added to statement. The first
 * deposit will be added to an ArrayList
 *
 * @author tmadziwa
 */
public class Withdraw {

    private double withdraw;

    /**
     * Constructor parameter - takes in user first deposit as parameter
     *
     * @param inWithdraw takes is the users deposit and sets it to first deposit
     * data member
     */
    public Withdraw(double inWithdraw) {
        withdraw = inWithdraw;
    }

    /**
     * Sets the withdrawal amount
     *
     * @param withdraw takes in users deposit and sets it to deposit data member
     */
    public void setWithdraw(double withdraw) {
        this.withdraw = withdraw;
    }

    /**
     * Appends the withdrawal data member with description for the bank
     * statement
     *
     * @return
     */
    @Override
    public String toString() {
        return "Withdraw:" + " -------------------- " + " - " + withdraw + "*";
    }

}
