package project.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import project.model.Account;
import project.util.BGColors;

/* 
 * This class provides account related services:
 * 1) Provides account number to ensure uniqness
 * 2) Create Account Service, making use of Account and Customer objects
 * 3) Keep track of all accounts in the bank. Display all accounts when requested.
 * 4) Search for account base on account number
 * 5) Remove account
 */

public class AccountSvc {

    private static List<Account> accounts = new ArrayList<Account>();
    private static int noOfSavingAc = 0;
    private static int noOfCurrentAc = 0;

    public static String getSavingAcNo() {
        noOfSavingAc += 1;
        return (1 + String.format("%05d", noOfSavingAc));
    }

    public static String getCurrentAcNo() {
        noOfCurrentAc += 1;
        return (2 + String.format("%05d", noOfCurrentAc));
    }

    public static Account createAccount(byte acType, double amount, String cName, String nric, String email) {
        Account account = new Account();
        account.setAcType(acType);
        account.deposit(amount);
        account.setCustomerName(cName);
        account.setCustomerNric(nric);
        account.setCustomerEmail(email);
        account.setCreationDateTime(LocalDateTime.now());
        accounts.add(account);
        return account;
    }

    public static void displayAllAccounts() {
        if (accounts.size() > 0) {
            System.out.print("Displaying " + accounts.size() + " account");
            if (accounts.size() > 1) {
                System.out.println("s: ");
            } else {
                System.out.println(": ");
            }
            System.out.println("------------------");
            for (Account account : accounts) {
                System.out.println(BGColors.ANSI_YELLOW);
                account.displayAccountDetails();
                System.out.println(BGColors.ANSI_RESET);
                System.out.println("------------------");
            }
        }else{
            System.out.println("There are no accounts to be displayed!");
        }
    }

    public static Account getAccount(String acNum){
        Account foundAc = null;

        for(Account ac:accounts){
            if(ac.getAcNumber().equals(acNum)){
                foundAc = ac;
                break;
            };
        }

        return foundAc;
    }

    public static boolean removeAccount(Account ac){
        return accounts.remove(ac);
    }

}
