package precourse.input;

import java.util.Scanner;

public class ScannerInputManager implements InputManager{
    private final Scanner scanner;

    public ScannerInputManager() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String readLine() {
        return scanner.nextLine();
    }
}
