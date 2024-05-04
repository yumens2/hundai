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
        com.generateRandNum();                      // 컴퓨터가 랜덤 숫자 생성
        do {
            com.printInputMessage();                // 유저 입력 안내 메시지 출력
            user.setInputNum();                     // 유저 추측 값 입력
            String userInput = user.getInputNum();

            com.inputValidationCheck(userInput);    // 입력 값 유효성 검사
            com.calcScore(userInput);               // strike/ball 점수 계산

            com.printScore();                       // strike/ball 점수 출력
        } while (!com.isGameFinish());              // 3 Strike 인지 판단
    }
}
