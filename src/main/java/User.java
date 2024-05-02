import java.util.Scanner;

public class User {
    private String inputNum;

    public User() {}

    public String getInputNum() {
        return inputNum;
    }

    public void setInputNum() {
        Scanner scan = new Scanner(System.in);
        inputNum = scan.nextLine();
    }
}
