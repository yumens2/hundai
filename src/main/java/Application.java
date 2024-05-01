import java.util.List;

public class Application {
    public static void main(String[] args) {
        final NumberGenerator generator = new NumberGenerator();
        List<Integer> numbers = generator.createRandomNumbers();

        final Referee referee = new Referee();

        String result = "";
        while (!result.equals("0볼 3스트라이크")){
            result = referee.compare(numbers, playerNumber());
            System.out.println(result);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static List<Integer> playerNumber() {
        return null;
    }
}
