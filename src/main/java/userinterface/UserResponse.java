package userinterface;

import domain.Result;

import static userinterface.constant.UserMessageConstants.*;

public class UserResponse {

    public void printGuessMessage() {
        System.out.print(GUESS_MESSAGE);
    }

    public void printResult(Result result) {
        System.out.println(result);
    }

    public void printReplayMessage() {
        System.out.println(REPLAY_MESSAGE);
    }
}
