package UserInput;

import GenerateRandomNumber.RandomNumberGeneratorConfigure;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class UserPredictNumber {

    public static List<Integer> predictInput() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = null;
        try {
            inputString = bufferedReader.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }

        // 사용자의 입력이 숫자가 아닌 경우, 중복된 숫자가 있는 경우, 입력한 숫자의 길이가 지정된 길이가 아닌 경우 예외 발생
        if (!validationPredictInputNotEqualLength(inputString)) {
            throw new IllegalArgumentException();
        }
        if (!validationPredictInputNotNumber(inputString)) {
            throw new IllegalArgumentException();
        }
        if (!validationPredictInputSameNumber(inputString)) {
            throw new IllegalArgumentException();
        }

        // 사용자의 입력을 List<Integer>로 변환하여 리턴
        List<Integer> input = new LinkedList<>();
        for (int i = 0; i < RandomNumberGeneratorConfigure.LENGTH.getValue(); i++) {
            input.add(Integer.parseInt(String.valueOf(inputString.charAt(i))));
        }

        return input;
    }

    // 사용자의 입력이 숫자가 아닌 경우 false, 숫자인 경우 true 리턴
    private static boolean validationPredictInputNotNumber(String inputString) {
        for (int i = 0; i < inputString.length(); i++) {
            if (!Character.isDigit(inputString.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    // 사용자의 입력한 숫자 중 중복된 숫자가 있는 경우 false, 중복된 숫자가 없는 경우 true 리턴
    private static boolean validationPredictInputSameNumber(String inpuString) {
        List<String> splitString = Arrays.asList(inpuString.split(""));
        Set<String> set = new HashSet<>(splitString);
        return splitString.size() == set.size();
    }

    // 사용자의 입력한 숫자의 길이가 지정된 길이가 아닌 경우 false, 이외의 경우 true 리턴
    private static boolean validationPredictInputNotEqualLength(String inputString) {
        return inputString.length() == RandomNumberGeneratorConfigure.LENGTH.getValue();
    }
}