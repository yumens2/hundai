package precourse.input;

import java.util.Scanner;

public class ScannerInputManager implements InputManager{
    private final Scanner scanner;

    public ScannerInputManager(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String readLine() {
        return scanner.nextLine();
    }
}
