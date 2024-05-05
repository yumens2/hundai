
import model.GameControlService;
public class Application {
    public static void main(String[] args) {
        GameControlService gameControlService = new GameControlService();
        while(true){
            gameControlService.start();
            gameControlService = gameControlService.scanRestart();
            if(gameControlService == null) break;
        }
    }
}
