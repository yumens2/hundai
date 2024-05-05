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

   }
}
