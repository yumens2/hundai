package com.ktc2.precourse.baseball.io.acceptor;

import com.ktc2.precourse.baseball.io.logger.NumbersAcceptationLogger;
import com.ktc2.precourse.baseball.io.logger.TerminalLogger;
import com.ktc2.precourse.baseball.object.Numbers;
import com.ktc2.precourse.baseball.validator.NumbersValidator;
import com.ktc2.precourse.baseball.validator.Validator;

/**
 * 표준 입력으로부터 Numbers를 받는 클래스
 */
public class NumbersAcceptor extends SystemInAcceptor<Numbers>{

    @Override
    protected Numbers mapToDto(String input) {
        int[] digit = input.chars().map(s -> s - '0').toArray();
        return new Numbers(digit[0], digit[1], digit[2]);
    }

    @Override
    protected TerminalLogger getLogger() {
        return NumbersAcceptationLogger.getInstance();
    }

    @Override
    protected Validator<String> getValidator() {
        return NumbersValidator.getInstance();
    }
}
