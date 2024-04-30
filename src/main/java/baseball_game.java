import java.util.Random;
import java.util.Scanner;

public class baseball_game {
    static Random rand = new Random();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        while(true){
            if(playGame() == 2) break;
        }

    }

    public static int playGame(){


        String number = makeRandNum();
        while(true){

            System.out.println("숫자를 입력해 주세요: ");

            String guess = scanner.nextLine();
            //if(guess.length() != 3) throw new IllegalArgumentException();
            checkInput(guess);
            int result = score(number, guess);
            if(result == 1 || result == 2) return result;
            else if(result == 0) continue;
            else throw new IllegalArgumentException();


        }

    }

    public static String makeRandNum(){
        int number = 0;
        int num1 = rand.nextInt(9)+1;
        int num2 = rand.nextInt(9)+1;
        while(num1==num2){
            num2 = rand.nextInt(9)+1;
        }
        int num3 = rand.nextInt(9)+1;
        while(num1==num3 || num2 == num3){
            num3 = rand.nextInt(9)+1;
        }
        number = num1*100 + num2*10 + num3;
        return number + "";
    }

    public static void checkInput(String guess){
        if(guess.length() != 3) throw new IllegalArgumentException();
        for(int i=0; i<3; i++){
            char c = guess.charAt(i);
            if(c < '1' || c > '9') throw new IllegalArgumentException();
        }
    }

    public static int printResult(int strike, int ball){
        if(ball==0 && strike == 0) System.out.println("낫싱");
        if(ball>0)System.out.print(ball + "볼 ");
        if(strike>0)System.out.println(strike + "스트라이크");
        System.out.println();

        if(strike == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int res = Integer.parseInt(scanner.nextLine());
            return res;

        }
        return 0;
    }

    public static int score(String number, String guess){
        int ball = 0;
        int strike = 0;
        for (int i=0; i<3; i++) {
            if(guess.charAt(i) == number.charAt(i)) strike++;
            else ball += scoreBall(number.charAt(i), guess);
        }
        return printResult(strike, ball);
    }

    private static int scoreBall(char num, String guess) {
        for(int i=0; i<3; i++){
            if(num == guess.charAt(i)) return 1;
        }
        return 0;
    }


}
