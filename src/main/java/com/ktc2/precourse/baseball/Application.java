package com.ktc2.precourse.baseball;

import com.ktc2.precourse.baseball.exception.GameExitException;

public class Application {
    /**
     * Application Main Entry
     * @param args main entry arguments
     */
    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {
        try {
            while (true) {
                NumberBaseballGame.play();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException");
        } catch (GameExitException e) {
            System.out.println("GameExitException");
        }
    }
}
