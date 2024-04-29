import java.util.List;
import java.util.Scanner;

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
                choiceRestartOrGameOver();
            }
        }
        else{
            System.out.println("낫싱");
        }

    }

    public void isValidRestartOrGameOverNum(int input) throws IllegalArgumentException {

        if(input != 1 && input != 2){
            throw new IllegalArgumentException("입력값이 유효하지 않습니다.");
        }

    }
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
            strike = 0;
            ball = 0;
        }
    }
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
