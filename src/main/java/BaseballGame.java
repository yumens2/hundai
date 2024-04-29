import java.util.List;

public class BaseballGame{
    public int isGameOver = 0;
    public int isRestart = 0;
    public int strike = 0;
    public int ball = 0;
    public void compareNum(List<Integer> inputnum, List<Integer> cpunum){
        this.strike = 0;
        this.ball = 0;
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
                choiceRestartGame();
            }
        }
        else{
            System.out.println("낫싱");
        }

    }
    public void gameStart(){

    }

}
