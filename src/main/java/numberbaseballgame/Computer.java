package numberbaseballgame;
import java.util.Random;

public class Computer {
    private GameNumber answerNumber = new GameNumber();

    public Computer() {
        setRandomAnswer();
    }

    public GameNumber getAnswerNumber(){
        return answerNumber;
    }

    public void setRandomAnswer() {
        Random random = new Random();
        do {
            int randomNumber = random.nextInt(900) + 100;
            answerNumber.setGameNumber(randomNumber);
        } while (!(answerNumber.isNumberInRange() && answerNumber.isNumberUnique()));
    }

    public void setAnswer(int firstNumber, int secondNumber, int thirdNumber) {
        answerNumber.setGameNumber(firstNumber, secondNumber, thirdNumber);
    }

    private int[] calculateResult(GameNumber number) {
        int[] result = {0, 0};
        int[] usedCountInAnswerNumber = new int[10];
        usedCountInAnswerNumber[answerNumber.getFirstNumber()]++;
        usedCountInAnswerNumber[answerNumber.getSecondNumber()]++;
        usedCountInAnswerNumber[answerNumber.getThirdNumber()]++;
        int[] usedCountInUserNumber = new int[10];
        usedCountInUserNumber[number.getFirstNumber()]++;
        usedCountInUserNumber[number.getSecondNumber()]++;
        usedCountInUserNumber[number.getThirdNumber()]++;
        for(int i = 0; i < usedCountInAnswerNumber.length; i++) {
            result[1] += Math.min(usedCountInAnswerNumber[i], usedCountInUserNumber[i]);
        }
        if (number.getFirstNumber() == answerNumber.getFirstNumber()) {
            result[0]++;
            result[1]--;
        }
        if (number.getSecondNumber() == answerNumber.getSecondNumber()) {
            result[0]++;
            result[1]--;
        }
        if (number.getThirdNumber() == answerNumber.getThirdNumber()) {
            result[0]++;
            result[1]--;
        }
        return result;
    }

    public boolean isItAnswer(GameNumber number) {
        return answerNumber.equals(number);
    }

    public String returnHintString(GameNumber number) {
        int[] result = calculateResult(number);
        if (result[0] == 0 && result[1] == 0) {
            return "낫싱";
        }
        String resultString = "";
        if (result[1] != 0) {
            resultString += result[1] + "볼 ";
        }
        if (result[0] != 0) {
            resultString += result[0] + "스트라이크";
        }
        return resultString;
    }
}