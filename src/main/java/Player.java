import java.util.*;

public class Player {

    private List<Integer> playerNumbers;

    // 숫자를 3개 입력받는 함수
    public void inputNumbers() {

        Scanner scanner = new Scanner(System.in);
        List<Integer> validInput = new ArrayList<>();

        System.out.print("숫자를 입력해 주세요: ");
        String input = scanner.nextLine();
        validInput = validateInput(input);

        this.playerNumbers = validInput;
    }

    private List<Integer> validateInput(String input) {
        List<Integer> validInput = new ArrayList<>();
        // 입력값을 공백을 기준으로 분리
        String[] parts = input.split(" ");
        if (parts.length != 3) {
            throw new IllegalArgumentException("입력은 정확히 세 개 여야 합니다.");
        }

        Set<String> uniqueDigits = new HashSet<>();
        for (String part : parts) {
            // 숫자가 아닌 값을 포함하는지 검사
            if (!part.matches("\\d")) {
                throw new IllegalArgumentException("입력은 숫자만 포함해야 합니다");
            }
            if (Integer.parseInt(part) < 1 || Integer.parseInt(part) > 9) {
                throw new IllegalArgumentException("1에서 9 사이의 숫자를 입력해야 합니다");
            }
            // 중복된 숫자가 있는지 검사
            if (!uniqueDigits.add(part)) {
                throw new IllegalArgumentException("모든 숫자는 고유해야 합니다");
            }
            validInput.add(Integer.parseInt(part));
        }
        return validInput;
    }

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }
}
