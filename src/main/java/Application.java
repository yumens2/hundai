import java.util.Scanner;
import java.util.stream.Stream;

public class Application {

    static int[] arr = {0, 0, 0};
    static int[] digits;
    static int strike = 0;
    static int ball = 0;

    public static void main(String[] args) {

        makeNumber();

        Scanner scan = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요:");
        int input = scan.nextInt();
        try {
            setNum(input);
        }
        catch (IllegalArgumentException e) {
            System.out.println("유효하지 않은 숫자입니다.");
            return;
        }
        System.out.println(input);
        digits = Stream.of(String.valueOf(input).split(""))
            .mapToInt(Integer::parseInt)
            .toArray();

        judge();//입력한 숫자를 분리해서 digits 배열에 넣기
    }

    static void makeNumber() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((Math.random() * 10000)
                % 10); // 0~1사이에 난수가 생성되므로 10000을 곱한후 10으로 나눈 나머지로 만든다
            if ((i != 0 && arr[i] == arr[i - 1]) || arr[i] == 0) { // 만든 숫자가 중복되거나 0이면 다시 만든다
                i--;
            }
            if (i == 2 && arr[2] == arr[0]) {
                i--;
            }
        }
    }
    static void setNum(int num) throws IllegalArgumentException {
        int n100 = num / 100; num -= n100 * 100;
        int n10 = num / 10; num -= n10 * 10;
        int n1 = num;
        if ( num > 999 || n100 == 0 || n10 == 0 || n1 == 0) {
            throw new IllegalArgumentException();
        }
    }
    static void judge(){
        for (int l = 0; l < arr.length; l++) {
            if (arr[l] == digits[l]) {
                strike += 1; //숫자와 자리가 일치하면 스트라이크 +1

            }
            if (arr[0] == digits[l] && arr[0] != digits[0]) { // 숫자만 같고 자리만 다를경우 볼 +1
                ball += 1;
            }
            if (arr[1] == digits[l] && arr[1] != digits[1]) {
                ball += 1;
            }
            if (arr[2] == digits[l] && arr[2] != digits[2]) {
                ball += 1;
            }
        }
    }
}

