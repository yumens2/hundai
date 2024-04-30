import java.util.Scanner
public class User {
    private Scanner scanner;
    private String useNumbers;
    public User(){
        scanner = new Scanner(System.in);
    }

    public String getUserInputNumbers(){
        System.out.println("숫자를 입력해 주세요 : ");
        useNumbers = scanner.nextLine();
        return useNumbers;
    }

}
