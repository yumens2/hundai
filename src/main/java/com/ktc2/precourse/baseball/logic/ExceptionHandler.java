package com.ktc2.precourse.baseball.logic;

import com.ktc2.precourse.baseball.exception.GameExitException;
import com.ktc2.precourse.baseball.io.GameExitExceptionLogger;
import com.ktc2.precourse.baseball.io.IllegalArgumentExceptionLogger;

public class ExceptionHandler{
    private final Runnable process;

    public ExceptionHandler(Runnable process) {
        this.process = process;
    }

    public void runProcess() {
        try {
            process.run();
        } catch (IllegalArgumentException e) {
            IllegalArgumentExceptionLogger.getInstance().log();
        } catch (GameExitException e) {
            GameExitExceptionLogger.getInstance().log();
        }
    }
}
