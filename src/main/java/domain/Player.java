package domain;

public final class Player {

    private final String playerAnswer;

    private Player(String playerAnswer) {
        this.playerAnswer = playerAnswer;
    }

    public static Player create(String playerAnswer) {
        return new Player(playerAnswer);
    }

    public String getPlayerAnswer() {
        return playerAnswer;
    }
}
