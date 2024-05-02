import Entity.BaseballStatus;
import Entity.Computer;
import Entity.User;

import java.util.*;

public class NumberBaseballGame {
    // Property: Player.Player
    private User user;
    private Computer computer;
    private Scanner scanner;
    private static final String ALL_STRIKE_MESSAGE = "3스트라이크";
    private static final int MAX_SCORE = 3;
    private static final String NO_SCORE = "낫싱";


    public NumberBaseballGame(User user, Computer computer) {
        this.user = user;
        this.computer = computer;
        this.scanner = new Scanner(System.in);
    }

    public NumberBaseballGame(Computer computer, User user) {
        this.user = user;
        this.computer = computer;
        this.scanner = new Scanner(System.in);
    }

    public void setUserNumbers() {
        user.setNumberList(generateUserNumByInput());
    }

    public void setComputerNumbers() {
        computer.setNumberSet(generateRandomNumber());
    }

    private ArrayList<Integer> generateUserNumByInput() {
        ArrayList<Integer> userNumber = new ArrayList<>();
        // Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력하세요: ");
        for (int i = 0; i < 3; i++) {
            if (scanner.hasNextInt()) {
                userNumber.add(scanner.nextInt());
            } else {
                scanner.next();
                i = 0;
            }
        }
        return userNumber;
    }

    private Set<Integer> generateRandomNumber() {
        Set<Integer> numbers = new LinkedHashSet<>();
        Random random = new Random();
        while (numbers.size() < 3) {
            numbers.add(random.nextInt(1, 10));
        }
        return numbers;
    }

    public String calculateScore() {
        ArrayList<BaseballStatus> ballCount = new ArrayList<>();

        compareScoreStrike(ballCount);

        if (ballCount.size() == MAX_SCORE) {
            return ALL_STRIKE_MESSAGE;
        }

        compareScoreBall(ballCount);

        return convertScoreListToString(ballCount);
    }

    private void compareScoreBall(ArrayList<BaseballStatus> score) {
        for (Integer userDatum : user.getNumberList()) {
            if (computer.getNumberSet()
                    .stream()
                    .anyMatch(userDatum::equals) && score.size() <= MAX_SCORE) {
                score.add(BaseballStatus.Ball);
            }
        }
    }

    private void compareScoreStrike(ArrayList<BaseballStatus> score) {
        ArrayList<Integer> computerNumberList = new ArrayList<>(computer.getNumberSet());
        for (int i = 0; i < user.getNumberList()
                .size(); i++) {
            if (computerNumberList.get(i)
                    .intValue() == user.getNumberList()
                    .get(i)
                    .intValue()) {
                score.add(BaseballStatus.Strike);
            }
        }
    }

    private String convertScoreListToString(ArrayList<BaseballStatus> score) {
        if (score.isEmpty()) {
            return NO_SCORE;
        } else {
            long ballNumber = getScoreCount(score, BaseballStatus.Ball);
            long strikeNumber = getScoreCount(score, BaseballStatus.Strike);
            ballNumber -= strikeNumber;
            String ballResult = (ballNumber) + "볼";
            String strikeResult = strikeNumber + "스트라이크";
            StringBuilder result = new StringBuilder();
            if (ballNumber > 0) {
                result.append(ballResult);
            }
            if (strikeNumber > 0) {
                if (ballNumber > 0) result.append(" ");
                result.append(strikeResult);
            }
            return result.toString();
        }
    }

    private long getScoreCount(ArrayList<BaseballStatus> score, BaseballStatus status) {
        long socreCount = score.stream()
                .filter(x -> x == status)
                .count();
        return socreCount;
    }

    public void closeScanner() {
        if (scanner != null) {
            scanner.close();

        }
    }

    public String printStartingGame() {
        return "================ 숫자 야구 ================";
    }

    public String printEndingGmae() {
        return "================ 게임 종료 ================";
    }
}
