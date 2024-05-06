import computer.Computer;
import game.BaseBallGameService;
import game.GameCondition;

import java.util.Scanner;

public class Application {

    private final Computer computer;
    private final BaseBallGameService gameService;
    private final GameCondition gameCondition;

    public Application(Computer computer, BaseBallGameService gameService, GameCondition gameCondition) {
        this.computer = computer;
        this.gameService = gameService;
        this.gameCondition = gameCondition;
    }

    public Computer getComputer() {
        return computer;
    }

    private boolean inputValidCheck(String clientNumber) {
        gameService.checkNumberValid(clientNumber);
        return true;
    }

    private void printGameInfo(int strike, int ball) {
        if(strike == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            gameCondition.changeCollectAnswer(true);
        }else{
            String info = gameService.printGameInfo(strike, ball);
            System.out.println(info);
        }
    }

    private void checkRestartGame(String continueGame){
        if("1".equals(continueGame)){
            computer.reGenerateNumber();
            gameCondition.changeCollectAnswer(false);
        }
        else if("2".equals(continueGame)){
            gameCondition.changePlayGame(false);
        }
        else{
            throw new IllegalArgumentException("입력이 1과 2가 아닙니다. 애플리케이션을 종료합니다.");
        }
    }
    public void start(){
        Scanner scanner = new Scanner(System.in);

        while(gameCondition.canPlayGame()){
            System.out.print("숫자를 입력해 주세요 : ");
            String clientNumber = scanner.nextLine();

            if (!inputValidCheck(clientNumber)) {
                scanner.close();
                break;
            }

            int strike = gameService.checkStrike(computer.getNumber(), clientNumber);
            int ball = gameService.checkBall(computer.getNumber(), clientNumber);

            printGameInfo(strike, ball);

            if(gameCondition.canCollectAnswer()){
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String continueGame = scanner.nextLine();
                checkRestartGame(continueGame);
            }
        }
        scanner.close();
        System.out.println("안녕히 가세요");
    }

    public static void main(String[] args) {
        Computer computer = new Computer();
        BaseBallGameService gameService = new BaseBallGameService();
        GameCondition gameCondition = new GameCondition();

        Application app = new Application(computer, gameService, gameCondition);
        app.start();
    }

}
