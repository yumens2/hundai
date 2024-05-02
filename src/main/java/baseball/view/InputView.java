package baseball.view;

import baseball.exception.InputException;
import baseball.exception.RetryException;
import baseball.utils.StringToArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class InputView {

    private List<Integer> playerNumbers = new ArrayList<>();
    private int retryNumbers;
    private InputException inputException = new InputException();
    private RetryException retryException = new RetryException();
    private String input;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void printInput() {
        System.out.print("숫자를 입력해 주세요: ");
    }

    public void getInput() throws IOException {
        this.input = br.readLine();
    }


    public void checkInput(String input) {
        inputException.inputValidation(input);
    }

    public void checkRetryInput(String input) {
        retryException.retryValidation(input);
    }

    public void toArrayList(String input) {
        playerNumbers = StringToArrayList.parse(input);
    }


    public void setPlayerNumber() throws IOException {
        printInput();
        getInput();
        checkInput(input);
        toArrayList(input);
    }

    public void setRetryInput() throws IOException {
        getInput();
        checkRetryInput(input);
        retryNumbers = Integer.parseInt(input);
    }

    public int getRetryNumbers() {
        return retryNumbers;
    }

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }


}
