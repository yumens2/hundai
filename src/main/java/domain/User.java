package domain;

import util.Constants;
import java.util.Scanner;	

public class User {
    private final BaseballNumber userNumber;
    private final Scanner scanner;

    public User() {
        this.userNumber = new BaseballNumber();
        this.scanner = new Scanner(System.in);
    }

    public void inputUserNumber() {
        System.out.print(Constants.INPUT_PROMPT);
        userNumber.setNumber(scanner.nextLine());
    }

    public boolean wantToRestart() {
        System.out.print(Constants.RESTART_PROMPT);
        String input = scanner.nextLine();
        if ("1".equals(input)) {
            return true;
        } else if ("2".equals(input)) {
            return false;
        } else {
            throw new IllegalArgumentException("잘못된 입력값 입니다.");
        }
    }

    public BaseballNumber getUserNumber() {
        return userNumber;
    }

    public void closeScanner() {
      scanner.close();
  }
}