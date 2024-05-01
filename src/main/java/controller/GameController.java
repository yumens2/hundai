package controller;

import enums.Judgement;
import model.Game;
import utils.NumberComparator;
import view.InputView;
import view.OutputView;

import java.util.List;

/**
 * 게임을 진행하는 클래스
 */
public class GameController {
    /**
     * 게임을 시작하는 메서드, 여러 라운드를 반복할 수 있도록 함
     */
    public static void gameStart() {
        do {
            playRound();
        } while(InputView.askRestart());
    }

    /**
     * 한 라운드를 진행하는 메서드
     */
    private static void playRound() {
        Game round = new Game();
        do {

            String input = InputView.askNumber();
            round.addNumberHistory(input);

            List<Judgement> judgements = NumberComparator.compare(input, round.getAnswer());
            round.addJudgementHistory(judgements);

            OutputView.printJudgeResult(judgements);

            if(judgements.get(0) == Judgement.STRIKE && judgements.get(0).getCount() == 3) {
                round.setEnd();
                OutputView.printEndMessage();
            }

        } while(!round.getEnd());
    }
}
