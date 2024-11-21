import java.util.List;

public class Print {

    NumberGenerator generator = new NumberGenerator();
    List<Integer> numbers;

    final Referee referee = new Referee();
    NumberScanner player = new NumberScanner();

    void gamePrint() {
        numbers = generator.createRandomNumbers();
        String result = "";
        while (!result.equals("3스트라이크")) {
            result = referee.compare(numbers, player.playerNumber());
            System.out.println(result);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
