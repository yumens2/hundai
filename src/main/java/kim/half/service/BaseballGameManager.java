package kim.half.service;

import kim.half.ui.InputScanner;

public class BaseballGameManager {

    public void start() {
        do {
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.playBaseballGame();
        } while (checkResumeCondition());
    }
    
    private boolean checkResumeCondition() {
        ResumeChecker opinion = new ResumeChecker(InputScanner.scanResumeChoice());
        return opinion.isResume();
    }
}
