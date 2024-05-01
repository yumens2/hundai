package view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import util.Console;
import util.InputValidator;

public class InputView {
    private static final String INPUT_REQUEST_MSG = "숫자를 입력해 주세요 : ";
    private static final String RESTART_REQUEST_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. : ";


    public static List<Integer> printInputRequest(){
        System.out.print(INPUT_REQUEST_MSG);
        String input = Console.readLine();
        InputValidator.validateHumanValues(input);
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int printRestartRequest(){
        System.out.println(RESTART_REQUEST_MSG);
        String input = Console.readLine();
        InputValidator.validateGameType(input);

        return Integer.parseInt(input);
    }
}
