import java.util.Scanner;

public class GetInput {
    public static int[] getInput() {
        // 사용자에게 숫자 3개 입력받기
        int[] guess = new int[3];
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        String userInput = "";

        while (!validInput) {
            System.out.print("숫자를 입력해 주세요 : ");
            userInput = scanner.nextLine();

            if (userInput.equals("000")) {
                int[] zeros = {0, 0, 0};
                return zeros;
            }

            if (userInput.length() != 3 || !userInput.matches("[1-9]+")) {
                throw new IllegalArgumentException("잘못된 입력입니다. 숫자 3개를 띄어쓰기 없이 입력하세요.");
            }

            // 입력받은 값 int 배열로 변환
            for (int i = 0; i < 3; i++) {
                guess[i] = userInput.charAt(i) - '0';
            }

            validInput = true;
        }

        return guess;
    }
}
