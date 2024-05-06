import java.util.List;

public class BaseballGameService {
    public static void main(String[] args) {
        List<Integer> randNums = RandomIntGenerate.init();
        List<Integer> userInputs;
        do {
            userInputs = UserInput.getInput();
        }while (!ScoreCounting.count(randNums, userInputs));

    }
}