import java.io.*;
import java.util.*;

public class BaseballGame {
    public static void main(String[] args) throws IOException {
        //0. 스트라이크, 볼을 저장할 int형 배열, 시작과 종료를 나타낼 int
        int[] judgement = new int[2];
        int start = 0;

        String com = random_number();
        int com_length = com.length();

        try {
            while (start != 2) {
                com = check_start(start, com);

                //start 초기화
                start = 0;

                System.out.println(com); //주석처리하기

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("숫자를 입력해 주세요 : ");
                String num = br.readLine();
                b_s(com, num, judgement);
                start = check_exit(judgement);
                judgement[0] = 0;
                judgement[1] = 0;

            }
        } catch (IllegalArgumentException ex) {
            System.out.println("종료");
            start = 2;
        }

    }

    //랜덤한 수를 String으로 반환하는 메서드
    public static String random_number() {
        boolean possible_number;
        String com;
        do {
            Random random = new Random(); // 랜덤 객체 생성

            com = Integer.toString(
                111 + random.nextInt(8) * 100 + random.nextInt(8) * 10 + random.nextInt(8));

            //서로 다른 세 자리수인지 검사
            possible_number = UniqueDigits(com);

        } while(possible_number == false);

        return com;
    }

    public static boolean UniqueDigits(String number) {
        for (int i = 0; i < number.length() - 1; i++) {
            for (int j = i + 1; j < number.length(); j++) {
                if (number.charAt(i) == number.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    //프로그램이 재시작되었는지 판별하는 함수, 재시작되었다면 새로운 문자열을 반환하고 그렇지 않으면 기존 문자열을 반환
    public static String check_start(int start, String com) {
        String new_com = "";
        //start가 1이면 retry를 했다는 뜻이므로 랜덤 난수를 다시 받아와야 함.
        if (start == 1) {
            Random random = new Random(); // 랜덤 객체 생성
            new_com = Integer.toString(
                111 + random.nextInt(8) * 100 + random.nextInt(8) * 10 + random.nextInt(
                    8));
            return new_com;
        } else {
            return com;
        }
    }

    //ball인지 strike인지 판별하는 함수
    public static void b_s(String com, String num, int[] judgement) {
        int com_length = com.length();
        for (int i = 0; i < com_length; i++) {
            for (int j = 0; j < com_length; j++) {
                if (com.charAt(i) == num.charAt(j) && i == j) {
                    judgement[1]++;
                } else if (com.charAt(i) == num.charAt(j) && i != j) {
                    judgement[0]++;
                }
            }
        }
    }






}
