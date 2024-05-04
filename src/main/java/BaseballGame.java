public class BaseballGame {
    private static final int RETRY = 1;

    private final Computer com;
    private final User user;

    public BaseballGame() {
        com = new Computer();
        user = new User();
    }

    public void game() {
        do {
            new GameProcess(com, user).play();
            com.printFinishMessage();
            user.setRetryOrFinish();
        } while(retryGame(user.chooseRetryOrFinish()));
    }

    /**
     * 유저가 재시작을 선택했는지 아닌지 확인하는 메서드
     * @param userChoice 유저의 선택
     * @return 재시작을 선택했다면 true
     */
    private boolean retryGame(int userChoice) {
        return userChoice == RETRY;
    }
}
