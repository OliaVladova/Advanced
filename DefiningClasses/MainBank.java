package SoftUni.Advanced.DefiningClasses;

import java.util.*;

public class MainBank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, BankAccount> accountsMap = new HashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] commands = input.split("\\s+");
            String result = "";
            switch (commands[0]){
                case "Create":
                    BankAccount account = new BankAccount();
                    accountsMap.put(account.getId(), account);
                    result = String.format("Account ID%d created" ,account.getId());
                    break;
                case "Deposit":
                    int acc = Integer.parseInt(commands[1]);
                    double money = Double.parseDouble(commands[2]);
                    if (accountsMap.containsKey(acc)) {
                        BankAccount neededAccount = accountsMap.get(acc);
                        neededAccount.deposit(money);
                        accountsMap.put(acc,neededAccount);
                        result = String.format("Deposited %.0f to ID%d", money,acc);
                    }else {
                        result = "Account does not exist";
                    }
                    break;
                case "SetInterest":
                    double newInterest = Double.parseDouble(commands[1]);
                    BankAccount.setInterestRate(newInterest);
                    break;
                case "GetInterest":
                    int accountId = Integer.parseInt(commands[1]);
                    int years = Integer.parseInt(commands[2]);
                    if (accountsMap.containsKey(accountId)){
                        BankAccount bankAccount = accountsMap.get(accountId);
                       double interest = bankAccount.getInterestRate(years);
                        result = String.format("%.2f",interest);
                    }else {
                        result = "Account does not exist";
                    }
                    break;
            }
            if (!result.isEmpty()) {
                System.out.println(result);
            }
            input = scanner.nextLine();
        }
    }
}
