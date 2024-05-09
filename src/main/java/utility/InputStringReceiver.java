package utility;

import java.util.Scanner;

public class InputStringReceiver {

    private static Scanner scanner;

    private InputStringReceiver() {}

    public static Scanner getInstance() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }

    public static void close() {
        if (scanner != null) {
            scanner.close();
            scanner = null;
        }
    }

    public static String getInputString() {
        return getInstance().nextLine();
    }
}
