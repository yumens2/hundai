package global.view;

import game.gamePack.GamePack;
import global.config.GamePackConfig;
import java.util.List;

public class OutputView {

    private static final String GAME_OPEN_MESSAGE = "환영합니다.";
    private static final String GAME_END_SELECT = "0. 종료";
    private static final String GAME_LIST = "게임 목록";
    private static final String END_GAME_MESSAGE = "게임기를 종료 합니다.";

    public static void printGameOpenMessage() {
        System.out.println(GAME_OPEN_MESSAGE);
    }

    public static void printGameList() {
        List<GamePack> gamePackList = GamePackConfig.getGamePacks();

        System.out.println(GAME_LIST);
        for (int i = 0; i < gamePackList.size(); i++) {
            System.out.println((i + 1) + ". " + gamePackList.get(i).getGameName());
        }
        System.out.println(GAME_END_SELECT);
    }

    public static void printEndGameMessage() {
        System.out.println(END_GAME_MESSAGE);
    }


}
