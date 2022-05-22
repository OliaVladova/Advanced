package SoftUni.Advanced.DefiningClasses;

public class BankAccount {
    private int id;
    private double balance;
    private static double interestRate = 0.02;
    private static int accountCount = 1;

    public BankAccount() {
        this.id = accountCount++;
    }

    public  int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getAccountCount() {
        return accountCount;
    }

    public static void setAccountCount(int accountCount) {
        BankAccount.accountCount = accountCount;
    }


    public void deposit(double amount) {
        this.balance += amount;
    }

    public double getInterestRate(int years) {
        return BankAccount.interestRate * years * this.balance;
    }
    public static void setInterestRate(double interestRate){
       BankAccount.interestRate = interestRate;
    }
}
