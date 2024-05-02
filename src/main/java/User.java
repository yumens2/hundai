import java.util.Scanner;

public class User {
    private String inputNum;
    private int retryOrFinish;

    public User() {}

    public String getInputNum() {
        return inputNum;
    }

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
     * retryOrFinish Setter
     */
    public void setRetryOrFinish() {
        Scanner scan = new Scanner(System.in);
        retryOrFinish = scan.nextInt();
    }
}
