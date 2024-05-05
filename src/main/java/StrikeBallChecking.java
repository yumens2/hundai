public class StrikeBallChecking {

    public int[] countStrikeBall(int[] cpunum, int[] playernum, int[] strikeballcount) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < cpunum.length; i++) {
            for (int j = 0; j < playernum.length; j++) {
                int[] result = StrikeBall(cpunum, playernum, i, j);
                strike += result[0];
                ball += result[1];
            }
        }
        strikeballcount[0] = strike;
        strikeballcount[1] = ball;
        return strikeballcount;
    }

    private int[] StrikeBall(int[] cpunum, int[] playernum, int i, int j) {
        int strike = 0;
        int ball = 0;
        if ((cpunum[i] == playernum[j]) && i == j) {
            strike++;
        }
        if ((cpunum[i] == playernum[j]) && i != j) {
            ball++;
        }
        return new int[]{strike, ball};
    }

    public void outputresult(int[] strikeballcount) {
        if ((strikeballcount[0] != 0) && (strikeballcount[1] != 0)) {
            System.out.println(strikeballcount[1] + "볼 " + strikeballcount[0] + "스트라이크");
        } else if ((strikeballcount[0] == 0) && (strikeballcount[1] == 0)) {
            System.out.println("낫싱");
        } else if ((strikeballcount[0] == 0) && (strikeballcount[1] != 0)) {
            System.out.println(strikeballcount[1] + "볼");
        } else {
            System.out.println(strikeballcount[0] + "스트라이크");
        }
    }
}
