import java.util.List;

public class BaseballGame {
    private final Computer computer = new Computer();
    private final Player player = new Player();

    public void start() {
        do {
            play();
        } while(player.inputMenu() == 1);
    }

    private void play() {
        int strike, ball;
        computer.setNumber();
        do {
            player.inputNumber();
            strike = getStrike();
            ball = getBall();
            player.printScore(strike, ball);
        } while (strike != 3);
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private int getStrike() {
        final List<Integer> answer = computer.getNumber();
        final List<Integer> guess = player.getNumber();
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            if (answer.get(i).equals(guess.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    private int getBall() {
        final List<Integer> answer = computer.getNumber();
        final List<Integer> guess = player.getNumber();
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (answer.contains(guess.get(i)) && !answer.get(i).equals(guess.get(i))) {
                ball++;
            }
        }
        return ball;
    }
}
