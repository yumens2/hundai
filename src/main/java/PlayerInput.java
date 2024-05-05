import java.util.Scanner;

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
        if (input.length() != 3 || input.contains("0")) {
            throw new IllegalArgumentException("입력한 값은 세 자리 정수가 아니거나 0을 포함하고 있습니다.");
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
