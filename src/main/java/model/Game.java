package model;

import enums.Judgement;
import utils.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final String answer;
    private List<String> numberHistory = new ArrayList<>();
    private List<List<Judgement>> judgementHistory = new ArrayList<>();
    private boolean isEnd = false;

    public Game() {
        this.answer = RandomNumberGenerator.generateRandomNumber();
    }

    public Game(String answer) {
        this.answer = answer;
    }

    public void addNumberHistory(String number) {
        numberHistory.add(number);
    }

    public void addJudgementHistory(List<Judgement> judgement) {
        judgementHistory.add(judgement);
    }

    public boolean getEnd() {
        return this.isEnd;
    }
    public void setEnd() {
        isEnd = true;
    }

    public String getAnswer() {
        return answer;
    }
}
