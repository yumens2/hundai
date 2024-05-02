public class BaseballGame {
    private Computer com;
    private User user;

    public BaseballGame() {
        com = new Computer();
        user = new User();
    }

    public void game() {
        while(true) {
            GameProcess gameProcess = new GameProcess(com, user);   // 새 게임 생성
            gameProcess.play();                                     // 새 게임 플레이

            // 게임을 재시작하거나 종료
        }
    }
}
