package precourse.game;

public record TurnResult(int numberLength, int ball, int strike) {
    public static TurnResult of(String numbers, String userNumbers){
        int strike = 0, ball = 0;
        int numberLength = numbers.length();
        for (int i = 0; i < numberLength; i++) {
            int idx = numbers.indexOf(userNumbers.charAt(i));
            if (idx == -1)
                continue;
            if (idx == i)
                strike++;
            else
                ball++;
        }
        return new TurnResult(numberLength, strike, ball);
    }

    public boolean isAllStrike(){
        return numberLength == strike;
    }

    @Override
    public String toString() {
        if (ball + strike == 0)
            return "낫싱";

        StringBuilder stringBuilder = new StringBuilder();
        if (ball > 0)
            stringBuilder.append(ball).append("볼 ");
        if (strike > 0)
            stringBuilder.append(strike).append("스트라이크");

        return stringBuilder.toString();
    }
}
