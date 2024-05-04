package baseball;

import java.util.List;

public class Baseball {
    public int ball(List<Integer> baseballNum, List<Integer> userNum){
        int count=0;
        for(int i=0; i<3; i++){
            if(baseballNum.contains(userNum.get(i))){
                count++;
            }
        }
        return count;
    }
    public int strike(List<Integer> baseballNum,List<Integer>userNum){
        int count=0;
        for(int i=0; i<3; i++){
            if(baseballNum.get(i)==userNum.get(i)){
                count++;
            }
        }
        return count;
    }
    public String ballCount(int ball, int strike){
        if(strike>0){
            ball-=strike;
        }
        if(ball==0 && strike==0){
            return "낫싱";
        }
        else if(ball==0){
            return strike+"스트라이크";
        }
        else if(strike==0){
            return ball+"볼";
        }
        return ball+"볼"+strike+"스트라이크";

    }
    public boolean replay(){
        System.out.println("축하합니다! 경기를 다시 시작하시겠습니까? ");
    }
}
