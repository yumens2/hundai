import java.util.Random;

public class BaseballNumberGame extends Game {
    private int answer;
    private int random100 = 0, random10 = 0, random1 = 0;

    @Override
    public void play() {

    }

    @Override
    protected void printEndGame() {

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
}