package baseball;

public class GameStatus {
    public void printResult(int balls, int strikes, boolean gameWon) {
        if (gameWon) {
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }
        printNormalResult(balls, strikes);
    }

    private void printNormalResult(int balls, int strikes) {
        String result = buildResultString(balls, strikes);
        if (result.isEmpty()) {
            System.out.println("낫싱");
        } else {
            System.out.println(result);
        }
    }

    private String buildResultString(int balls, int strikes) {
        StringBuilder result = new StringBuilder();
        if (balls > 0) {
            result.append(balls).append("볼");
        }
        if (strikes > 0) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(strikes).append("스트라이크");
        }
        return result.toString();
    }
}