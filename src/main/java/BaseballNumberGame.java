import java.util.Random;
import java.util.Scanner;

public class BaseballNumberGame extends Game {
    private int answer;
    private int random100 = 0, random10 = 0, random1 = 0;

    @Override
    public void play() {

    }

    @Override
    protected void printEndGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private int createRandomNumber() {
        Random random = new Random();

        do { // 겹치는 숫자있는지 검사
            // 0~999사이 숫자 생성
            int randomNumber = random.nextInt(1000);
            this.random100 = randomNumber / 100;
            this.random10 = randomNumber % 100 / 10;
            this.random1 = randomNumber % 10;
        }while (random100 == random10 || random100 == random1 || random10 == random1 || random100 == 0 || random10 ==0 || random1 ==0);

        return answer;
    }
    private int selectNumber() throws IllegalArgumentException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자를 입력해 주세요 : ");
        int select=0;
        try{
            select = scanner.nextInt();
        }catch(Exception e){
            throw new IllegalArgumentException("입력을 확인하세요.");
        }
        if(select >999){
            throw new IllegalArgumentException("3자리 숫자만 입력해주세요.");
        }
        return select;
    }
    private int checkStrike(int select) {
        int strike = 0;

        int sel100 = select / 100, sel10 = select % 100 / 10, sel1 = select % 10;
        if(sel100 == this.random100 ) strike += 1;
        if(sel10 == this.random10 ) strike += 1;
        if(sel1 == this.random1 ) strike += 1;

        return strike;
    }

    private int checkBall(int select) {
        int ball = 0;
        int sel100 = select / 100, sel10 = select % 100 / 10, sel1 = select % 10;
        if(sel100 == this.random10 || sel100 == this.random1 ) ball += 1;
        if(sel10 == this.random100|| sel10 == this.random1 ) ball += 1;
        if(sel1 == this.random10 || sel1 == this.random100 ) ball += 1;
        return ball;
    }
    private void printFeedback(int strike, int ball) {
        if(ball ==0 && strike ==0)
            System.out.println("낫싱");
        else{
            if(ball>0)
                System.out.printf(ball+"볼 ");
            if(strike>0)
                System.out.printf(strike+"스트라이크");
            System.out.println();
        }

    }
}