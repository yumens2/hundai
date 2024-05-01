package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGenerator {

    public static List<Integer> generateRandomValue(final int capacity){
        if(capacity < 1 || capacity > 9){
            throw new IllegalArgumentException("랜덤값 자릿수는 1이상 9이하 입니다.");
        }
        boolean[] appended = new boolean[10];
        Random random = new Random();
        List<Integer> randomValues = new ArrayList<>(capacity);
        for(int i = 0; i < capacity; i++){
            int generatedRandomValue = random.nextInt(9) + 1;

            while(appended[generatedRandomValue]){
                generatedRandomValue = random.nextInt(9) + 1;
            }

            appended[generatedRandomValue] = true;
            randomValues.add(generatedRandomValue);
        }return randomValues;
    }
}
