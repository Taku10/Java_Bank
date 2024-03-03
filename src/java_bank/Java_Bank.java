package java_bank;


import java.util.*;

public class Java_Bank {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // initialize Scanner for input
        Random rand = new Random(); //iniitalize Random to generate account number
        Account account = new Account(); //Initialize Account object then pass it through mehtods
        Customer customer = new Customer();//Initialize Customer object then pass it through mehtods
        

        ArrayList<Account> recordTransactions = new ArrayList<>(); //Initialize ArrayList to store transactions then pass it through mehtods

        
        //Call methods in main class
        String username = name(input, customer); 
        pin(input, customer);
        double firstDeposit = initialDeposit(input, recordTransactions, account);
        String accountNumber = createAccountNumber(rand);
        accountCreated(username, firstDeposit, accountNumber);
        displayMenu(input, username,accountNumber,recordTransactions, rand, account);

    }

    /**
     * Part of user registration process
     *
     * @param input - takes in the the user's name
     * @param customer takes in customer object 
     * @return the username
     */
    
    public static String name(Scanner input, Customer customer) {
        System.out.println("Welcome to JAVA BANK");
        System.out.println();
        System.out.println("Please register for your account");

        String name;
        
        do {
            System.out.println("Please enter your name.");
            name = input.nextLine();
            customer.setUsername(name);
            System.out.println();

            if (customer.validateName() == false) {
                System.out.println("Invalid Input");
            } else {
                System.out.println("Success");
            }
        } while (!customer.validateName());

        return customer.getUsername();

    }

    
    /**
     * Part of the registration process
     * user creates pin number of 4 digits and is validated
     * @param input takes in user's input(pin)
     * @param customer takes in customer object
     */
    public static void pin(Scanner input, Customer customer) {
        int pin = 0;
        int confirmPin = 0;
        int diff = Customer.DIFF;
        int range = Customer.RANGE;
        


        do {

            System.out.println("Create a 4-digit PIN");
            pin = input.nextInt();
            System.out.println();

            System.out.println("Confirm PIN");
            confirmPin = input.nextInt();
            System.out.println();

            customer.setCreatePin(pin);
            customer.setConfirmPin(confirmPin);
            //validate pin 
            if (customer.authenticatePin() == diff ) {
                System.out.println("Please make sure you're passwords match");
                System.out.println("Please try again");

                //check if user enters 4 digits
            } else if (customer.authenticatePin() == range) {
                System.out.println("PIN must be 4 digits ");
                System.out.println("Please try again");
                System.out.println();

            } else {
                System.out.println("PIN created!");
            }

        } while (customer.authenticatePin() == range || customer.authenticatePin() == diff);

    }
    
    /**
     * Part of registration process.
     * User deposit money to create account
     * @param input - takes in user's first deposit
     * @param recordTransactions takes in ArrayList that records the transactions
     * @param account takes in account object
     * @return the first deposit(initialDeposit)
     */

    public static double initialDeposit(Scanner input, ArrayList<Account> recordTransactions, Account account) {
        double initialDeposit;
        FirstDeposit toStatement; //define First Deposit class
        
        
        System.out.println("----------------------------------------------");
        do {

            System.out.println("Deposit $25 or more to activate your account");
            initialDeposit = input.nextDouble();

            account.setInitialDeposit(initialDeposit);
            
            
            
            //to FirstDeposit class
             toStatement = new FirstDeposit(initialDeposit);

            if (account.validateInitialDeposit() == false) {
                System.out.println("Sorry, you need to deposit $25 or more");
            }
        } while (account.validateInitialDeposit() == false);

        //add to ArrayList
        recordTransactions.add(toStatement);

        
        return account.getInitialDeposit();

    }

    //generates account number and returns a string
    private static String createAccountNumber(Random rand) {

        //the account number is 10 digits
        //account number must start with 09(prefix)
        String accPrefix = "09";
        long low = 10000000L;
        long high = 99999999L;

        //generate the last 8 numbers for the account number(suffix)
        long accSuffix = rand.nextLong(high - low + 1) + low;

        //concatenate the accPrefix with the accSuffix.
        String accountNumber = " " + accPrefix + accSuffix;

        return accountNumber;
    }

    //Displays new account number and initial account balance
    private static void accountCreated(String username, double deposit, String accountNumber) {
        //Print account balance

        System.out.println();
        System.out.println("Hi " + username + ". Your account was successfully created.");
        System.out.println("Thank you for choosing JAVA BANK");
        System.out.println();
        System.out.println("ACCOUNT BALANCE: " + "$" + deposit);

        System.out.println("ACCOUNT NUMBER: " + accountNumber);
        System.out.println();
    }
    
    private static void displayMenu(Scanner input, String username, String accountNumber, ArrayList recordTransactions, Random rand, Account account){
         int menuChoice = 0;

        do {

            //displays the menu.Keep displaying menu until user selects cancel.
            System.out.println();
            System.out.println("SERVICES:");
            System.out.println("----------------------");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. View Balance");
            System.out.println("4. View Statement");
            System.out.println("5. Logout");
            System.out.println("----------------------");

            System.out.println("Please select service:");
            menuChoice = input.nextInt();
            System.out.println();
    
 //transaction is executed depending on users choice
            if (menuChoice == 1) {
                depositMoney(input, recordTransactions, accountNumber, account);

            } else if (menuChoice == 2) {
                withdrawMoney(input, recordTransactions, account);
              
            
            } else if (menuChoice == 3) {
                showBalance(username, accountNumber, account);
            
            } else if (menuChoice == 4) {
                statement(recordTransactions, username, accountNumber);
            } else if (menuChoice == 5) {
                System.out.println("Succcesfully Logged out!");
                System.out.println("Thank you very very much " + username + " !");
                System.out.println();
            }
        } while (menuChoice != 5);
}
    
//Prompts user to enter amount to deposit, and returns the user input
    private static void depositMoney(Scanner input, ArrayList recordTransactions, String accountNumber, Account account) {
        
        Deposit toStatement;
        double userDeposit;
        System.out.println();
        System.out.println("DEPOSIT");
        System.out.println("==========================================");
        System.out.println("To Account: " + accountNumber);
        System.out.println();

        System.out.println("How much do you want to deposit?");
        userDeposit = input.nextDouble();
        
        account.deposit(userDeposit);

        System.out.println();

        System.out.println("YOU DEPOSITED: " + "$" + userDeposit);
        System.out.println();
        System.out.println("==========================================");
       toStatement = new Deposit(userDeposit);
        recordTransactions.add(toStatement);

        
    }

    //Prompts user to enter amount to withdraw, and returns the user input
    private static void withdrawMoney(Scanner input, ArrayList recordTransactions, Account account) {

        double userWithdraw = 0;
        Withdraw toStatement;
 
        double balance;
        
           
                do {

                    System.out.println("WITHDRAW");
                    System.out.println("==========================================");

                    System.out.println("How much do you want to withdraw?");
                    userWithdraw = input.nextDouble();
                    
                    account.withdraw(userWithdraw);
                    
                     balance = account.getBalance();
                    
                     toStatement = new Withdraw(userWithdraw);
                     recordTransactions.add(toStatement);

                    System.out.println();

                    if ( balance < userWithdraw) {
                        System.out.println("Insufficient funds to make this withdrawal");
                        System.out.println("CURRENT BALANCE: " + "$" + balance);
                        System.out.println();

                    } else {
                        System.out.println("YOU WITHDREW: " + userWithdraw);
                        System.out.println();
                        System.out.println("==========================================");
                    }
                } while (balance < userWithdraw);


 
        } 

    
    private static void showBalance(String name, String accountNumber, Account balance) {

        
        
        double newBalance = balance.getBalance();
        System.out.println();
        System.out.println(" VIEW BALANCE");
        System.out.println("==========================================");

        System.out.println("Account Holder Name: " + name);
        System.out.println("Account number: " + accountNumber);
        System.out.println();

        System.out.println("Balance: " + newBalance);
        System.out.println("==========================================");
        System.out.println();
        System.out.println();
    }
       
private static void statement(ArrayList recordTransactions, String username, String accountNumber){
    
        
        

        System.out.println();
        System.out.println("BANK STATEMENT");
        System.out.println("==============================================================================================================");
        System.out.println("Account holder: " + username);
        System.out.println("Account number: " + accountNumber);
        System.out.println();
        
        

    for(int i = 0; i < recordTransactions.size(); i++){
        System.out.println(recordTransactions.get(i));
        System.out.println();
    }
    
}


}

    

