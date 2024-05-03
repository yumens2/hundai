import java.util.Scanner;

public class User {

    private Scanner scanner;
    private String useNumbers;

    public User() {
        this.scanner = new Scanner(System.in);
    }

    public String getUserInputNumbers() {

        useNumbers = scanner.nextLine();
        return useNumbers;
    }

}
