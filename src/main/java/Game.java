import domain.Computer;
import domain.Result;
import userinterface.UserRequest;
import userinterface.UserResponse;

public class Game {
    private final Computer computer;
    private final UserRequest userRequest;
    private final UserResponse userResponse;
    private final Result result;

    public Game() {
        this.computer = new Computer();
        this.userRequest = new UserRequest();
        this.userResponse = new UserResponse();
        this.result = new Result();
    }

    public void runGame(){
        computer.generateRandomNumbers();

        while(!result.isCorrect()){
            userResponse.printGuessMessage();
            String input = userRequest.getUserGuess();

            result.calculate(input, computer.getNumber());

            userResponse.printResult(result);
        }

        result.reset();
    }

    public boolean checkReplay() {
        userResponse.printReplayMessage();
        String replay = userRequest.getUserReplay();
        return replay.equals("1");
    }

    public void end() {
        userRequest.closeScanner();
    }
}
