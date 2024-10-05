package project.model;

/* 
 * This class provides details on account type, which is stored as a byte
 * The name is stored as an array and retrieve by public method getAccountType Name
 */

public class AccountStatus {

    /* 0-Close, 1-Active, 2-Suspended */
    static String[] acStatus = {"Close","Active"};

    public static String getStatus(byte type){
        return acStatus[type];
    }
}
