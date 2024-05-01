package view;

import enums.Judgement;

import java.util.List;

/**
 * OutputView는 사용자에게 출력을 담당하는 클래스입니다.
 */
public class OutputView {

    /**
     * 사용자에게 판정 결과를 출력하는 메서드
     * @param judgements
     */
    public static void printJudgeResult(List<Judgement> judgements) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Judgement judgement : judgements) {
            stringBuilder.append(judgement.toString());
            stringBuilder.append(" ");
        }
        System.out.println(stringBuilder.toString());
    }

    /**
     * 게임 종료 시 출력하는 메서드
     */
    public static void printEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
