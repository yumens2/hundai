package model;

/**
 * 사용자 입력과 컴퓨터 생성 숫자를 비교하여 볼, 스트라이크, 낫싱 정보를 계산 후 사용자에게 알려줌
 */
public class AnalyseBaseballNumber {

    private String computerNumberString;
    private int numberSize;
    private boolean isDone;

    public AnalyseBaseballNumber() {
        isDone = false;
    }

    private int getStrikeCount(String userNumberString) {
        int strikeCount = 0;

        for (int i = 0; i < numberSize; i++) {
            if (computerNumberString.charAt(i) == userNumberString.charAt(i)) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

    private int getBallCount(String userNumberString, int strikeCount) {
        int ballCount = 0;
        boolean[] numberExistence = new boolean[10];

        for (int i = 0; i < numberSize; i++) {
            numberExistence[(int) computerNumberString.charAt(i) - '0'] = true;
        }

        for (int i = 0; i < numberSize; i++) {
            if (numberExistence[(int) userNumberString.charAt(i) - '0']) {
                ballCount++;
            }
        }

        return ballCount - strikeCount;
    }

    public String getResponse(String userNumberString) {
        int strikeCount = getStrikeCount(userNumberString);
        int ballCount = getBallCount(userNumberString, strikeCount);
        String result = "";

        if (strikeCount == 0 && ballCount == 0) {
            result = "낫싱";
        } else if (strikeCount != 0 && ballCount == 0) {
            result = Integer.toString(strikeCount) + "스트라이크";
            if (strikeCount == numberSize) {
                result += "\n" + Integer.toString(numberSize) + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
                isDone = true;
            }
        } else if (strikeCount == 0) {
            result = Integer.toString(ballCount) + "볼";
        } else {
            result = Integer.toString(ballCount) + "볼 " + Integer.toString(strikeCount) + "스트라이크";
        }

        return result;
    }

    public boolean getIsDone() {
        return isDone;
    }

    public void setComputerNumberString(String computerNumberString) {
        this.computerNumberString = computerNumberString;
        numberSize = computerNumberString.length();
    }

    public void reset() {
        computerNumberString = "";
        numberSize = 0;
        isDone = false;
    }
}
