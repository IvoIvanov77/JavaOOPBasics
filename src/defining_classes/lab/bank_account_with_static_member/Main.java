package defining_classes.lab.bank_account_with_static_member;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private  static Map<Integer, BankAccount2> accounts = new HashMap<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        while(!line.equalsIgnoreCase("end")){
            String[] cmdArgs = line.split("\\s+");
            String cmdType = cmdArgs[0];

            switch (cmdType){
                case "Create" :
                    execCreate();
                    break;
                case "Deposit" :
                    execDeposit(cmdArgs);
                    break;
                case "SetInterest" :
                    execSetInterest(cmdArgs);
                    break;
                case "GetInterest" :
                    tryGetInterest(cmdArgs);
                    break;

            }
            line = sc.nextLine();
        }

    }

    private static void tryGetInterest(String[] cmdArgs) {
        int id = Integer.parseInt(cmdArgs[1]);
        int years = Integer.parseInt(cmdArgs[2]);
        BankAccount2 account = getAccountById(id);
        if(account == null){
            return;
        }
        System.out.printf("%.2f%n", account.getInterest(years));

    }

    private static void execSetInterest(String[] cmdArgs) {
        double interest = Double.parseDouble(cmdArgs[1]);
        BankAccount2.setRate(interest);
    }


    private static void execCreate() {
        BankAccount2 bankAccount = new BankAccount2();
        accounts.put(bankAccount.getId(), bankAccount);
        System.out.printf("Account ID%d created%n", bankAccount.getId());

    }

    private static void execDeposit(String[] cmdArgs) {
        int id = Integer.parseInt(cmdArgs[1]);
        double amount = Double.parseDouble(cmdArgs[2]);
        BankAccount2 account = getAccountById(id);
        if(account == null){
            return;
        }
        account.deposit(amount);
        System.out.printf("Deposited %.0f to ID%d%n", amount, account.getId());


    }

    private static BankAccount2 getAccountById(int id) {
        if(accounts.containsKey(id)){
            return accounts.get(id);
        }
        System.out.println("Account does not exist");
        return null;
    }


}
