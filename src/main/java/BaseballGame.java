import utils.Validation;

import java.util.List;
import java.util.Scanner;

import static utils.Validation.isValidRestartOrGameOverNum;

public class BaseballGame{
    public int isGameOver ;
    public int isRestart ;
    public int strike;
    public int ball ;
    public BaseballGame() {
        this.strike = 0;
        this.ball = 0;
        this.isGameOver = 0;
        this.isRestart = 0;
    }
    /**
     * 스트라이크 와 볼을 0으로 리셋시키는 메서드
     */
    public void resetStrikeAndBall(){
        this.strike = 0;
        this.ball =0;
    }
    /**
     * 유저 입력값과 컴퓨터 랜덤값을 비교하여 스트라이크,볼 수 계산 메서드
     * @param inputnum
     * @param cpunum
     */
    public void compareNum(List<Integer> inputnum, List<Integer> cpunum){
        resetStrikeAndBall();
        for (int num : inputnum) {
            if (inputnum.indexOf(num) == cpunum.indexOf(num)) {
                strike++;
            } else if (cpunum.contains(num)) {
                ball++;
            }
        }
        if(this.strike >0 && this.ball > 0){
            System.out.printf("%d볼 %d스트라이크\n",this.ball,this.strike);
        }
        else if(this.strike <=0 && this.ball>0){
            System.out.printf("%d볼\n",this.ball);
        }
        else if(this.strike >0 && this.ball<= 0){
            System.out.printf("%d스트라이크\n",this.strike);
            if(this.strike == 3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                choiceRestartOrGameOver();
            }
        }
        else{
            System.out.println("낫싱");
        }

    }



    /**
     * 재시작 혹은 게임종료 선택 메서드
     */
    public void choiceRestartOrGameOver(){
        int inp;
        Scanner sc = new Scanner(System.in);
        inp = sc.nextInt();
        isValidRestartOrGameOverNum(inp);
        if(inp == 2){
            isGameOver = 1;
        }
        else{
            isRestart = 1;
            resetStrikeAndBall();
        }
    }

    /**
     * 숫자야구 게임 시작 메서드
     */
    public void gameStart(){
        List<Integer> cpunum = Computer.createRandomNum();
        List<Integer> userInput;
        while(true){
            System.out.print("숫자를 입력해 주세요 :");
            userInput = User.createInputNum();
            compareNum(userInput,cpunum);
            if(isGameOver == 1){
                break;
            }
            if(isRestart == 1){
                cpunum = Computer.createRandomNum();
                isRestart = 0;
            }
        }
    }

}
