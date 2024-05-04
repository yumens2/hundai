import java.util.ArrayList;
import java.util.Random;

// 랜덤 숫자 생성
public class CreateRandom {
    public int createNum(){
        Random random = new Random();
        return random.nextInt(9)+1;
    }
    public ArrayList<Integer> createList(){
        ArrayList<Integer> randomList = new ArrayList<Integer>();

        while(randomList.size() < 3){
            int rand = createNum();
            if (randomList.contains(rand)){
                continue;
            }
            else{
                randomList.add(rand);
            }
        }
        return randomList;
    }
}

