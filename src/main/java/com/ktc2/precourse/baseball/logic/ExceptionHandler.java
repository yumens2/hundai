package com.ktc2.precourse.baseball.logic;

import com.ktc2.precourse.baseball.exception.GameExitException;
import com.ktc2.precourse.baseball.io.logger.GameExitExceptionLogger;
import com.ktc2.precourse.baseball.io.logger.IllegalArgumentExceptionLogger;

/**
 * process에서 발생하는 exception을 핸들링하는 클래스
 */
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
