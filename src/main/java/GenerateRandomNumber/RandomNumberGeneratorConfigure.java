package GenerateRandomNumber;

public enum RandomNumberGeneratorConfigure {
    LENGTH(3), // 생성할 난수의 길이
    MAX_VALUE(10), // 난수의 최대값
    MIN_VALUE(0); // 난수의 최소값

    final int value;

    RandomNumberGeneratorConfigure(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static boolean validationConfigure() {
        return LENGTH.getValue() <= 10    // 최대 10자리까지 생성 가능
            && LENGTH.getValue() >= 1     // 최소 1자리 이상 생성 가능
            && MAX_VALUE.getValue() <= 10 // 최대값은 10
            && MAX_VALUE.getValue() >= 1  // 최소값은 1
            && MIN_VALUE.getValue() <= 10 // 최대값은 10
            && MIN_VALUE.getValue() >= 0  // 최소값은 0
            && MAX_VALUE.getValue() > MIN_VALUE.getValue() // 최대값은 최소값보다 커야함
            && LENGTH.getValue() <= MAX_VALUE.getValue() - MIN_VALUE.getValue()
            // 생성할 난수의 길이는 최대값과 최소값의 차이보다 작아야함

            // 최소값이 0이고 최대값이 1일 때는 난수를 생성할 수 없음
            // 0이상 1미만의 수는 0으로 제한되기 때문에, 맨 앞자리가 0인 수는 생성할 수 없음
            && !(MIN_VALUE.getValue() == 0 && MAX_VALUE.getValue() == 1);
    }
}