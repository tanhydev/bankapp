package project.ui;

import project.model.Account;
import project.service.AccountSvc;
import project.util.BGColors;
import project.util.FontColors;
import project.util.ScannerUtil;

/* 
 * This provide the menu for to search by account number
 * If account is found, it provides a transaction menu which provides the following options:
 * Check Account Balance
 * Deposit Money
 * Withdraw Money
 * Display Transaction History
 * Delete Account
 * Back to Main Menu
 */

public class SearchAccountMenu {

    private static Account selectedAccount;

    public static void promptAcNumber() {

        System.out.println("---------------------------------");
        System.out.println("Individual Account Menu");
        System.out.println("---------------------------------");
        ScannerUtil.checkForHiddenInput();
        String acNumber = ScannerUtil.promptForNextLine("Please input account number: ");
        selectedAccount = AccountSvc.getAccount(acNumber);

        if (selectedAccount == null) {
            System.out.println("Account number " + acNumber + " does not exists");
        } else {
            System.out.println("Account has been found: ");
            System.out.println(BGColors.ANSI_YELLOW);
            selectedAccount.displayAccountDetails();
            System.out.println(BGColors.ANSI_RESET + "\n");

            boolean exitAcMenu = false;
            do {
                DispalyTxMenu();
                byte choice = ScannerUtil.promptForByte("Please enter choice: ", 1, 6);
                processTxOption(choice);
                if (choice == 5 || choice == 6) {
                    exitAcMenu = true;
                }
            } while (!exitAcMenu);
        }
    }

    private static void DispalyTxMenu() {
        System.out.println("---------------------------------");
        System.out.println("Transaction Menu");
        System.out.println("---------------------------------");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Show Transaction History");
        System.out.println("5. Delete Account");
        System.out.println("6. Back to Main Menu");
    }

    private static void processTxOption(byte c) {
        System.out.println("Option " + c + " has been selected");
        switch (c) {
            case 1:
                System.out.println("Current Balance: " + selectedAccount.getBalanceStr());
                break;
            case 2:
                // Deposit Money
                System.out.println("Current Balance: " + selectedAccount.getBalanceStr());
                double amount = ScannerUtil.promptForDouble("Please input amount to be deposited: ");
                selectedAccount.deposit(amount);
                System.out.println("Balance After Deposit: " + selectedAccount.getBalanceStr());
                break;
            case 3:
                // Withdraw Money
                System.out.println("Current Balance: " + selectedAccount.getBalanceStr());
                double wAmount = ScannerUtil.promptForDouble("Please input amount to be withdrawed: ");
                boolean success = selectedAccount.withdraw(wAmount);
                if (success) {
                    System.out.println("Balance After Withdrawal: " + selectedAccount.getBalanceStr());
                }
                break;
            case 4:
                selectedAccount.displayTxHistory();
                break;
            case 5:
                // Delete Account
                System.out.println("Deleting Account " + selectedAccount.getAcNumber());
                if (AccountSvc.removeAccount(selectedAccount)) {
                    System.out.println(FontColors.ANSI_GREEN);
                    System.out.println("Account " + selectedAccount.getAcNumber() + " has been removed successfully");
                    System.out.println(FontColors.ANSI_RESET);
                } else {
                    System.out.println(FontColors.ANSI_RED);
                    System.out.println("Problem in removing account");
                    System.out.println(FontColors.ANSI_RESET);
                }
                System.out.println("Returning to Main Menu");
                ScannerUtil.checkForHiddenInput();
                break;
            case 6:
                System.out.println("Returning to Main Menu");
                break;
            default:
                System.out.println("Invalid Option. Please provide a valid option.");
                break;
        }
    }

}
