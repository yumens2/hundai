import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        boolean flag = true;
        while(flag) {
            int qNum[] = makeNum();
            flag = playBall(qNum);
        }
    }

    public static boolean playBall(int qNum[]) {
        boolean flag = true;
        while(flag) {
            flag = compareNum(qNum, playerInput());
        }
        return chooseResume();
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

    public static boolean compareNum(int[] qNum, int[] pNum) {
        int s = 0, b = 0;
        for(int i=0; i<3; i++) {
            if(qNum[i] == pNum[i])
                s++;
        }
        if(qNum[0] == pNum[1] || qNum[0] == pNum[2])
            b++;
        if(qNum[1] == pNum[0] || qNum[1] == pNum[2])
            b++;
        if(qNum[2] == pNum[0] || qNum[2] == pNum[1])
            b++;
        if(s == 0 && b == 0) {
            System.out.println("낫싱");
        } else {
            if(b != 0) {
                System.out.print(b + "볼 ");
            }
            if(s != 0) {
                System.out.print(s + "스트라이크");
            }
            System.out.println();
        }
        if(s == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        }
        return true;
    }

    public static boolean chooseResume() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner input = new Scanner(System.in);
        String readLine = input.nextLine();
        if(readLine.equals("1")) {
            return true;
        } else if(readLine.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
