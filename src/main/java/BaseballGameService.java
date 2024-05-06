import java.util.List;

public class BaseballGameService {
    public void start() {
        boolean restart = true;
        while(restart){
            ScoreCounting scoreCounting = new ScoreCounting();
            List<Integer> randNums = RandomIntGenerate.init();
            List<Integer> userInputs;
            do {
                userInputs = UserInput.getInput();
            } while (!scoreCounting.count(randNums, userInputs));

            GameManager manager = new GameManager();
            restart = manager.restart();
        }
    }
}