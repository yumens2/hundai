import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class PlayerInput {

    public int[] playerNumber;

    public PlayerInput(String input) {
        validateInput(input);
        convertInputToArray(input);
    }

    public PlayerInput() {
        String input = getInputFromUser();
        validateInput(input);
        convertInputToArray(input);
    }

    public String getInputFromUser() {
        System.out.println("숫자를 입력해 주세요 : ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }

    public void validateInput(String input) {
        // 중복된 숫자를 확인하기 위한 HashSet 생성
        Set<Character> digitSet = new HashSet<>();

        // 입력 문자열을 하나씩 순회하면서 HashSet에 넣음
        for (char digit : input.toCharArray()) {
            digitSet.add(digit);
        }

        // 중복된 숫자가 있는지 확인
        if (input.length() != 3 || input.contains("0") || digitSet.size() != 3) {
            throw new IllegalArgumentException("입력한 값은 세 자리 정수가 아니거나 0을 포함하거나 중복된 숫자가 있습니다.");
        }
    }

    public void convertInputToArray(String input) {
        this.playerNumber = new int[3];
        char[] charArray = input.toCharArray();
        for (int i = 0; i < 3; i++) {
            playerNumber[i] = Character.getNumericValue(charArray[i]);
        }
    }

    public int[] getPlayerNumber() {
        return playerNumber;
    }

}
