package project.ui;

import project.model.Account;
import project.service.AccountSvc;
import project.util.BGColors;
import project.util.ScannerUtil;

/* 
 * This class provides the menu for user to create an account
 */

public class CreateAcMenu {

    public static void promptInputs(){
        String cName = null;
        String nric = null;
        String email = null;
        byte acType = 0;
        double amount = 0;

        System.out.println("---------------------");
        System.out.println("Create Account Options");
        System.out.println("---------------------");
        ScannerUtil.checkForHiddenInput();
        nric = ScannerUtil.promptForNextLine("Please key in NRIC of the Customer: ");
             
        cName = ScannerUtil.promptForNextLine("Please key in Customer Name for the Account: ");

        email = ScannerUtil.promptForNextLineWithValidation("Please key in email address: ", "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$","Please enter a valid email address");
        
        System.out.println("0: Savings Account");
        System.out.println("1: Current Account");
        acType = ScannerUtil.promptForByte("Please select Account Type for the Account: ",0,1);
        amount = ScannerUtil.promptForDoubleWithValidation("Please input deposit amount (min 500): ",500,Double.POSITIVE_INFINITY);

        //Create Account with Inputs
        Account newAc = AccountSvc.createAccount(acType, amount, cName, nric, email);
        System.out.println(BGColors.ANSI_YELLOW);
        System.out.println("New Account Created: ");
        newAc.displayAccountDetails();
        System.out.println(BGColors.ANSI_RESET);

    }

}
