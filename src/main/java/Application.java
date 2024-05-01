import service.NumberMatchService;
import service.RandomNumberService;
import util.ConsoleMessages;
import util.InputValidator;

import java.util.List;
import java.util.Scanner;

public class Application {
    private static boolean isContinueGame = true;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (isContinueGame){

            List<Integer> computerNumbers = RandomNumberService.getThreeUniqueNumbers();
            System.out.println(computerNumbers.toString());

            NumberMatchService.run(computerNumbers);

            ConsoleMessages.gameClear();

            ConsoleMessages.requestRestartGameOrExit();

            int answer = InputValidator.validateOneOrTwo(scanner.next());
            if(answer == 1){
                isContinueGame = true;
            }else if(answer == 2){
                isContinueGame = false;
            }

        }


    }
}
