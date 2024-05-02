public class GameProcess {
    private Computer com;
    private User user;

    public GameProcess() {}
    public GameProcess(Computer com, User user) {
        this.com = com;
        this.user = user;
    }

    public void play() {
        com.generateRandNum();
    }
}
