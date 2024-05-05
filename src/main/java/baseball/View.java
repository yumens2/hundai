package baseball;

import baseball.dto.RestartRequest;

import java.util.Scanner;

public class View {
    private static final Scanner scanner = new Scanner(System.in);
    // 숫자입력메세지
    public static String inputNumber() {
        System.out.print(OuputMessage.ASK_NUMBER.getMessage());
        return scanner.nextLine();
    }
    // 결과메세지
    public static void printResult(String result) {
        System.out.println(result);
    }
    public static void printEnd() {
        System.out.println(OuputMessage.END.getMessage());
    }

    public static RestartRequest askRestart() {
        System.out.println(OuputMessage.RESTART.getMessage());
        return RestartRequest.of(scanner.nextLine());
    }

    enum OuputMessage {
        END("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
        RESTART("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
        ASK_NUMBER("숫자를 입력해주세요 :");

        private String message;

        OuputMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
