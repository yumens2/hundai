import java.util.Scanner;

public class BaseballGame {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean isContinue = true;

        while (isContinue){
            playGame();
        }
        scanner.close();
    }
   public static void playGame(){
        int[] gameNumber = generateGameNumber();
        Scanner scanner = new Scanner(System.in);

        System.out.println("숫자 입력: ");
        while (true) {
            int[] guess = getGuess(scanner);
            int[] result = checkResult(gameNumber, guess);
            if (result[0] == 3){
                System.out.println("3스트라이크, 게임 종료!");
                break;
            } else {
                printResult(result);
                System.out.println("숫자 입력: ");
            }
        }
        scanner.close();
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
           System.out.println("아웃");
       } else {
           if (result[0] > 0) {
               System.out.println(result[0] + "스트라이크");
           }
           if (result[1] > 0) {
               System.out.println(result[1] + "볼");
           }
           System.out.println();
       }
   }
}
