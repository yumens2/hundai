package com.ktc2.precourse.baseball.io.logger;

/**
 * GameExitException을 처리할 때 터미널에 관련 사항을 출력하는 클래스
 */
public class GameExitExceptionLogger implements TerminalLogger {
    private static final GameExitExceptionLogger instance = new GameExitExceptionLogger();
    private GameExitExceptionLogger() {}
    public static GameExitExceptionLogger getInstance() {
        return instance;
    }

    @Override
    public void log() {
        System.out.println("숫자야구 게임을 종료합니다.");
    }
}
