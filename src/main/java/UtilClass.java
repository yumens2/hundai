import java.util.Random;
import java.util.*;

public class UtilClass {
    public static Scanner sc = new Scanner(System.in);

    private UtilClass() {
    }

    public static String start() {
        Random random = new Random();
        StringBuilder num = new StringBuilder();
        int[] numberArr = new int[10];
        while (num.length() < 3) {
            int numberValue = random.nextInt(9) + 1;
            if (numberArr[numberValue] > 0) continue;
            num.append(numberValue);
            numberArr[numberValue] = numberArr[numberValue] + 1;
        }
        return num.toString();
    }

    public static boolean game(String number) {
        while (true) {
            System.out.print("숫자를 입력해 주세요 : ");
            String str = sc.nextLine();
            boolean result = isFinish(str, number);
            if (result) break;
        }
        return true;
    }

    public static boolean isFinish(String input, String number) {
        if (input.length() != 3) throw new IllegalArgumentException("세자리 숫자를 입력해야 합니다.");
        int[] currNumber = new int[10];
        try {
            for (int i = 0; i < 3; i++) {
                int value = Integer.parseInt(String.valueOf(number.charAt(i)));
                currNumber[value] = currNumber[value] + 1;
            }
        } catch (IllegalArgumentException exception) {
            System.out.println("잘못된 입력으로 인해 게임이 종료되었습니다.");
            return false;
        }
        int strikeCount = 0;
        int ballCount = 0;
        for (int i = 0; i < 3; i++) {
            if (number.charAt(i) == input.charAt(i)) {
                strikeCount++;
                continue;
            }
            if (currNumber[Integer.parseInt(String.valueOf(input.charAt(i)))] > 0) {
                ballCount++;
            }
        }
        if (ballCount > 0) {
            System.out.print(ballCount + "볼 ");
        }
        if (strikeCount > 0) {
            System.out.print(strikeCount + "스트라이크 ");
        }
        if (ballCount == 0 && strikeCount == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
        if (strikeCount == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return true;
        }
        return false;
    }
}
