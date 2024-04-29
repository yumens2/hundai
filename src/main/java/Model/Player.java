package Model;

public class Player {
    private String playerNum;//입력 받은 숫자
    public Player(String playerNum){
        this.playerNum = playerNum;
    }//생성자로 초기화
    public String getPlayerNum() {//입력받은 숫자의 getter
        return playerNum;
    }//getter로 정보 접근 가능
}
