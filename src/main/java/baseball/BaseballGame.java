package baseball;

import baseball.domain.Ball;
import baseball.domain.BallType;
import baseball.domain.Pitching;
import baseball.service.DefaultGameService;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private final DefaultGameService service;
    private List<Ball> answer;

    public BaseballGame(DefaultGameService service) {
        this.service = service;
    }
    public void init(){
        answer = new ArrayList<>();
        int num = service.getRandomNumber();
        for (int i = 0; i < 3; i++) {
            answer.add(new Ball(BallType.STRIKE, num % 10));
            num /= 10;
        }
    }

    public void startGame(){
        while(true) {
            Pitching result = playRound(View.inputNumber());
            View.printResult(result.toString());
            if (result.isThreeStrike()){
                View.printEnd();
                return;
            }
        }
    }
    public Pitching playRound(String input){
        Pitching pitching = service.createPitching(input,answer);
        return pitching;
    }
}
