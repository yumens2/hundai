package numberbaseballgame;

import java.util.Scanner;

public class UserInterface {

    private final static int REPLAY = 1;
    private final static int EXIT = 2;

    private static UserInterface instance = new UserInterface();

    private Computer computer = new Computer();
    private GameNumber userAnswer = new GameNumber();
    private boolean isGameOver = false;


    private UserInterface() {
    }

    public static UserInterface getInstance() {
        return instance;
    }

    private static boolean isStringInteger(String string) {
        for (int i = 0; i < string.length(); i++) {
            if ('9' < string.charAt(i) || string.charAt(i) < '0') {
                return false;
            }
        }
        return true;
    }

    private int returnUserInputAsIntType() throws IllegalArgumentException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (!isStringInteger(input)) {
            throw new IllegalArgumentException("숫자 형태가 아닙니다.");
        }
        return Integer.parseInt(input);
    }

    private boolean isUserAnswerValid() {
        if (userAnswer.isNumberInRange()) {
            return true;
        } else {
            return false;
        }
    }

    private void printHintMessage() {
        System.out.println(computer.returnHintString(userAnswer));
    }

    private void sendGameOverMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }


    private void getInputOnWhatToDo() throws IllegalArgumentException {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int userInput = returnUserInputAsIntType();
        switch (userInput) {
            case REPLAY:
                computer.setRandomAnswer();
                break;
            case EXIT:
                isGameOver = true;
                break;
            default:
                throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }
    }

    void processGame() throws IllegalArgumentException {
        System.out.print("숫자를 입력해 주세요 : ");
        userAnswer.setGameNumber(returnUserInputAsIntType());
        if (!isUserAnswerValid()) {
            throw new IllegalArgumentException("3자리 자연수가 아닙니다.");
        }
        printHintMessage();
        if (computer.isItAnswer(userAnswer)) {
            sendGameOverMessage();
            getInputOnWhatToDo();
        }
    }

    public void startGame() {
        while (!isGameOver) {
            try {
                processGame();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                isGameOver = true;
            }
        }
    }
}
