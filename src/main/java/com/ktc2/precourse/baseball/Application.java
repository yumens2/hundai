package com.ktc2.precourse.baseball;

import com.ktc2.precourse.baseball.logic.ExceptionHandler;

public class Application {
    /**
     * Application Main Entry
     * @param args main entry arguments
     */
    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {
        ExceptionHandler exceptionHandler = new ExceptionHandler(() -> {
            while (true) {
                NumberBaseball.play();
            }
        });
        exceptionHandler.runProcess();
    }
}
