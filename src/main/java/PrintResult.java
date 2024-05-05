public class PrintResult {
    public static void printResult(int str, int ball) {
        // 입력받은 수의 결과 출력
        if (str + ball == 0) {
            System.out.println("낫싱");
            return;
        }

        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if (str > 0) {
            System.out.println(str + "스트라이크 ");
        } else {
            System.out.println();
        }
    }
}
