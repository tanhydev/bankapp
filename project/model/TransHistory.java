package project.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/* 
 * This is a POJO to store Transaction History performed on an Account
 * Pending completion
 */

public class TransHistory {

    private byte txType;
    private double amount;
    private double balance;
    private LocalDateTime dateTimeTx;

    public TransHistory(byte txType, double amount, double balance, LocalDateTime dateTimeTx) {
        this.txType = txType;
        this.amount = amount;
        this.balance = balance;
        this.dateTimeTx = dateTimeTx;
    }

    public byte getTxType() {
        return txType;
    }

    public void setTxType(byte txType) {
        this.txType = txType;
    }

    public double getAmount() {
        return amount;
    }

    public String getAmountStr(){
        return String.format("%,.2f", amount);
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    /* Provide String value of balance with thousand separator and 2 decimal format */
    public String getBalanceStr(){
        return String.format("%,.2f", balance);
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public LocalDateTime getTxLocalDateTime() {
        return dateTimeTx;
    }

    /* Provide Date of Transaction in dd-MM-yy format */
    public String getTxDate(){
        return dateTimeTx.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    /* Provide Date and Time of Transaction in dd-MM-yy hh:mm format */
    public String getTxDateTime(){
        return dateTimeTx.format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm"));
    }

    public void setDateTimeTx(LocalDateTime dateTimeTx) {
        this.dateTimeTx = dateTimeTx;
    }

    

    

    

}
