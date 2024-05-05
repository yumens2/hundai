package com.ktc2.precourse.baseball;

import com.ktc2.precourse.baseball.exception.GameExitException;
import com.ktc2.precourse.baseball.io.acceptor.NumbersAcceptor;
import com.ktc2.precourse.baseball.io.acceptor.RetryAcceptor;
import com.ktc2.precourse.baseball.logic.MatchResultCreator;
import com.ktc2.precourse.baseball.logic.NumbersSelector;
import com.ktc2.precourse.baseball.object.MatchResult;
import com.ktc2.precourse.baseball.object.Numbers;
import com.ktc2.precourse.baseball.object.Retry;

import java.util.Objects;

public class NumberBaseball {
    private final static NumbersSelector numbersSelector = new NumbersSelector();
    private final static NumbersAcceptor numbersAcceptor = new NumbersAcceptor();
    private final static MatchResultCreator matchResultCreator = new MatchResultCreator();
    private final static RetryAcceptor retryAcceptor = new RetryAcceptor();

    private static void gameRetryOrExit() {
        Retry retry = retryAcceptor.getDtoBySystemIn();
        if (Objects.requireNonNull(retry) == Retry.EXIT) {
            throw new GameExitException();
        }
    }

    public static synchronized void play() {
        Numbers computer = numbersSelector.get();

        while (true) {
            Numbers player = numbersAcceptor.getDtoBySystemIn();
            MatchResult result = matchResultCreator.getCompareResult(computer, player);

            if (result.isAllStrike()) {
                gameRetryOrExit();
                return;
            } else {
                System.out.println(result);
            }
        }
    }
}
