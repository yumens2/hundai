package Controller;

import Model.Answer;
import Model.Computer;
import Model.Player;
import Utility.CalculateScore;
import Utility.CheckValidity;
import View.InputView;
import View.OutputView;

import java.io.IOException;

public class Game {
    public Game(){

    }
    //우선 구현후 다시 쪼개기
    public void run()throws IOException {
        while(startGame()){
            OutputView.outputRestart();
            String inputNext = InputView.Input();

            CheckValidity.playerRestartNumbervalidity(inputNext);
            if(inputNext.equals("2")) {
                OutputView.outputLine("프로그램을 종료합니다.");
                return;
            }

        }

    }
    private boolean startGame()throws IOException{
        Answer answer = new Answer(Computer.makeRandomNumber());
        while(true){
            OutputView.outputInputNumber();
            Player player = new Player(InputView.Input());

            CheckValidity.playerNumbervalidity(player.getPlayerNum());
            int ball = CalculateScore.ballCount(answer.getAnswerNum(), player.getPlayerNum());
            int strike = CalculateScore.strikeCount(answer.getAnswerNum(), player.getPlayerNum());
            if(strike == 3){
                OutputView.outputFinish();
                return true;
            }
            if(ball > 0) OutputView.output(ball+"볼 ");
            if(strike > 0) OutputView.output(strike+"스트라이크");
            if(ball == 0 && strike == 0) OutputView.outputLine("낫싱");
            OutputView.outputLine("");

        }
    }
}
