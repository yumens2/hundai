import java.util.Scanner;

public class GameState {
    public static String gameProceed() {
        System.out.print("숫자를 입력해 주세요 : ");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static int gameResult(int[] result){
        if (result[0] > 0) {
            System.out.printf("%d볼 ", result[0]);
        }
        if (result[1] > 0) {
            System.out.printf("%d스트라이크 ", result[1]);
        }
        if (result[0] == 0 & result[1] == 0) {
            System.out.println("낫싱");
            return 0;
        }
        System.out.println();

        if (result[1] == 3) {
            return gameRestart();
        }

        return 0;
    }

    public static int gameRestart(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        Scanner sc = new Scanner(System.in);
        if (sc.nextLine().equals("1")) return 1;

        return 2;
    }

}
