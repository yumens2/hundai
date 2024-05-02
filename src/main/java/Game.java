import java.util.Scanner;
public class Game {
    public static void main(String[] args) {
        String compNum = CreateNum.createNumbers();
        String userNum;
        String count;
        int choice = 1;
        boolean answer;

        Scanner sc = new Scanner(System.in);

        while(choice == 1) {
            System.out.println("숫자를 입력해주세요 : ");
            userNum = sc.nextLine();
        }
    }
}
