package IO;

import java.util.*;

public class Input {
    //    유저에게서 정보를 입력 받는 역할
    private static Scanner sc = new Scanner(System.in);

    public static int inputStartGame() {
        int input;
        while(true){
            System.out.println("게임 시작은 1, 게임 종료는 2: ");
            input = Integer.parseInt(sc.nextLine());
            if (input != 1  && input != 2){
                // 유효한 값 이외에 다른 게 들어오면
                throw new IllegalArgumentException("잘못된 입력 방식입니다.");
            }
            return input;
        }

    }

    public static int[] inputGameNumber() {
        System.out.print("숫자를 입력해 주세요 : ");
        String input = sc.nextLine();

        if (!input.matches("[0-9]{3}")) {
            // 1-9 숫자 3개가 들어오지 않았다면 -> IllegalArgumentException  발생
            throw new IllegalArgumentException("잘못된 입력 방식입니다.");
        }
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            char digitChar = input.charAt(i);
            int digit = Character.getNumericValue(digitChar);
            numbers[i] = digit;
        }

        return numbers;
    }

}
