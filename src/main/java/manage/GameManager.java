package src.main.java.manage;

import src.main.java.config.ConfigurationObject;
import src.main.java.participant.Participant;
import src.main.java.problem.ValueChecker;
import src.main.java.problem.ValueMaker;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private ConfigurationObject configurationObject = new ConfigurationObject();

    private String problemValue;

    private ValueMaker valueMaker = configurationObject.getValueMaker();
    private ValueChecker valueChecker = configurationObject.getValueChecker(problemValue);
    private Participant participant = configurationObject.getParticipant();


    public void readyGame() {
        System.out.println("⚾ 숫자 야구 시작~!");
        this.problemValue = valueMaker.makeNum();
    }

    public String proceedInput() {
        String input = participant.inputValue();
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력 잘못 됨.");
        }

        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        for (int i = 0; i < 3; i++) {
            if (list.indexOf(input.charAt(i)) == -1) {
                throw new IllegalArgumentException("입력 잘못 됨.");
            }
            list.remove(input.charAt(i));
        }

        return input;
    }

    public int proceedOutput(String input) {
        String str = valueChecker.determineTheValue(input);

        System.out.println(str);

        if (str == "3 STRIKE") {
            return 1;
        }
        return 0;
    }

}
