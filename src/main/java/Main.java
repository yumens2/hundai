import java.util.Scanner;
import java.util.Random;
public class Main {
    static int[] ansList = new int[10];
    public static Scanner scan = new Scanner(System.in);
    static void makeAttack(){
        System.out.print("숫자를 입력해주세요: ");
        int predict_Num = scan.nextInt();

    }
    static void makeAns(){
        Random random = new Random();
        for (int order = 0 ; order < 3 ; order++){
            int randomNumber = random.nextInt(10);
            ansList[randomNumber] = order;
        }
    }
    public static void main(String[] args) {
        makeAns();
        while (true) {
            makeAttack();
        }
    }
}
