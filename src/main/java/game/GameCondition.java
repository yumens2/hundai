package game;

public class GameCondition {
    boolean playGame;
    boolean collectAnswer;

    public GameCondition() {
        this.playGame = true;
        this.collectAnswer = false;
    }

    public boolean canPlayGame() {
        return playGame;
    }

    public boolean canCollectAnswer() {
        return collectAnswer;
    }

    public void changeCollectAnswer(boolean collectAnswer){
        this.collectAnswer = collectAnswer;
    }

    public void changePlayGame(boolean playGame){
        this.playGame = playGame;
    }
}
