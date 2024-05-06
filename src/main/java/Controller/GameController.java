package Controller;

import IO.*;
import utils.*;

public class GameController {
    public void run(){
        while(true){
            firstGameStart();
            if (!wantGame()){
                break;
            }
        }
    }

    private void firstGameStart(){
        // random 숫자 생성
        int[] gameNumber = makeRandomNumber.getRandomNumbers();
        int[] userNumber;
        while(true){
            try {
                userNumber = Input.inputGameNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }

            int strikeCount = resultCalculation.countStrikes(gameNumber, userNumber);
            int ballCount = resultCalculation.countBall(gameNumber, userNumber);
            Output.printGameResult(strikeCount, ballCount);

            if (strikeCount == 3) {
                System.out.println("정답 입니다! 게임 종료");
                break;
            }
        }
    }

    private boolean wantGame() {
        int want = Input.inputStartGame();

        return want == 1;
    }
}
