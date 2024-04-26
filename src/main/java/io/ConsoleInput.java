package io;

import error.Validator;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private final Scanner scanner;
    public ConsoleInput(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getNumberFromPlayer() {
        System.out.print("숫자를 입력해 주세요 : ");
        String input = scanner.next();
        Validator.validateNumberInput(input);
        return input;
    }

    @Override
    public String getRestartNumberFromPlayer() {
        String input = scanner.next();
        Validator.validateRestartInput(input);
        return input;
    }
}
