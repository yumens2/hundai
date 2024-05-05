import java.util.Scanner;
import java.util.Random;
public class Main {
    static int first_randomNumber;
    static int second_randomNumber;
    static int third_randomNumber;
    public static Scanner scan = new Scanner(System.in);
    static void makeAttack(){
        System.out.print("숫자를 입력해주세요: ");
        int predict = scan.nextInt();
        System.out.println(first_randomNumber);
        System.out.println(second_randomNumber);
        System.out.println(third_randomNumber);

    }
    static void makeAns(){
        Random random = new Random();
        first_randomNumber = random.nextInt(10);
        second_randomNumber = random.nextInt(10);
        third_randomNumber = random.nextInt(10);

    }
    public static void main(String[] args) {
        makeAns();
        while (true) {
            makeAttack();
        }
    }
}
