import java.util.Scanner;

public class Game {
    public static boolean playGame() {
        int computer = Computer.makeRandom();
        System.out.println(computer);
        String h;
        do {
            int user = UserInput.userInput();
            h = Hint.hint(computer, user);
            System.out.println(h);
        } while (!h.equals("3스트라이크"));
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        Scanner scanner = new Scanner(System.in);
        int end = scanner.nextInt();
        if (end == 1) {
            return true;
        }
        if (end == 2) {return false;}
        return false;
    }
}