import java.util.ArrayList;
import java.util.List;

public class inputNum {
    public List<Integer> numToList(String inputValue){
        List<Integer> inputNum = new ArrayList<>();

        for(char c: inputValue.toCharArray()){
            inputNum.add(Integer.parseInt(String.valueOf(c)));
        }
        return inputNum;

    }
}
