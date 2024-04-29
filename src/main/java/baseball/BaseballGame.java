package baseball;

import baseball.domain.Hint;
import baseball.domain.Opponent;
import baseball.domain.RandomAnswerGenerator;
import baseball.domain.User;
import java.util.List;
import java.util.Scanner;

public class BaseballGame {

    private static final Scanner scanner = new Scanner(System.in);

    public void start() {
        do {
            final RandomAnswerGenerator randomAnswerGenerator = new RandomAnswerGenerator();
            final Opponent opponent = Opponent.from(randomAnswerGenerator);
            startUserProcess(opponent);
        } while (isRestarting());
    }

    private void startUserProcess(final Opponent opponent) {
        while (true) {
            final User user = initializeUser();
            final List<Integer> userNumbers = user.getNumbers();
            final Hint hint = opponent.checkHint(userNumbers);
            printHint(hint);

            if (hint.isStrikeOut()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private User initializeUser() {
        System.out.print("숫자를 입력해 주세요 : ");
        final String input = scanner.nextLine();
        return User.from(input);
    }

    private void printHint(final Hint hint) {
        final int strike = hint.getStrike();
        final int ball = hint.getBall();
        final StringBuilder hintMessageBuilder = new StringBuilder();

        if (hint.hasBall()) {
            hintMessageBuilder.append(ball).append("볼 ");
        }
        if (hint.hasStrike()) {
            hintMessageBuilder.append(strike).append("스트라이크");
        }
        if (hint.isNothing()) {
            hintMessageBuilder.append("낫싱");
        }
        System.out.println(hintMessageBuilder);
    }

    private boolean isRestarting() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        final String inputCommand = scanner.nextLine();
        if (inputCommand.equals("1")) {
            return true;
        }
        if (inputCommand.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException("올바른 게임 커맨드를 입력해주세요.");
    }
}
