import java.util.Random;

public class GameService {

    private GameService() {
    }

    public static int getNewAnswer() {
        Random rand = new Random();
        int num1 = rand.nextInt(9) + 1;
        int num2 = rand.nextInt(9) + 1;
        while (num1 == num2) {
            num2 = rand.nextInt(9) + 1;
        }
        int num3 = rand.nextInt(9) + 1;
        while (num3 == num1 || num3 == num2) {
            num3 = rand.nextInt(9) + 1;
        }

        return num1 * 100 + num2 * 10 + num3;
    }

    public static ResultDto getResult(int answer, int guess) {
        int strike = 0;
        int ball = 0;
        int[] answerArr = {answer / 100, (answer % 100) / 10, answer % 10};
        int[] guessArr = {guess / 100, (guess % 100) / 10, guess % 10};

        for (int i = 0; i < 3; i++) {
            if (answerArr[i] == guessArr[i]) {
                strike++;
            } else if (guessArr[i] == answerArr[(i + 1) % 3] || guessArr[i] == answerArr[(i + 2)
                % 3]) {
                ball++;
            }
        }

        return new ResultDto(strike, ball);
    }
}
