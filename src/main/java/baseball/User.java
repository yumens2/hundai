package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class User {
    //숫자 입력받기
    public List<Integer> userNumber() throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        System.out.println("숫자를 입력해 주세요");
        String num=br.readLine();
        List<Integer> playerNumber = new ArrayList<>();
        for(String number: num.split("")){
            playerNumber.add(Integer.parseInt(number));
        }
        br.close();
        return playerNumber;
    }
    public boolean isPossible(List<Integer> userNumber)throws IllegalArgumentException{
        if(userNumber.size()!=3){
            throw new IllegalArgumentException("잘못된 숫자를 입력하셨습니다.");
        }
        for(int i=0; i<userNumber.size(); i++){
            if(!check(userNumber.get(i),i,userNumber)){
                throw new IllegalArgumentException("잘못된 숫자를 입력하셨습니다.");
            }
        }
        return true;
    }
    public boolean check(int num, int index, List<Integer> userNumber){
        for(int i=0; i<userNumber.size(); i++){
            if(i!=index&&userNumber.get(i)==num){
                return false;
            }
        }
        return true;
    }
}
