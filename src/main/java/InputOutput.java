import java.util.Scanner;

public class InputOutput {
    private Scanner scanner = new Scanner(System.in);
    public void startOutput() {
        System.out.print("숫자를 입력해 주세요 : ");
    }

    public void restartOutput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public String numberInput() {
        return scanner.nextLine();
    }

    public String yesOrNoInput() {
        return scanner.nextLine();
    }

    public void hitterResultOutput(int ballCnt, int strikeCnt) {
        if (ballCnt == 0 && strikeCnt == 0) {
            System.out.println("낫싱");
        } else if (ballCnt == 0 && strikeCnt != 0) {
            System.out.println(strikeCnt + "스트라이크");
        } else if (ballCnt != 0 && strikeCnt == 0) {
            System.out.println(ballCnt + "볼");
        } else {
            System.out.println(ballCnt + "볼 " + strikeCnt + "스트라이크");
        }
    }

}
