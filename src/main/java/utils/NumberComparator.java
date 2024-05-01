package utils;

import enums.Judgement;

import java.util.ArrayList;
import java.util.List;

/**
 * 두 수를 비교해 결과를 반환하는 클래스
 */
public class NumberComparator {

    /**
     * 두 수를 비교해 결과를 Judgement 클래스 형태로 반환하는 메서드
     * @param input
     * @param answer
     *
     * @return List of Judgement
     */
    public static List<Judgement> compare(String input, String answer) {

        int strikeCount = 0;
        int ballCount = 0;
        List<Judgement> judgements = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == answer.charAt(i)) {
                strikeCount++;
                continue;
            }
            if (answer.contains(String.valueOf(input.charAt(i)))) {
                ballCount++;
            }
        }

        // Add nothing judgement to the list
        if(strikeCount == 0 && ballCount == 0) {
            Judgement nothing = Judgement.NOTHING;
            nothing.setCount(1);
            judgements.add(Judgement.NOTHING);
        }

        // Add ball and strike judgements to the list
        if(ballCount > 0) {
            Judgement ball = Judgement.BALL;
            ball.setCount(ballCount);
            judgements.add(ball);
        }
        if(strikeCount > 0) {
            Judgement strike = Judgement.STRIKE;
            strike.setCount(strikeCount);
            judgements.add(strike);
        }

        return judgements;
    }

    /**
     * input과 answer의 index번째 숫자가 같은지 확인하는 메서드
     * @param input
     * @param answer
     * @param index
     * @return
     */
    private static boolean isStrike(String input, String answer, int index) {
        return input.charAt(index) == answer.charAt(index);
    }

    /**
     * input에 answer의 index번째 숫자가 포함되어 있는지 확인하는 메서드
     * @param input
     * @param answer
     * @param index
     * @return
     */
    private static boolean isBall(String input, String answer, int index) {
        return input.contains(String.valueOf(answer.charAt(index))) && !isStrike(input, answer, index);
    }
}
