package project.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import project.util.BGColors;
import project.util.FontColors;

/* 
 * This is a POJO used to store Account Details
 * It has a reference to a Customer object
 * It has a method to print account details
 */

public class Account {

    private String acNumber;
    private byte acType;
    private double balance;
    private Customer customer;
    private LocalDateTime creationDateTime;
    private List<TransHistory> txHistory;
    private byte status;

    public Account() {
        customer = new Customer();
        txHistory = new ArrayList<>();
        status = 1;
    }

    

    public String getStatus() {
        return AccountStatus.getStatus(status);
    }


    public void suspendAccount() {
        this.status = 2;
    }

    public void closeAccount(){
        this.status = 0;
    }



    public String getAcNumber() {
        return acNumber;
    }

    public void setAcNumber(String acNumber) {
        this.acNumber = acNumber;
    }

    public byte getAcType() {
        return acType;
    }

    public void setAcType(byte acType) {
        this.acType = acType;
    }

    public double getBalance() {
        return balance;
    }

    public String getBalanceStr(){
        return String.format("%,.2f", balance);
    }

    public void deposit(double amount) {
        
        this.balance += amount;
        txHistory.add(new TransHistory((byte) 1, amount, balance, LocalDateTime.now()));
    }

    public boolean withdraw(double amount) {
        boolean success = false;
        if (balance >= amount) {
            this.balance -= amount;
            txHistory.add(new TransHistory((byte) 2, amount, balance, LocalDateTime.now()));
            success = true;
        } else {
            System.out.println(FontColors.ANSI_RED);
            System.out.println("Withdrawal amount " + String.format("%,.2f", amount) + " is greater than balance " + getBalanceStr());
            System.out.println(FontColors.ANSI_RESET);
        }
        return success;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomerName(String name) {
        customer.setFname(name);
        ;
    }

    public void setCustomerNric(String nric) {
        customer.setNric(nric);
    }

    public void setCustomerEmail(String email) {
        customer.setEmail(email);
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public void addTxHistory(TransHistory tx) {
        txHistory.add(tx);
    };

    public void displayTxHistory() {
        int count = 1;

        System.out.println(BGColors.ANSI_YELLOW);
        System.out.printf("%40s%n", "------------------------------------------------------------------------");
            System.out.printf("| %-4s | %-10s | %-17s | %-17s| %-10s|%n", "S/N","Tx Type", "Amount", "Balance", "Date");
            System.out.printf("%40s%n", "------------------------------------------------------------------------");
        for (TransHistory th : txHistory) {
            System.out.printf("| %-4s | %-10s | %-17s | %-17s| %-10s|%n", count,TransactionType.getTxTypeName(th.getTxType()), th.getAmountStr(), th.getBalanceStr(),
                    th.getTxDate());
            System.out.printf("%40s%n", "------------------------------------------------------------------------");
            count++;
        }
        System.out.println(BGColors.ANSI_RESET);
    }

    public void displayAccountDetails() {
        System.out.println("Account Details:");
        System.out.println("Account No: " + acNumber);
        System.out.println("Account Type: " + AccountType.getAccountTypeName(acType));
        System.out.println("Customer Name: " + customer.getFname());
        System.out.println("Customer NRIC:" + customer.getNric());
        System.out.println("Customer Email: " + customer.getEmail());
        System.out.println("Balance: " + getBalanceStr());
        System.out.println("Creation Date: " + creationDateTime);
    }

}
