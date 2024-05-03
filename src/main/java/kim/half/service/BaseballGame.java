package kim.half.service;

import kim.half.domain.BaseballFactory;
import kim.half.domain.Baseballs;
import kim.half.ui.InputScanner;
import kim.half.ui.OutputBuilder;

public class BaseballGame {

    private Baseballs userBaseballs;
    private Baseballs answerBaseballs;

    public void playBaseballGame() {
        answerBaseballs = BaseballFactory.generateRandomBaseballs();
        do {
            playBaseballOneRound();
        } while (!checkAnswer());
        OutputBuilder.printCorrectAnswer();
    }

    private void playBaseballOneRound() {
        userBaseballs = receiveUserBaseballs();
        BaseballGameResult result = new BaseballGameResult(answerBaseballs, userBaseballs);

        OutputBuilder.printBaseballGameResult(result.getResult());
    }

    private Baseballs receiveUserBaseballs() {
        return BaseballFactory.createBaseballs(InputScanner.scanInputNumbers());
    }

    private boolean checkAnswer() {
        return userBaseballs.equals(answerBaseballs);
    }
}
