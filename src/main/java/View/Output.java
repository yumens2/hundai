public class Output {
    //메시지 출력 기능
    public static void printMessage(String message) {
        System.out.println(message);
    }
    //결과 출력 기능
    public static void printResult(int strikes, int balls) {
        if (strikes == 0 && balls == 0) {
            printMessage("Nothing");
        } else {
            printMessage(strikes + " Strike(s), " + balls + " Ball(s)");
        }
    }
}