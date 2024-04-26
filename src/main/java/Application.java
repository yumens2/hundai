import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Util util = new Util();
        Scanner sc = new Scanner(System.in);
//      랜덤 넘버 생성
        CreateRandomNum target = new CreateRandomNum();

        while (true) {
            int ball = 0;
            int strike = 0;

            System.out.print("숫자를 입력해 주세요 : ");
//          유저가 번호입력
            String[] nums = sc.nextLine().split("");
//           중복되는 문자가 존재하는지 검사
            util.isDuplicate(nums);

//          입력된 숫자가 볼인지 스트라이크인지 판별
            for (int i = 0; i < 3; i++) {
//              제대로된 형식의 입력인지 검사
                int num = util.isNum(nums[i]);
//               스트라이크 인지 검사
                if (target.isStrike(num, i)) {
                    strike++;
//               볼인지 검사
                } else if (target.isBall(num, i)) {
                    ball++;
                }
            }
//          모든 숫자를 맞췄다면 게임을 다시할건지 종료할건지 검사
            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                int num = util.isNum(sc.nextLine());

                if (num == 1) {
                    target = new CreateRandomNum();
                } else if (num == 2) {
                    break;
                }else {
                    throw new IllegalArgumentException();
                }
            } else {
                util.printCount(strike,ball);
            }

        }

    }
}