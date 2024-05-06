import java.util.Scanner;

public class InputNumber {
    public static int[] inputNum(int[] inputArr) {
        boolean isDuplicate = false;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = scanner.next();

            // 입력된 숫자가 세 자리가 아닌 경우 IllegalArgumentException 발생
            if (input.length() != 3) {
                throw new IllegalArgumentException("세 자리 숫자를 입력해주세요.");
            }

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
