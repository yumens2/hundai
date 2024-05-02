public class GameProcess {
    private Computer com;
    private User user;

    public GameProcess() {}
    public GameProcess(Computer com, User user) {
        this.com = com;
        this.user = user;
    }

    /**
     * 컴퓨터와 유저의 상호작용을 중계하며 게임의 프로세스를 진행하는 메서드
     */
    public void play() {
        com.generateRandNum();
        do {
            com.printInputMessage();
            user.setInputNum();
            String userInput = user.getInputNum();

            com.inputValidationCheck(userInput);
            com.calcScore(userInput);

            com.printScore();
        } while (!com.isGameFinish());
    }
}
