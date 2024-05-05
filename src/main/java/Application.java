import java.util.Scanner;
import java.util.stream.Stream;

public class Application {

    static int[] arr = {0, 0, 0};
    static int[] digits;

    public static void main(String[] args) {

        makeNumber();

        Scanner scan = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요:");
        int input = scan.nextInt();
        System.out.println(input);
        digits = Stream.of(String.valueOf(input).split(""))
            .mapToInt(Integer::parseInt)
            .toArray(); //입력한 숫자를 분리해서 digits 배열에 넣기

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
}

