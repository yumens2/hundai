package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> playerNumber = new ArrayList<>();

    public void setPlayerNumbers(List<Integer> playerNumber){
        this.playerNumber = playerNumber;
    }

    public List<Integer> getPlayerNumbers(){
        return playerNumber;
    }

}
