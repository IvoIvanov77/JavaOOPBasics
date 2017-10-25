package defining_classes.lab.bank_account;

public class BankAccount {

    private int id;
    private double balance;



    void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }


    void deposit(double amount){
        if(amount > 0){
            this.balance += amount;
        }

    }

    void withdraw(double amount) {
        if (amount < 0 || balance - amount < 0) {
            System.out.println("Insufficient balance");
            return;
        }
        this.balance -= amount;
    }

    @Override
    public String toString() {
        return String.format("Account ID%d, balance %.2f", this.id, this.balance);
    }
}

