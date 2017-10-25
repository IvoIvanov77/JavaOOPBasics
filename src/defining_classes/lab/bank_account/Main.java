package defining_classes.lab.bank_account;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<Integer, BankAccount> accounts = new HashMap<>();

        String line = sc.nextLine();

        while(!line.equalsIgnoreCase("end")){
            String[] cmdArgs = line.split("\\s+");
            String cmdType = cmdArgs[0];

            switch (cmdType){
                case "Create" :
                    execCreate(cmdArgs, accounts);
                    break;
                case "Deposit" :
                    execDeposit(cmdArgs, accounts);
                    break;
                case "Withdraw" :
                    execWindrow(cmdArgs, accounts);
                    break;
                case "Print" :
                    execPrint(cmdArgs, accounts);
                    break;

            }
            line = sc.nextLine();
        }

    }

    private static void execCreate(String[] cmdArgs, Map<Integer, BankAccount> accounts) {
        int id = Integer.parseInt(cmdArgs[1]);

        if(accounts.containsKey(id)){
            System.out.println("Account already exists");
        }else{
            BankAccount account = new BankAccount();
            account.setId(id);
            accounts.put(id, account);
        }

    }

    private static void execDeposit(String[] cmdArgs, Map<Integer, BankAccount> accounts) {
        int id = Integer.parseInt(cmdArgs[1]);
        double amount = Double.parseDouble(cmdArgs[2]);
        BankAccount account = getAccountById(accounts, id);
        if(account != null){
            account.deposit(amount);
        }

    }

    private static BankAccount getAccountById(Map<Integer, BankAccount> accounts, int id) {
        if(accounts.containsKey(id)){
            return accounts.get(id);
        }
        System.out.println("Account does not exist");
        return null;
    }

    private static void execWindrow(String[] cmdArgs, Map<Integer, BankAccount> accounts) {
        int id = Integer.parseInt(cmdArgs[1]);
        double amount = Double.parseDouble(cmdArgs[2]);
        BankAccount account = getAccountById(accounts, id);
        if(account != null){
            account.withdraw(amount);
        }
    }

    private static void execPrint(String[] cmdArgs, Map<Integer, BankAccount> accounts) {
        int id = Integer.parseInt(cmdArgs[1]);
        BankAccount account = getAccountById(accounts, id);
        if(account != null){
            System.out.println(account);
        }
    }
}
