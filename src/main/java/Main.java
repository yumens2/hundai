import java.util.Scanner;
public class Main {
    public static Scanner scan = new Scanner(System.in);
    static void makeAttack(){
        System.out.print("숫자를 입력해주세요: ");
        int predict = scan.nextInt();
    }
    public static void main(String[] args) {
        while (true) {
            makeAttack();
        }
    }
}
