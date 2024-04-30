package Controller;

import Model.Answer;
import Model.Computer;
import Model.Player;
import Utility.CalculateScore;
import Utility.CheckPlayerNumberValidity;
import Utility.CheckPlayerRestartNumberValidity;
import View.InputView;
import View.OutputView;

import java.io.IOException;

public class Game {
    //디폴트 생성자
    public Game(){

    }
    public void run()throws IOException, IllegalArgumentException {
        while(true){//게임이 정상적으로 실행 됐으면 재시작 여부 물어봄
            startGame();
            OutputView.outputRestart();//다시 시작 할것인지 출력
            String inputNext = InputView.Input();//사용자로 부터 입력을 받음
        //플레이어가 입력한 재시작 여부가 1이면 재시작 2라면 return하여 run메소드를 종료함
            CheckPlayerRestartNumberValidity.playerRestartNumberValidity(inputNext);
            if(inputNext.equals("2")) {
                OutputView.outputLine("프로그램을 종료합니다.");
                return;
            }

        }

    }
    private void startGame()throws IOException{
        Answer answer = new Answer(Computer.makeRandomNumber());//Computer로 랜덤한 3자리수를 생성하여 Answer클래스에 초기화함
        while(true){//맞출 때 까지 반복한다.
            OutputView.outputInputNumber();//숫자를 입력 받음
            Player player = new Player(InputView.Input());//우선적으로 Player에 입력받은 것을 저장

            CheckPlayerNumberValidity.playerNumberValidity(player.getPlayerNum());//입력 받은 수가 올바른 수인지 검사
            int ball = CalculateScore.ballCount(answer.getAnswerNum(), player.getPlayerNum());//입력받은수의 ball 계산
            int strike = CalculateScore.strikeCount(answer.getAnswerNum(), player.getPlayerNum());//입력받은 수의 strike계산
            if(strike == 3){//strike가 3개라면 정답으므로 정답이라는 것을 출력 올바르게 작동했으므로 리턴
                OutputView.outputFinish();
                return;
            }
            if(ball > 0) OutputView.output(ball+"볼 ");//볼의 개수 출력
            if(strike > 0) OutputView.output(strike+"스트라이크");//스트라이크 출력
            if(ball == 0 && strike == 0) OutputView.outputLine("낫싱");//둘다 없으면 낫싱 출력
            OutputView.outputLine("");// 개행을 해줌

        }
    }
}
