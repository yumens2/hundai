import java.util.List;

public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer();
        Player player = new Player();
        Compare compare = new Compare();

        // 컴퓨터가 숫자를 생성합니다.
        List<Integer> computerNumbers = computer.generateNum();

        String result = "";
        // 사용자가 숫자를 정확히 맞출 때까지 반복합니다.
        while (!result.equals("3스트라이크")) {
            // 플레이어가 숫자를 입력합니다.
            player.inputNumber();
            List<Integer> playerNumbers = player.getNumber();

            // 입력한 숫자를 컴퓨터의 숫자와 비교합니다.
            result = compare.compareNumbers(computerNumbers, playerNumbers);

            // 결과를 출력합니다.
            System.out.println(result);
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
