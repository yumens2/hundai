package io;

import Validation.ValidateInput;

import java.util.ArrayList;
import java.util.Scanner;

public class Input {

    public static ArrayList<Integer> inputNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        String input = scanner.nextLine();

        ValidateInput.isValidateInput(input);

        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            numbers.add(Integer.parseInt(String.valueOf(input.charAt(i))));
        }

        return numbers;
    }


}
