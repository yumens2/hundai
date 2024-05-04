import java.util.ArrayList;

public class StartGame {
    private static RandomNumber randomNumberGenerator = new RandomNumber();
    private static Input input = new Input();
    private static BaseballGame baseballGame = new BaseballGame();

    public static void startGame() {
        ArrayList<Integer> targetNumbers = randomNumberGenerator.generateRandomNumbers();

        while(true) {
            ArrayList<Integer> inputNumbers = input.inputNumbers();
            int result_of_the_game = baseballGame.play(targetNumbers, inputNumbers);

            if (result_of_the_game == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }
}
