public class Application {
    public static void main(String[] args) {
        int[] computerNumber = {0, 0, 0};
        int[] userNumber = {0, 0, 0};
        int[] result = {0, 0, 0}; // ball, strike, none
        int resumeResult;
        Utiltools.makeNumber(computerNumber);

        while (true) {
            String userNum = GameState.gameProceed();
            if (Error.detectError(userNum) == 2) break;

            Utiltools.changeType(userNumber, userNum);
            Utiltools.compareNum(computerNumber, userNumber, result);

            resumeResult = GameState.gameResult(result);
            if (resumeResult == 2) break;
            else if (resumeResult == 1) Utiltools.makeNumber(computerNumber);

            Utiltools.clearResult(result);
        }

        System.out.println("프로그램을 종료합니다.");
    }

}