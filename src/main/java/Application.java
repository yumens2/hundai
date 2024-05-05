import java.util.Random;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        int qNum[];
        do {
            boolean flag = true;
            qNum = makeNum();
            while(compareNum(qNum, playerInput())){};
        } while(restart());
    }

    public static int[] playerInput() {
        System.out.print("숫자를 입력해 주세요 : ");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();

        if(str.length() != 3)
            throw new IllegalArgumentException();
        for(int i=0; i<3; i++)
            if(str.charAt(i) == '0')
                throw new IllegalArgumentException();
        if(str.charAt(0) == str.charAt(1) || str.charAt(0) == str.charAt(2) || str.charAt(1) == str.charAt(2))
            throw new IllegalArgumentException();

        return convert(str);
    }

    public static int[] convert(String pNum) {
        int num[] = new int[3];
        num[0] = pNum.charAt(0) - '0';
        num[1] = pNum.charAt(1) - '0';
        num[2] = pNum.charAt(2) - '0';
        return num;
    }

    public static int[] makeNum() {
        int num[] = new int[3];
        Random rnd = new Random();
        num[0] = rnd.nextInt(9) + 1;
        do {
            num[1] = rnd.nextInt(9) + 1;
        } while(num[0] == num[1]);
        do {
            num[2] = rnd.nextInt(9) + 1;
        } while(num[0] == num[2] || num[1] == num[2]);
        return num;
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

    public static boolean restart() {
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
