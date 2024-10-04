package project.model;

import java.time.LocalDateTime;

/* 
 * This is a POJO to store Transaction History performed on an Account
 * Pending completion
 */

public class TransHistory {

    String txType;
    double amount;
    double balance;
    LocalDateTime dateTimeTx;

    public TransHistory(String txType, double amount, double balance, LocalDateTime dateTimeTx) {
        this.txType = txType;
        this.amount = amount;
        this.balance = balance;
        this.dateTimeTx = dateTimeTx;
    }

    public void printTx(){
        System.out.printf("%14s%n", "----------------------");
        System.out.printf(" | %-10s | %-4s | %n", txType, amount, balance, dateTimeTx);
        System.out.printf("%14s%n", "---------------------");
    }

    

}
