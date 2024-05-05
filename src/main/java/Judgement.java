import java.util.ArrayList;

public class Judgement {

    public int[] judge(ArrayList<Integer> target, ArrayList<Integer> user){
        int[] count = {0, 0};

        for(int i=0; i<3; i++){
            if (target.contains(user.get(i))){
                count[0] += 1;
            }
            if ((target.get(i)).equals(user.get(i))){
                count[0] -= 1;
                count[1] += 1;
            }
        }
        return count;
    }
    public void result(int[] cnt){
        if (cnt[0] ==0 && cnt[1] == 0){
            System.out.println("낫싱");
        }
        else if(cnt[0] != 0 && cnt[1] == 0){
            System.out.println(cnt[0]+"볼");
        }
        else if(cnt[0] == 0 && cnt[1] != 0){
            System.out.println(cnt[1]+"스트라이크");
        }
        else{
            System.out.println(cnt[0]+"볼 "+cnt[1]+"스트라이크");
        }

        if (cnt[1] == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }
}
