package view;

import domain.dto.ScoreDto;
import domain.wrapper.Ball;
import domain.wrapper.Strike;

public class OutputView {

    private static final String GAME_SCORE_ONLY_BALL_FORMAT = "%d볼";
    private static final String GAME_SCORE_ONLY_STRIKE_FORMAT = "%d스트라이크";
    private static final String GAME_SCORE_FORMAT = "%d볼 %d스트라이크";
    private static final String GAME_SCORE_WITH_NO_BALL_STRIKE_MESSAGE = "낫싱";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void print(String message) {
        System.out.println(message);
    }

    public static void printWithNoEnter(String message) {
        System.out.print(message);
    }

    public void showGameScore(Strike strike, Ball ball) {
        if (strike.getCount() == 0 && ball.getCount() == 0) {
            print(GAME_SCORE_WITH_NO_BALL_STRIKE_MESSAGE);
        }
        if (strike.getCount() == 0) {
            print(String.format(GAME_SCORE_ONLY_BALL_FORMAT, ball));
        }
        if (ball.getCount() == 0) {
            print(String.format(GAME_SCORE_ONLY_STRIKE_FORMAT, strike));
        }
        print(String.format(GAME_SCORE_FORMAT, ball, strike));
    }
}
