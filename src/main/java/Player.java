import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private List<Integer> playerNum;

    public Player() {
        this.playerNum = new ArrayList<Integer>();
    }

    public void inputNumber() {
        Scanner scanner = new Scanner(System.in);
        boolean isValid = false;

        while (!isValid) {
            System.out.print("숫자를 입력해 주세요 : ");
            String input = scanner.nextLine();

            if (input.matches("[1-9]{3}")) {
                playerNum.clear();
                for (char c : input.toCharArray()) {
                    playerNum.add(Character.getNumericValue(c));
                }
                isValid = true;
            } else {
                System.out.println("잘못된 입력입니다. 1부터 9까지의 숫자를 중복 없이 3개 입력해주세요.");
            }
        }
    }

    public List<Integer> getNumber() {
        return playerNum;
    }


}
