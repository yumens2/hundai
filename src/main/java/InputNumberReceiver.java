import java.util.Scanner;

public class InputNumberReceiver {

    public static String getInputNumber() throws IllegalStateException {
        Scanner scanner = new Scanner(System.in);
        String inputNumber = scanner.next();
        scanner.close();

        InputNumberValidator.isInputNumberCorrect(inputNumber);
        return inputNumber;
    }
}
