package view;

import dto.GameResultDTO;

public class OutputView {
    private static final String STRIKE_BALL_MSG  = "%d볼 %d스트라이크";
    private static final String ONLY_BALL_MSG = "%d볼";
    private static final String ONLY_STRIKE_MSG = "%d스트라이크";
    private static final String NOTHING_MSG = "낫싱";
    private static final String END_GAME_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";


    public static void printResult(GameResultDTO result){
        if(result.getStrike() > 0 && result.getBall() > 0){
            printStrikeAndBall(result);
            return;
        }
        if(result.getStrike() > 0){
            printOnlyStrike(result);
            return;
        }
        if(result.getBall() > 0){
            printOnlyBall(result);
            return;
        }
        printNothing();
    }

    private static void printStrikeAndBall(GameResultDTO gameResultDTO){
        System.out.printf(STRIKE_BALL_MSG + "\n", gameResultDTO.getBall(), gameResultDTO.getStrike());
    }
    private static void printOnlyBall(GameResultDTO gameResultDTO){
        System.out.printf(ONLY_BALL_MSG + "\n", gameResultDTO.getBall());
    }
    private static void printOnlyStrike(GameResultDTO gameResultDTO){
        System.out.printf(ONLY_STRIKE_MSG + "\n", gameResultDTO.getStrike());
    }
    private static void printNothing(){
        System.out.println(NOTHING_MSG);
    }

    public static void printEndGame(){
        System.out.println(END_GAME_MSG);
    }

}
