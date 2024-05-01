import java.util.ArrayList;

public class ResultChecker {

    public boolean checkRes(ArrayList<Integer> userInput, ArrayList<Integer> target){
        int ball = 0,strike = 0;
        String res = "";
        for(int i = 0;i<Constant.NUM;i++) {
            if (userInput.get(i).equals(target.get(i))) strike++;
            else if (target.contains(userInput.get(i))) ball++;
        }

        if(ball > 0) res = res.concat(ball + "볼 ");
        if(strike > 0) res = res.concat(strike + "스트라이크");
        if(ball + strike == 0) res = res.concat("낫싱");
        System.out.println(res);

        return strike != Constant.NUM;
    }
}
