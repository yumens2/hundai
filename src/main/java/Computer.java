import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Computer {
    public List<Integer> setComNum(){
        Random r = new Random();
        List<Integer> comNum = new ArrayList<>();
        for (int i=0 ; i<3 ; i++) {
            comNum.add(r.nextInt(1, 9));
        }
        return comNum;

    }
}
