import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Computer {
    private static final int GAME_NUM = GameNum.GAME_NUM.getGameNum();
    private int[] comNum = new int[GAME_NUM];
    public void createGameNumber(){
        List<Integer> tmp = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            tmp.add(i);
        }
        Collections.shuffle(tmp);
        for (int i = 0; i < GAME_NUM; i++) {
            this.comNum[i] = tmp.get(i);
        }
    }

    public int[] getComNum() {
        return comNum;
    }
}
