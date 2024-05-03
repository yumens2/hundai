package kim.half;

import kim.half.service.BaseballGameManager;

public class Application {

    public static void main(String[] args) {
        BaseballGameManager gameManager = new BaseballGameManager();
        gameManager.start();
    }
}
