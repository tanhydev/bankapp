package project.ui;

import java.io.IOException;

import project.service.AccountSvc;
import project.util.BGColors;
import project.util.FontColors;
import project.util.ScannerUtil;

/* 
 * This is the main class whereby the application starts.
 * It will display the main menu options
 */

public class MainMenu {

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        byte choice = 0;
        displayOptions();
        choice = ScannerUtil.promptForByte("Your Option: ",1, 5);
        processOptions(choice);
    }

    public static void displayOptions() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("---------------------");
        System.out.println(FontColors.ANSI_BLUE+"Main Menu Options"+FontColors.ANSI_RESET);
        System.out.println("---------------------");
        System.out.println("Choose from the options");
        System.out.println("---------------------"+BGColors.ANSI_GREEN);
        System.out.println("1. Open Account");
        System.out.println("2. View Accounts");
        System.out.println("3. Account Operations By Account Number");
        System.out.println("4. Exit"+BGColors.ANSI_RESET);
    }

    public static void processOptions(byte c){
        System.out.println("Option "+c+" has been selected");
        switch(c){
            case 1:
                CreateAcMenu.promptInputs();
                ScannerUtil.checkForHiddenInput();
                break;
            case 2:
                AccountSvc.displayAllAccounts();
                ScannerUtil.checkForHiddenInput();
                break;
            case 3:
                SearchAccountMenu.promptAcNumber();
                break;
            case 4:
                System.out.println("Exiting the Program. Good bye.");
                ScannerUtil.close();
                System.exit(0);
                break;
            case 5:
                System.out.println("Hidden Option: Inserting Dummy Records");
                AccountSvc.insertDummyRecords();
                ScannerUtil.checkForHiddenInput();
                break;
            default:
                System.out.println("Invalid Option. Please provide a valid option.");
                break;
        }
        if(c!=4){
            ScannerUtil.pause();           
            start();
        }
    }


}
