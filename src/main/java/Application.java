import controller.BaseballController;
import util.RandomGenerator;

public class Application {
    private static final int GAME_CAPACITY = 3;
    private static final int GAME_RESTART = 1;
    private static final int GAME_END = 2;
    public static void main(String[] args) {
        BaseballController baseballController = new BaseballController();
        int gameType = GAME_RESTART;

        while(gameType == GAME_RESTART){
            baseballController.setNewGame(GAME_CAPACITY, RandomGenerator.generateRandomValue(GAME_CAPACITY));
            gameType = baseballController.run();
            validateGameType(gameType);
        }
    }
    private static void validateGameType(int gameType){
        if(gameType == GAME_RESTART || gameType == GAME_END){
            throw new IllegalArgumentException("게임 타입(게임 새로시작 : 1, 게임 종료 : 2)이 올바르지 않습니다.");
        }
    }
}
