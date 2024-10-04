package project.model;

import java.time.LocalDateTime;

import project.service.AccountSvc;
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

    public Account(){
        customer = new Customer();
    }

    public String getAcNumber() {
        return acNumber;
    }
    
    public byte getAcType() {
        return acType;
    }

    public void setAcType(byte acType) {
        this.acType = acType;
        if(acType == 0){
            acNumber = AccountSvc.getSavingAcNo();
        }else if(acType == 1){
            acNumber = AccountSvc.getCurrentAcNo();
        }
    }
    
    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public boolean withdraw(double amount){
        boolean success = false;
        if(balance>=amount){
            this.balance -= amount;
            success = true;
        }else{
            System.out.println(FontColors.ANSI_RED);
            System.out.println("Withdrawal amount "+String.format("%.2f",amount)+" is greater than balance "+ String.format("%.2f",balance));
            System.out.println(FontColors.ANSI_RESET);
        }
        return success;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomerName(String name) {
        customer.setFname(name);;
    }

    public void setCustomerNric(String nric){
        customer.setNric(nric);
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public void displayAccountDetails(){
        System.out.println("Account Details:");
        System.out.println("Account No: "+acNumber);        
        System.out.println("Account Type: "+AccountType.getAccountTypeName(acType));       
        System.out.println("Customer Name: "+customer.getFname());
        System.out.println("Customer NRIC:" + customer.getNric());
        System.out.println("Balance: "+ String.format("%.2f",balance));
        System.out.println("Creation Date: "+creationDateTime);
    }
    

    

}
