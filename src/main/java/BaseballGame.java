import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class BaseballGame {
    public void startGame() {
        boolean playAgain = true;
        while (playAgain) {
            playGame();
            playAgain = askToPlayAgain();
        }
        System.out.println("게임 종료");
    }


    private void playGame() {
        int[] computerNumbers = generateComputerNumbers();
        int attempts = 0;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            int[] userNumbers = getUserNumbers();
            int[] result = calculateResult(computerNumbers, userNumbers);

            printResult(result);

            if (result[0] == 3) {
                System.out.println("승리! " + (attempts + 1) + "번 만에 정답을 맞췄습니다.");
                break;
            }

            attempts++;
        }
    }


    private int[] generateComputerNumbers() {
        Random random = new Random();
        Set<Integer> numbers = new LinkedHashSet<>();

        while (numbers.size() < 3) {
            int randomNumber = random.nextInt(9) + 1; // 1부터 9 사이의 난수 생성
            numbers.add(randomNumber);
        }

        int[] result = new int[3];
        int i = 0;

        for (int number : numbers) {
            result[i] = number;
            i++;
        }
        return result;
    }



}
