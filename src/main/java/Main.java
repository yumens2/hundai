import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int strike = 0;
        int ball = 0;

        int[] numArr = NumberGenerator.generateUniqueRandomNumbers(3);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            int[] inputArr = new int[3]; // 숫자를 저장할 배열

            inputArr = InputNumber.inputNum(inputArr);
            if (Check.checkAnswer(numArr, inputArr)) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int choice = scanner.nextInt();
                if (choice == 1) {
                    numArr = NumberGenerator.generateUniqueRandomNumbers(3);
                    continue; // 게임 새로 시작
                } else if (choice == 2) {
                    break; // 게임 종료
                } else {
                    System.out.println("잘못된 입력입니다. 게임을 종료합니다.");
                    break;
                }
            }
        }
    }
}