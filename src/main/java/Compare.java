public class Compare {
    public int countBallSum(int[] computer, int[] player){
        int result=0;
        for(int i=0; i<3; i++){
            for(int j=0;j<3;j++){
                if(player[i] == computer[j]){
                    result +=1;
                }
            }
        }//깊이 2이내 구현 실패했습니다....
        return result;
    }

    public int countStrike(int[] computer, int[] player){
        int strike=0;
        for (int i=0; i<3; i++){
            if(computer[i] == player[i]){
                strike +=1;
            }
        }
        return strike;
    }





}
