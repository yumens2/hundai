package com.ktc2.precourse.baseball.io.logger;

public class IllegalArgumentExceptionLogger implements TerminalLogger {
    private static final IllegalArgumentExceptionLogger instance = new IllegalArgumentExceptionLogger();
    private IllegalArgumentExceptionLogger() {}
    public static IllegalArgumentExceptionLogger getInstance() {
        return instance;
    }

    @Override
    public void log() {
        System.out.println("잘못된 입력이 들어왔습니다. 숫자야구 게임을 종료합니다.");
    }
}
