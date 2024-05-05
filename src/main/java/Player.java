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
                throw new IllegalArgumentException("1에서 9 사이의 수를 입력해야 합니다.");
            }
        }
    }

    public List<Integer> getNumber() {
        return playerNum;
    }


}
