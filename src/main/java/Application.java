import computer.Computer;
import game.BaseBallGameService;
import game.GameCondition;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Computer computer = new Computer();
        BaseBallGameService gameService = new BaseBallGameService();
        GameCondition gameCondition = new GameCondition();

        Scanner scanner = new Scanner(System.in);

        String number = computer.getNumber();
        System.out.println(number);

        while(gameCondition.canPlayGame()){
            System.out.print("숫자를 입력해 주세요 : ");
            String clientNumber = scanner.nextLine();

            if (inputValidCheck(clientNumber, gameService)) {
                scanner.close();
                break;
            }

            int strike = gameService.checkStrike(computer.getNumber(), clientNumber);
            int ball = gameService.checkBall(computer.getNumber(), clientNumber);

            printGameInfo(strike, ball, gameCondition, gameService);

            if(gameCondition.canCollectAnswer()){
                checkRestartGame(scanner, computer, gameCondition);
            }
        }

        scanner.close();
    }

    public static boolean inputValidCheck(String clientNumber, BaseBallGameService gameService) {
        try {
            if (!gameService.checkNumberValid(clientNumber)) {
                throw new IllegalArgumentException("잘못된 입력입니다. 애플리케이션을 종료합니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }

    private static void printGameInfo(int strike, int ball, GameCondition gameCondition, BaseBallGameService gameService) {
        if(strike == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            gameCondition.changeCollectAnswer(true);
        }else{
            String info = gameService.printGameInfo(strike, ball);
            System.out.println(info);
        }
    }

    public static void checkRestartGame(Scanner scanner, Computer computer, GameCondition gameCondition){
        try {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String continueGame = scanner.nextLine();
            if("1".equals(continueGame)){
                computer.reGenerateNumber();
                gameCondition.changeCollectAnswer(false);
            }
            else if("2".equals(continueGame)){
                gameCondition.changePlayGame(false);
            }
            else{
                throw new IllegalArgumentException("잘못된 입력입니다. 애플리케이션을 종료합니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            gameCondition.changePlayGame(false);
        }

    }


}
