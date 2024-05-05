public class Hint {
    public static String hint(int a, int b) {
        int strikes = 0;
        int balls = 0;

        int[] computer = new int[3];
        int[] user = new int[3];

        computer[0] = a / 100;
        computer[1] = (a / 10) % 10;
        computer[2] = a % 10;

        user[0] = b /100;
        user[1] = (b / 10) % 10;
        user[2] = b % 10;

        // 스트라이크 계산
        for (int i = 0; i < 3; i++) {
            if (computer[i] == user[i]) {
                strikes++;
            }
        }

        // 볼 계산
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (computer[i] == user[j] && i != j) {
                    balls++;
                }
            }
        }

        // 힌트 문자열 생성
        String hint = "";
        if (strikes > 0) {
            hint += strikes + "스트라이크";
        }
        if (balls > 0) {
            hint += balls + "볼";
        }
        if (strikes == 0 && balls == 0) {
            hint = "낫싱";
        }

        return hint;

    }
}
