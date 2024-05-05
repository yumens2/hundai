public class PrintInfo {
    private PrintInfo() {

    }
    public static boolean printResult(String count) {
        int strike = count.charAt(0) - '0';
        int ball = count.charAt(1) - '0';
        boolean result = false;
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }

        if (strike == 3) {
            result = true;
        }
        return result;
    }

    public static int userChoice() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        try {
            return InputException.inputChoice();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return 2;
        }
    }
}
