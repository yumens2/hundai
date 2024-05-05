import manage.GameManager;

public class Application {
        public static void main(String[] args) {
            GameManager gameManager = new GameManager();

            gameManager.readyGame();

            while (true) {
                if (gameManager.playGame() == 1){
                    return;

                }
            }
        }
    }

