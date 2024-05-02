package global.config;

import game.gamePack.BaseballGame.BaseballGamePack;
import game.gamePack.GamePack;
import java.util.ArrayList;
import java.util.List;

public class GamePackConfig {

    private static final List<GamePack> gamePacks = new ArrayList<>();

    /**
     * 생성 제한
     */
    private GamePackConfig() {
    }

    /**
     * 사용가능한 게임팩 init
     */
    private void initGamePacks() {
        gamePacks.add(new BaseballGamePack());
    }

    /**
     * 동시성 이슈 해결을 위한 synchronized
     */
    public static synchronized List<GamePack> getGamePacks() {
        /**
         * gamePacks가 비어있다면 최초로 한번만 init
         */
        if (gamePacks.isEmpty()) {
            GamePackConfig gamePackConfig = new GamePackConfig();
            gamePackConfig.initGamePacks();
        }
        return gamePacks;
    }


}
