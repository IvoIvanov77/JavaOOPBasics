package defining_classes.lab.bank_account_with_static_member;

public class BankAccount2 {

    private final static double DEFAULT_INTEREST = 0.02;

    private static double rate= DEFAULT_INTEREST;
    private static int bankAccountCount;
    private int id;
    private double balance;


    BankAccount2() {
        this.id = ++bankAccountCount;
    }

    int getId() {
        return id;
    }

    static void setRate(double interest) {
        rate = interest;
    }


    void deposit(double amount){
        if(amount > 0){
            this.balance += amount;
        }

    }

    double getInterest(int years){
        return this.balance * rate * years;
    }

    @Override
    public String toString() {
        return String.format("Account ID%d, balance %.2f", this.id, this.balance);
    }
}

