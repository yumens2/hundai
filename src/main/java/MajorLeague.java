import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MajorLeague {

    static boolean playBaseball() throws IOException {

        AutomaticBallStrikeSystem ABS = new AutomaticBallStrikeSystem();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        RandomBall random = new RandomBall();
        ValidBall validBall = new ValidBall();
        int number = random.makeRandomBall();

        while (true) {

            System.out.println("숫자를 입력해 주세요 :");
            Integer answer = getUserInput();
            validBall.validate(answer);

            Result result = ABS.determine(number, answer);

            int ballCount = result.getBallCount();
            int strikeCount = result.getStrikeCount();
            callReferee(ballCount, strikeCount);
            break;
        }
        return false;
    }

    private static void callReferee(int ballCount, int strikeCount) throws IOException {
        if ((ballCount == 0) && (strikeCount == 0)) {
            System.out.println("낫싱");
        } else if ((ballCount != 0) && (strikeCount != 0)) {
            System.out.println("결과: " + ballCount + "볼, " + strikeCount + "스트라이크");
        }
        else if (strikeCount == 3) {
            decideGameEnd();
        }
    }

    private static boolean decideGameEnd() throws IOException {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        Integer answer = getUserInput();
        if (answer.equals(1)) {
            MajorLeague.playBaseball();
        } else if (answer.equals(2)) {
            return false;
        }
        handleInvalidInput();
        return decideGameEnd();
    }


    private static Integer getUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer answer = Integer.parseInt(br.readLine());
        return answer;
    }


    private static void handleInvalidInput() {
        System.out.println("잘못된 입력입니다. 다시 시도하세요.");
    }

}