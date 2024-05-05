
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Input {
    public List<Integer> playerNumber(){
        System.out.print("숫자를 입력해주세요 : ");
        Scanner scanner = new Scanner(System.in);
        List<Integer> playerNum = new ArrayList<>();
        String input = scanner.next();

        for(String number: input.split("")){
            playerNum.add(Integer.parseInt(number));
        }
        return playerNum;
    }

    public boolean isValid(List<Integer> data){
        if(data.size()!=3){
            throw new IllegalArgumentException();
        }
        for(Integer num : data){
            if(num <1 || num > 9){
                throw new IllegalArgumentException();
            }
        }
        Set<Integer> set = new HashSet<>(data);
        if(set.size()!=data.size()){
            throw new IllegalArgumentException();
        }
        return true;
    }
}
