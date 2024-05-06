package model;

import java.util.List;

import static model.GenerateRandomNumber.DIGIT;

/**
 *  correct -> Ask replay
 *  incorrect -> call Hint class
 */
public class AnswerChecker {

    public Hint checkAnswer (List<Integer> answer, List<Integer> userInput) {
        Hint hint = new Hint();
        for (int i = 0; i < userInput.size(); i++) {
            int answerI = answer.get(i);
            int userI = userInput.get(i);
            if (answerI == userI) {
                hint.increaseStrike();
            }
            else if(userInput.contains(answerI)) {  // contains
                hint.increaseBall();
            }
        }
        return hint;
    }

        public boolean isFinished (Hint hint) {
        return hint.getStrike() == DIGIT;
    }

}
