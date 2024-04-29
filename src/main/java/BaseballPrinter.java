public class BaseballPrinter {

    public static void printNumericInputMessage() {
        System.out.print("숫자를 입력해 주세요 : ");
    }

    public static void printBallCountHintMessage(int ballCount) {
        System.out.print(ballCount + "볼 ");
    }

    public static void printStrikeCountHintMessage(int strikeCount) {
        System.out.print(strikeCount + "스트라이크 ");
    }

    public static void printNothingHintMessage() {
        System.out.print("낫싱");
    }
}
