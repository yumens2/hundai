package kim.half.ui;

import java.util.Scanner;

public class InputScanner {

    private static Scanner scanner;

    public InputScanner(Scanner scanner) {
        InputScanner.scanner = scanner;
    }

    public static String scanInputNumbers() {
        scanner = new Scanner(System.in);

        OutputBuilder.printRequestNumberInput();
        return scanner.nextLine();
    }

    public static String scanResumeChoice() {
        scanner = new Scanner(System.in);

        OutputBuilder.printRequestResumeInput();
        return scanner.nextLine();
    }
}
