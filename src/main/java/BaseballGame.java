public class BaseballGame {
    private static final int RETRY = 1;

    private final Computer com;
    private final User user;

    public BaseballGame() {
        com = new Computer();
        user = new User();
    }

    public void game() {
        try {
            do {
                new GameProcess(com, user).play();
                com.printFinishMessage();
                user.setRetryOrFinish();
            } while (retryGame(user.chooseRetryOrFinish()));
        } catch(IllegalArgumentException e) {
            printErrorMessage();
        }
    }

    /**
     * 유저가 재시작을 선택했는지 아닌지 확인하는 메서드
     * @param userChoice 유저의 선택
     * @return 재시작을 선택했다면 true
     */
    private boolean retryGame(int userChoice) {
        return userChoice == RETRY;
    }

    /**
     * IllegalArgumentException으로 인한 종료 메시지 출력
     */
    private void printErrorMessage() {
        System.out.println("잘못된 형식의 입력입니다.");
        System.out.println("게임을 종료합니다.");
    }
}
