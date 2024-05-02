import Entity.Computer;
import Entity.User;

public class Application {

    private final static String threeStrike = "3스트라이크";

    public static void main(String[] args) {
        // NOTE 사용자 또는 컴퓨터의 숫자를 생성하는 NumberGenerating 클래스
        User user = new User();
        Computer computer = new Computer();
        NumberBaseballGame numberBaseballGame = new NumberBaseballGame(user, computer);
        System.out.println(numberBaseballGame.printStartingGame());
        numberBaseballGame.setComputerNumbers();
        String result = "";
        do {
            numberBaseballGame.setUserNumbers();
            result = numberBaseballGame.calculateScore();
            System.out.println(result);
        } while (!result.equals(threeStrike));
        numberBaseballGame.closeScanner();
        System.out.println(numberBaseballGame.printEndingGmae());
    }
}
