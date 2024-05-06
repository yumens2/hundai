import java.util.Scanner;

public class InputNumber {
    public static int[] inputNum(int[] inputArr) {
        boolean isDuplicate = false;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("숫자를 입력해주세요 : ");
            String input = scanner.next();
            for (int i = 0; i < inputArr.length; i++) {
                inputArr[i] = Character.getNumericValue(input.charAt(i));
                for (int j = 0; j < i; j++) {
                    if (inputArr[j] == inputArr[i]) {
                        System.out.println("중복된 값을 입력했습니다.");
                        isDuplicate = true;
                        break;
                    }
                }
                if (isDuplicate) {
                    isDuplicate = false;
                    break;
                }
            }
            if (!isDuplicate) {
                break;
            }
        }
        return inputArr;
    }
}
