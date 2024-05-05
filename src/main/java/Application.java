import computer.Computer;
import game.BaseBallGame;

import java.util.Scanner;

public class Application {
    private static boolean playGame = true;
    private static boolean collectAnswer = false;
    public static void main(String[] args) {

        Computer computer = new Computer();
        BaseBallGame baseBallGame = new BaseBallGame();
        Scanner scanner = new Scanner(System.in);

        String number = computer.getNumber();

        System.out.println(number);

        while(playGame){
            System.out.print("숫자를 입력해 주세요 : ");
            String clientNumber = scanner.nextLine();

            if(!checkNumberValid(clientNumber)){
                throw new IllegalArgumentException("잘못된 입력입니다. 애플리케이션을 종료합니다.");
            }

            int strike = baseBallGame.checkStrike(computer.getNumber(), clientNumber);
            int ball = baseBallGame.checkBall(computer.getNumber(), clientNumber);

            if(strike == 3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                collectAnswer = true;
            }else{
                baseBallGame.printGameInfo(strike, ball);
            }

            if(collectAnswer){
                checkRestartGame(scanner, computer);
            }
        }

        scanner.close();
    }

    public static Boolean checkNumberValid(String number){
        if (number.length() != 3) {
            return false;
        }

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);

            if (!Character.isDigit(c) || c == '0') {
                return false;
            }

            for (int j = i + 1; j < number.length(); j++) {
                if (number.charAt(j) == c) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void checkRestartGame(Scanner scanner, Computer computer){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String continueGame = scanner.nextLine();

        if("1".equals(continueGame)){
            computer.reGenerateNumber();
            collectAnswer = false;
        }
        else if("2".equals(continueGame)){
            playGame = false;
        }
        else{
            throw new IllegalArgumentException("잘못된 입력입니다. 애플리케이션을 종료합니다.");
        }
    }


}
