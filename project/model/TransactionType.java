package project.model;

/* 
 * This class provides details on account type, which is stored as a byte
 * The name is stored as an array and retrieve by public method getAccountType Name
 */

public class TransactionType {

    static final String[] acType = {"Open","Deposit", "Withdrawal", "Close"};

    public static String getTxTypeName(byte type){
        return acType[type];
    }
}
