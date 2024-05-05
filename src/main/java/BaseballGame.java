import java.util.Scanner;

public class BaseballGame {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean isContinue = true;

        while (isContinue){
            try {
                playGame();
            } catch (IllegalArgumentException e){
                System.out.println("잘못된 입력입니다. 프로그램 종료합니다.");
                isContinue = false;
            }
            if (isContinue) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int c = scanner.nextInt();
                if (c != 1) {
                    isContinue = false;
                }
            }
        }
        scanner.close();
    }
   public static void playGame(){
        int[] gameNumber = generateGameNumber();
        Scanner scanner = new Scanner(System.in);

        System.out.println("숫자를 입력해 주세요 : ");
        while (true) {
            int[] guess;
            try {
                guess = getGuess(scanner);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException();
            }
            int[] result = checkResult(gameNumber, guess);
            if (result[0] == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            } else {
                printResult(result);
                System.out.println("숫자를 입력해 주세요 : ");
            }
        }
   }
   public static int[] generateGameNumber(){
        int[] num = new int[3];
        for (int i = 0; i < 3; i++) {
            num[i] = (int)(Math.random()*9) + 1;
            if (isDuplication(num, i)) {
                i--;
            }
        }
        return num;
   }
   public static boolean isDuplication(int[] num, int i) {
        for(int j=0; j<i; j++){
            if (num[i] == num[j]){
                return true;
            }
        }
        return false;
   }
   public static int[] getGuess(Scanner scanner){
        int[] guess = new int[3];
        int inp = scanner.nextInt();
        if (inp < 100 || inp > 999) {
            throw new IllegalArgumentException();
       }

        guess[0] = inp / 100;
        guess[1] = (inp % 100) / 10;
        guess[2] = inp % 10;

        return guess;
   }
   public static int[] checkResult(int[] gameNumber, int[] guess){
        int[] result = new int[2];
        for (int i = 0; i < 3; i++) {
            if (gameNumber[i] == guess[i]) {
                result[0]++; // 스트라이크 개수
            } else {
                result[1] += checkBall(gameNumber, guess, i);
            }
        }
        return result;
   }

   public static int checkBall(int[] gameNumber, int[] guess, int i) {
       int cnt = 0;
       for (int j = 0; j < 3; j++) {
           if (gameNumber[i] == guess[j]) {
               cnt++; // 볼 개수
               break;
           }
       }
       return cnt;
   }
   public static void printResult(int[] result){
       if (result[0] == 0 && result[1] == 0) {
           System.out.println("낫싱");
       } else {
           if (result[1] > 0) {
               System.out.println(result[1] + "볼 ");
           }
           if (result[0] > 0) {
               System.out.println(result[0] + "스트라이크");
           }
           System.out.println();
       }
   }
}
