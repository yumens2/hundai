public class Application {

    public static void main(String[] args) {
        boolean continueFlag = true;
        boolean makeFlag = true;
        int[] randomNumbers = Utility.makeRandomNumbers();
        int[] userNumbers;

        while (continueFlag) {
            if (makeFlag) {
                makeFlag = false;
                randomNumbers = Utility.makeRandomNumbers();
            }

            System.out.print("숫자를 입력해 주세요 : ");
            String userString = Utility.getUserString();

            try {
                Utility.checkStringLength(userString);
                Utility.checkStringDistinct(userString);
                Utility.checkStringDigit(userString);
            } catch (IllegalArgumentException e) {
                System.out.print("올바르지 않은 입력입니다. ");
                break;
            }

            userNumbers = Utility.stringToIntArray(userString);

            int strike = Utility.strikeCount(randomNumbers, userNumbers);
            int ball = Utility.ballCount(randomNumbers, userNumbers);

            System.out.println(Utility.getStrikeBall(strike, ball));

            Utility.printEndMessage(strike);

            if (strike == 3) {
                userString = Utility.getUserString();
                makeFlag = true;
            }

            try {
                continueFlag = Utility.checkKeepGoing(userString, strike);
            } catch (IllegalArgumentException e) {
                System.out.print("올바르지 않은 입력입니다. ");
                break;
            }
        }

        System.out.println("애플리케이션을 종료합니다.");
    }
}
