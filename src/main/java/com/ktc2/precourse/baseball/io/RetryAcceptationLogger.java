package com.ktc2.precourse.baseball.io;

import com.ktc2.precourse.baseball.object.Numbers;

public class RetryAcceptationLogger implements TerminalLogger {
    private static final RetryAcceptationLogger instance = new RetryAcceptationLogger();
    private RetryAcceptationLogger() {}
    public static RetryAcceptationLogger getInstance() {
        return instance;
    }

    @Override
    public void log() {
        System.out.println(Numbers.LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
    }
}
