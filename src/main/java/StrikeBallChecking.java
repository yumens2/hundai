public class StrikeBallChecking {

    public int[] countStrikeBall(int[] cpunum, int[] playernum,int[] strikeball){
        int strike = 0;
        int ball = 0;
        for(int i = 0; i < cpunum.length; i++){
            for(int j = 0; j < playernum.length; j++){
                int[] result = StrikeBall(cpunum,playernum,i,j);
                strike += result[0];
                ball += result[1];
            }
        }
        strikeball[0] = strike;
        strikeball[1] = ball;
        return strikeball;
    }
    private int[] StrikeBall(int[] cpunum, int[] playernum, int i, int j){
        int strike = 0;
        int ball = 0;
        if((cpunum[i] == playernum[j]) && i == j){
            strike++;
        }
        if((cpunum[i] == playernum[j]) && i != j){
            ball++;
        }
        return new int[]{strike, ball};
    }
}
