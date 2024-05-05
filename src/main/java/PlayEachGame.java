import java.util.Arrays;

public class PlayEachGame {
    public static int playEachGame() {
        int[] computerNums = MakeNumbers.makeNumbers();
        int[] userNums;
        int strikes = 0;
        int balls = 0;
        int reOrEx = 0;


        while (strikes < 3) {
            try {
                userNums = GetInput.getInput();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return 2; // 잘못된 입력이 발생하면 게임 종료
            }

            if (Arrays.equals(userNums, new int[]{0, 0, 0})) {
                return 2;
            }
            strikes = IsStrikeBall.isStrike(computerNums, userNums);
            balls = IsStrikeBall.isBall(computerNums, userNums);
            PrintResult.printResult(strikes, balls);
        }
        System.out.println("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");

        try {
            reOrEx = ReplayOrExit.replayOrExit();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return 2;
        }
        return reOrEx;
    }
}
