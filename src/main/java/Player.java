public class Player {

    private String playerNumber;

    public void setPlayerNumber() throws IllegalStateException {
        InputNumberReceiver inputNumberReceiver = new InputNumberReceiver();
        this.playerNumber = inputNumberReceiver.getInputNumber();
    }

    public String getPlayerNumber() {
        return playerNumber;
    }
}
