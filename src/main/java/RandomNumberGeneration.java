import java.util.*;

public class RandomNumberGeneration {

    public static List<Integer> randomNumberProduce(){
        List<Integer> number = new ArrayList<>();

        while(number.size() < 3){
            int randomNum = (int)(Math.random()*9) + 1;

            if(!number.contains(randomNum)){
                number.add(randomNum);
            }
        }

        return number;
    }
}
