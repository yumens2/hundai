package Model;

public class Player {
    private String playerNum;//입력 받은 숫자
    public Player(String playerNum){
        this.playerNum = playerNum;
    }
    public String getPlayerNum() {//입력받은 숫자의 getter
        return playerNum;
    }
}
