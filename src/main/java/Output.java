public class Output {
    public static void printlnMessage(String message) {
        System.out.println(message);
    }

    public static void printMessage(String message) { System.out.print(message); }
    public static String printResult(int strikes, int balls) {
        if (strikes == 0 && balls == 0) {
            return "낫싱";
        }
        else {
            return (strikes + " 스트라이크, " + balls + " 볼");
        }
    }
}