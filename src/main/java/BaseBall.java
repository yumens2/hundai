public class BaseBall {
    public static void main(String[] args) {
        int playGame;
        System.out.println("게임을 시작합니다.\n");
        playGame = PlayEachGame.playEachGame();

        while (playGame == 1) {
            System.out.println("\n게임을 다시 시작합니다.\n");
            playGame = PlayEachGame.playEachGame();
        }

        System.out.println("\n게임을 종료합니다.");
    }
}
