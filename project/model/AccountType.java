package project.model;

/* 
 * This class provides details on account type, which is stored as a byte
 * The name is stored as an array and retrieve by public method getAccountType Name
 */

public class AccountType {

    static String[] acType = {"Saving","Current"};

    public static String getAccountTypeName(byte type){
        return acType[type];
    }
}
