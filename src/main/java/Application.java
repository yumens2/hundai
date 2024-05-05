
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Application{
    public static void main(String[] args) {
        Application game = new Application();
        game.startGameFlow();
    }
    //게임 흐름 관리 구현

    public void startGameFlow() {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean playAgain = true;
            while (playAgain) {
                playSingleGame(scanner);
                playAgain = askPlayAgain(scanner);
            }
        }
    }

    public void playSingleGame(Scanner scanner) {
        List<Integer> computerNumbers = generateRandomNumbers();
        System.out.println("새 게임을 시작합니다.");

        while (!gameIsFinished(computerNumbers, scanner)) {
            // continue playing until baseballgame.GameTest.game is finished
        }
    }

    public boolean askPlayAgain(Scanner scanner) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return scanner.nextLine().equals("1");
    }

   

}
