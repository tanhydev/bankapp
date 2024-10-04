package project.util;

import java.util.Scanner;

/* 
 * This is a utility class which provides prompt for input from System.in using the java.util.Scanner class
 */

public class ScannerUtil {

    private static Scanner cScanner = null;


    /* This method is invoke in all the input methods to ensure that a single instance of Scanner has been initialized for proper operation */
    private static void initialize() {
        if (cScanner == null) {
            cScanner = new Scanner(System.in);
        }
    }

    /* This method is used to prompt for byte with the msg provided and validate that the value is between min and max value, both inclusive, provided in the parameters. It will continue to prompt till the correct value is provided */
    public static byte promptForByte(String msg, int min, int max) {
        byte choice = 0;
        boolean isOk = false;

        initialize();

        do {
            System.out.print(msg);
            if (cScanner.hasNextByte()) {
                choice = cScanner.nextByte();
                if (choice >= min && choice <= max) {
                    isOk = true;
                } else {
                    System.out.println("Please input a number between " + min + " and " + max);
                }

            } else {
                cScanner.next(); // consume the invalid input
                System.out.println("Please input a number between " + min + " and " + max);
            }

        } while (!isOk);

        return choice;
    }

    /* This method is used to prompt for double value with the msg parameter provided without any validation */
    public static double promptForDouble(String msg) {
        double input = 0;
        boolean isOk = false;

        initialize();

        do {
            System.out.print(msg);
            if (cScanner.hasNextDouble()) {
                input = cScanner.nextDouble();
                isOk = true;
            } else {
                cScanner.next(); // consume the invalid input
                System.out.println("Please input a double value");
            }

        } while (!isOk);

        return input;

    }

    /* This method is used to check for hidden next line input that has not been consumed */
    public static void checkForHiddenInput(){

        initialize();

        if(cScanner.hasNextLine()){
            cScanner.nextLine();
        }
    }

    /* This method is used to prompt for a line input with the msg parameter provided without any validation */
    public static String promptForNextLine(String msg) {

        initialize();

        System.out.print(msg); 
        String temp = cScanner.nextLine();
        return temp;
    }

    /* This method is use to provide a pause to the output. User to press Enter to continue */
    public static void pause() {
        initialize();
        System.out.print("Press enter to continue: ");
        cScanner.nextLine();
    }

    /* This method is to be invoked before the program exits */
    public static void close() {
        if (cScanner != null) {
            cScanner.close();
            cScanner = null;
        }
    }

}
