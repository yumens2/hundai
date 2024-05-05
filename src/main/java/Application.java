import java.util.Scanner;
import java.util.stream.Stream;

public class Application {

    static int[] arr = {0, 0, 0};
    static int[] digits;
    static int strike = 0;
    static int ball = 0;
    static int a,b = 0;
    public static void main(String[] args) {
        a = 1;
        while(a==1){ // a가 0이면 전체 게임 종료

            makeNumber();

            


            b=1;
            while(b==1) { //b가 0이면 새로운 숫자 생성
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
                    .toArray(); //입력한 숫자를 분리해서 digits 배열에 넣기

                judge();

                print();

            }
            game();
        }
    }
    static void makeNumber(){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((Math.random() * 10000) % 10); // 0~1사이에 난수가 생성되므로 10000을 곱한후 10으로 나눈 나머지로 만든다
            if((i != 0 && arr[i] == arr[i-1]) || arr[i] == 0){ // 만든 숫자가 중복되거나 0이면 다시 만든다
                i--;
            }
            if (i == 2 && arr[2] == arr[0]){
                i--;
            }
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

    static void print(){
        Scanner scan = new Scanner(System.in);
        if (strike == 0 && ball != 0) { //0 스트라이크 N 볼일 때
            System.out.println(ball + "볼");
        } else if (strike != 0 && ball == 0) { //N 스트라이크 0 볼일 때
            System.out.println(strike + "스트라이크");
        } else if (strike == 0 && ball == 0) { //0 스트라이크 0 볼일 때
            System.out.println("낫싱");
        } else // N 스트라이크 N 볼일 때
            System.out.println(strike + "스트라이크" + ball + "볼");
        if (strike == 3) { // 3 스트라이크로 정답일 때
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            b = 0;
        }
        strike = 0;
        ball = 0;
    }
    static void setNum(int num) throws IllegalArgumentException {
        int n100 = num / 100; num -= n100 * 100;
        int n10 = num / 10; num -= n10 * 10;
        int n1 = num;
        if ( num > 999 || n100 == 0 || n10 == 0 || n1 == 0) {
            throw new IllegalArgumentException();
        }
    }
    static void game(){
        Scanner scan = new Scanner(System.in);
        int sc = scan.nextInt();
        if (sc == 2) {
            a = 0;
            b = 0;

        } else if (sc == 1) {
            b = 0;

        }
    }

}



