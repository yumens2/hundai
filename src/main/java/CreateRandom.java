import java.util.ArrayList;
import java.util.Random;

// 랜덤 숫자 생성
public class CreateRandom {
    private ArrayList<Integer> randomList = new ArrayList<>();
    private Random random = new Random();
    public int createNum(){
        return random.nextInt(9)+1;
    }
    public ArrayList<Integer> createList(){
        randomList.clear();

        while(randomList.size() < 3){
            int rand = createNum();
            if (!(randomList.contains(rand))){
                randomList.add(rand);
            }
        }
        return randomList;
    }
}

