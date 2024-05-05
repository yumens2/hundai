package com.ktc2.precourse.baseball.io.acceptor;

import com.ktc2.precourse.baseball.io.logger.RetryAcceptationLogger;
import com.ktc2.precourse.baseball.io.logger.TerminalLogger;
import com.ktc2.precourse.baseball.object.Retry;
import com.ktc2.precourse.baseball.validator.RetryValidator;
import com.ktc2.precourse.baseball.validator.Validator;

/**
 * 표준 입력으로부터 Retry를 받는 클래스
 */
public class RetryAcceptor extends SystemInAcceptor<Retry> {
    @Override
    protected Retry mapToDto(String input) {
        if (input.matches("1")) {
            return Retry.CONTINUE;
        } else {
            return Retry.EXIT;
        }
    }

    @Override
    protected TerminalLogger getLogger() {
        return RetryAcceptationLogger.getInstance();
    }

    @Override
    protected Validator<String> getValidator() {
        return RetryValidator.getInstance();
    }
}
