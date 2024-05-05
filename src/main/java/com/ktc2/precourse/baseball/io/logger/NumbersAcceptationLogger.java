package com.ktc2.precourse.baseball.io.logger;

/**
 * System.in으로부터 Numbers를 얻을 때 터미널에 인터랙션을 출력하는 클래스
 */
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
