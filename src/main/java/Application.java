import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        int qNum[] = makeNum();
        int pNum[] = playerInput();
    }

    public static int[] makeNum() {
        int num[] = new int[3];
        num[0] = (int)(Math.random() * 10);
        do {
            num[1] = (int)(Math.random() * 10);
        } while(num[0] == num[1]);
        do {
            num[2] = (int)(Math.random() * 10);
        } while(num[0] == num[2] || num[1] == num[2]);
        return num;
    }

    public static int[] playerInput() {
        int pNum[] = new int[3];
        System.out.print("숫자를 입력해 주세요 : ");
        Scanner input = new Scanner(System.in);
        String pInput = input.nextLine();
        pNum[0] = pInput.charAt(0) - '0';
        pNum[1] = pInput.charAt(1) - '0';
        pNum[2] = pInput.charAt(2) - '0';
        checkInput(pNum);
        return pNum;
    }

    public static void checkInput(int pNum[]) {
        for(int i : pNum) {
            if(i < 1 || i > 9)
                throw new IllegalArgumentException();
        }
        if(pNum[0] == pNum[1] || pNum[0] == pNum[2] || pNum[1] == pNum[2])
            throw new IllegalArgumentException();
    }
}
