import domain.Computer;
import domain.Result;

import java.util.Scanner;

public class Application {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Computer computer = new Computer();
    private static final InputHandler inputHandler = new InputHandler(scanner);
    private static final Result result = new Result();

    public static void main(String[] args) {
        runGame();
        scanner.close();
    }

    private static void runGame(){
        computer.generateRandomNumbers();

        while(!result.isCorrect()){
            String input = inputHandler.getUserGuess();
            result.calculate(input, computer.getNumber());
            System.out.println(result);
        }
    }
}
