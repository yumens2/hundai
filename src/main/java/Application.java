import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("Welcome to the Number Baseball Game!");

        while (true) {
            List<Integer> computerNumbers = RandomNumbersGenerator.generateUniqueNumbers();
            NumberBaseballGame game = new NumberBaseballGame(computerNumbers);
            boolean continuePlaying = game.play();
            if (!continuePlaying) {
                System.out.println("Thank you for playing!");
                break;
            }
        }
    }
}

