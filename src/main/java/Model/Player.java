package Model;

public class Player {
    private int playerNum;//입력 받은 숫자
    public Player(int playerNum){
        this.playerNum = playerNum;
    }
    public int getPlayerNum() {//입력받은 숫자의 getter
        return playerNum;
    }
}
