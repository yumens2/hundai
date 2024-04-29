import java.util.Scanner;

public class InputNumberReceiver {

    public static String getInputNumber() {
        Scanner scanner = new Scanner(System.in);
        String inputNumber = scanner.next();
        scanner.close();
        return inputNumber;
    }

}
