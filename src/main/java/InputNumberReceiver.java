import java.util.Scanner;

public class InputNumberReceiver {

    public String getInputNumber() throws IllegalStateException {
        Scanner scanner = new Scanner(System.in);
        String inputNumber = scanner.next();
        return inputNumber;
    }
}
