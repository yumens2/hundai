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

            // 중복 체크를 위한 배열
            boolean[] digitExists = new boolean[10];
            isDuplicate = false;

            for (int i = 0; i < inputArr.length; i++) {
                inputArr[i] = Character.getNumericValue(input.charAt(i));
                int digit = inputArr[i];

                // 중복된 숫자인지 확인
                if (digitExists[digit]) {
                    System.out.println("중복된 값을 입력했습니다.");
                    isDuplicate = true;
                    break;
                } else {
                    digitExists[digit] = true;
                }
            }
            if (!isDuplicate) {
                break;
            }
        }
        return inputArr;
    }
}
