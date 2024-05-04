import java.util.Scanner;

public class User {
    private String inputNum;        // 유저 추측 입력 값
    private int retryOrFinish;      // 재시작/종료 선택 입력 값

    public User() {}

    public String getInputNum() {
        return inputNum;
    }

    /**
     * 유저로부터 추측한 숫자를 입력받는 메서드
     */
    public void setInputNum() {
        Scanner scan = new Scanner(System.in);
        inputNum = scan.nextLine();
    }

    /**
     * retryOrFinish Getter
     * @return 재시도이면 1, 종료이면 2
     */
    public int chooseRetryOrFinish() {
        return retryOrFinish;
    }

    /**
     * 유저로부터 재시작/종료에 대한 입력을 받는 메서드
     */
    public void setRetryOrFinish() {
        Scanner scan = new Scanner(System.in);
        retryOrFinish = scan.nextInt();
    }
}
