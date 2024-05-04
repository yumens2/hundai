package BaseBall;
public class Application {
    public static void main(String[] args) {
        try {
            new GameController().startGame();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

