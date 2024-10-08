package project.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import project.model.Account;
import project.model.TransHistory;
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

    private static String getSavingAcNo() {
        noOfSavingAc += 1;
        return (1 + String.format("%05d", noOfSavingAc));
    }

    private static String getCurrentAcNo() {
        noOfCurrentAc += 1;
        return (2 + String.format("%05d", noOfCurrentAc));
    }

    public static Account createAccount(byte acType, double amount, String cName, String nric, String email) {
        Account account = new Account();
        account.setAcType(acType);
        if(acType == 0){
            account.setAcNumber(getSavingAcNo());
        }else if(acType == 1){
            account.setAcNumber(getCurrentAcNo());
        }
        account.setCustomerName(cName);
        account.setCustomerNric(nric);
        account.setCustomerEmail(email);
        account.setCreationDateTime(LocalDateTime.now());
        
        TransHistory th = new TransHistory((byte)0, 0, account.getBalance(), LocalDateTime.now());
        account.addTxHistory(th);

        account.deposit(amount);
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

    public static void insertDummyRecords(){
        Account dummy1 = createAccount((byte) 0,1000, "Wong CK", "A123B", "Wong CK");
        dummy1.deposit(200);
        dummy1.withdraw(300);
        System.out.println("Dummy Accounts Created");
    }

}
