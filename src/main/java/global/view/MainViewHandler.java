package global.view;

import game.gamePack.GamePack;
import global.config.GamePackConfig;
import java.util.List;

public class MainViewHandler {

    private static final String GAME_OPEN_MESSAGE = "환영합니다.";
    private static final String GAME_END_SELECT = "0. 종료";

    public static void printGameOpenMessage() {
        System.out.println(GAME_OPEN_MESSAGE);
    }

    public static void printGameList() {
        List<GamePack> gamePackList = GamePackConfig.getGamePacks();

        for (int i = 0; i < gamePackList.size(); i++) {
            System.out.println((i + 1) + ". " + gamePackList.get(i).getGameName());
        }
        System.out.println(GAME_END_SELECT);
    }

}
