package com.ktc2.precourse.baseball.io;

public class NumbersAcceptationLogger implements TerminalLogger{
    private static final NumbersAcceptationLogger instance = new NumbersAcceptationLogger();

    private NumbersAcceptationLogger() {}

    public static NumbersAcceptationLogger getInstance() {
        return instance;
    }

    @Override
    public void log() {
        System.out.print("숫자를 입력해주세요: ");
    }
}
