import java.util.List;
import java.util.Objects;

public class compare {
    public int cnt_hit(List<Integer> computer, List<Integer> user){
        int cnt = 0;
        for (Integer integer : user) {
            if (computer.contains(integer)) {
                cnt += 1;
            }
        }
        return cnt;
    }

    public int cnt_strike(List<Integer> computer, List<Integer> user){
        int cnt = 0;
        for(int i = 0; i < user.size(); i++){
            if(Objects.equals(computer.get(i), user.get(i))){
                cnt += 1;
            }
        }
        return cnt;
    }

    public String compareNum(List<Integer> computer, List<Integer> user){

        int hit = cnt_hit(computer, user);
        int strike = cnt_strike(computer, user);
        int ball = hit - strike;

        if(hit == 0){
            return "낫싱";
        }else if(strike == 0){
            return ball + "볼";
        }else if(ball == 0){
            return strike + "스트라이크";
        }else {
            return ball + "볼 " + strike + "스트라이크";
        }

    }
}
